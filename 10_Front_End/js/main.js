let id;
let status;

let jobs = [];
let currentPage = 1;
const pageSize = 5;

function renderTable(pageData) {
    let tbody = $("#jobsTableBody");
    tbody.empty();

    if (pageData.length === 0) {
        tbody.append(`<tr><td colspan="7" class="text-center">No results found</td></tr>`);
    } else {
        $.each(pageData, function (index, job) {
            let row = `
                <tr>
                    <td>${job.id}</td>
                    <td>${job.jobTitle}</td>
                    <td>${job.company}</td>
                    <td>${job.location}</td>
                    <td>${job.type}</td>
                    <td>
                        ${job.status}
                        <button class="btn btn-warning" onclick="editStatus(${job.id})">Deactivate</button>
                    </td>
                    <td>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editJobModal" onclick="editJob(${job.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteJob(${job.id})">Delete</button>
                    </td>
                </tr>
            `;
            tbody.append(row);
        });
    }
}

function updateTable() {
    const startIndex = (currentPage - 1) * pageSize;
    const pageData = jobs.slice(startIndex, startIndex + pageSize);
    renderTable(pageData);
    $("#currentPage").text(`Page ${currentPage}`);
}

function loadJobs() {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/get",
        method: "GET",
        success: function (data) {
            jobs = data;
            currentPage = 1;
            updateTable();
        },
        error: function () {
            alert("Failed to load jobs.");
        }

    });
}

$("#searchInput").keyup(function () {
    let keyword = $(this).val().trim();

    // Clear previous suggestions
    $("#searchResults").empty();

    if (keyword.length === 0) {
        $("#searchResults").hide(); // Hide suggestions
        loadJobs(); // Load all jobs if input is empty
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/job/search/" + keyword,
        method: "GET",
        success: function (data) {
            jobs = data;
            currentPage = 1;
            updateTable();

            // Add suggestions to the dropdown
            if (data.length > 0) {
                data.forEach(function (job) {
                    let suggestionItem = `<li class="list-group-item list-group-item-action">${job.jobTitle}</li>`;
                    $("#searchResults").append(suggestionItem);
                });
                $("#searchResults").show();
            } else {
                $("#searchResults").hide();
            }
        },
        error: function () {
            $("#jobsTableBody").empty();
            $("#jobsTableBody").append(`<tr><td colspan="7" class="text-center">Error loading results</td></tr>`);
            $("#searchResults").hide();
        }
    });
});

// Handle click on a suggestion item
$("#searchResults").on("click", "li", function () {
    $("#searchInput").val($(this).text());
    $("#searchResults").hide();
});


$("#prevPage").click(function () {
    if (currentPage > 1) {
        currentPage--;
        updateTable();
    }
});

$("#nextPage").click(function () {
    const maxPage = Math.ceil(jobs.length / pageSize);
    if (currentPage < maxPage) {
        currentPage++;
        updateTable();
    }
});

$(document).ready(function () {
    loadJobs();
});


function deleteJob(jobId) {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/delete/" + jobId,
        method: "DELETE",
        success: function (response) {
            alert("Job deleted successfully!");
            loadJobs();
        },
        error: function(error) {
            console.error('Error deleting job:', error);
        }
    });
}

function editStatus(jobId) {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/status/" + jobId,
        method: "PATCH",
        success: function (response) {
            alert("Job status updated successfully!");
            loadJobs();
        },
        error: function(error) {
            console.error('Error updating job status:', error);
        }

    })
}

function getSelectRow(jobId, callback) {

    id = jobId

    $.ajax({
        url: "http://localhost:8080/api/v1/job/row/" + jobId,
        method: "GET",
        success: function (data) {
            callback(data);
        },
        error: function () {
            alert("Job not found");
            callback(null);
        }
    });
}

function editJob(jobId) {
    getSelectRow(jobId, function(row) {
        if (row) {
            $('#editJobTitle').val(row.jobTitle);
            $('#editCompanyName').val(row.company);
            $('#editJobLocation').val(row.location);
            $('#editJobType').val(row.type);
            $('#editJobDescription').val(row.jobDescription);
            status = row.status
        }
    });
}


$("#updateJobBtn").click(function () {

    var jobId = id;

    let jobTitle = $("#editJobTitle").val();
    let companyName = $("#editCompanyName").val();
    let jobLocation = $("#editJobLocation").val();
    let jobType = $("#editJobType").val();
    let description = $("#editJobDescription").val();

    console.log(jobId)
    console.log(jobTitle);
    console.log(companyName);
    console.log(jobLocation);
    console.log(jobType);

    let job = {
        id: jobId,
        jobTitle: jobTitle,
        company: companyName,
        location: jobLocation,
        type: jobType,
        jobDescription: description,
        status: status
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/job/update/" + jobId,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(job),
        success: function (response) {
            alert("Job updated successfully!");
            loadJobs();
        },
        error: function(error) {
            console.error('Error updating job:', error);
        }
    });

});

// save job
$("#saveJobBtn").click(function () {
    let jobTitle = $("#jobTitle").val();
    let companyName = $("#companyName").val();
    let jobLocation = $("#jobLocation").val();
    let jobType = $("#jobType").val();
    let jobDescription = $("#jobDescription").val();
    let status = "Active";

    let job = {
        jobTitle: jobTitle,
        company: companyName,
        location: jobLocation,
        type: jobType,
        jobDescription: jobDescription,
        status: status
    };

    $.ajax({
        url: "http://localhost:8080/api/v1/job/create",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(job),
        success: function (response) {
            alert("Job added successfully!");
            location.reload();
        },
        error: function(error) {
            console.error('Error saving job:', error);
            // Optionally, show an error message to the user
        }
    });
});

