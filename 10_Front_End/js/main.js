let id;
let status;


let currentPage = 0;
const pageSize = 5;
let totalPages = 0;

function renderTable(jobs) {
    let tbody = $("#jobsTableBody");
    tbody.empty();

    if (jobs.length === 0) {
        tbody.append(`<tr><td colspan="7" class="text-center">No results found</td></tr>`);
    } else {
        $.each(jobs, function (index, job) {
            let row = `
                <tr>
                    <td>${job.id}</td>
                    <td>${job.jobTitle}</td>
                    <td>${job.company}</td>
                    <td>${job.location}</td>
                    <td>${job.type}</td>
                   <td>
    ${job.status}
    <button class="btn btn-warning" onclick="editStatus(${job.id})">
        ${job.status === 'Active' ? 'Deactivate' : 'Activate'}
    </button>
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
function loadJobs(page = 0) {
    $.ajax({
        url: `http://localhost:8080/api/v1/job/get`,
        method: "GET",
        success: function (data) {
            renderTable(data.data); // <-- FIXED
            currentPage = 0;
            totalPages = 1;
            updatePaginationDisplay();
        },
        error: function () {
            alert("Failed to load jobs.");
        }
    });
}


function updatePaginationDisplay() {
    $("#currentPage").text(`Page ${currentPage + 1} of ${totalPages}`);
    $("#prevPage").prop("disabled", currentPage === 0);
    $("#nextPage").prop("disabled", currentPage + 1 >= totalPages);
}

function nextPage() {
    if (currentPage + 1 < totalPages) {
        loadJobs(currentPage + 1);
    }
}

function prevPage() {
    if (currentPage > 0) {
        loadJobs(currentPage - 1);
    }
}

$(document).ready(function () {
    loadJobs();

    $("#prevPage").click(prevPage);
    $("#nextPage").click(nextPage);
});


$("#searchInput").keyup(function () {
    let keyword = $(this).val().trim();

    $("#searchResults").empty();

    if (keyword.length === 0) {
        $("#searchResults").hide();
        loadJobs();
        return;
    }

    // Send search request
    $.ajax({
        url: "http://localhost:8080/api/v1/job/search/" + keyword,
        method: "GET",
        success: function (data) {

            renderTable(data);

            $("#currentPage").text("Search results");
            $("#prevPage").prop("disabled", true);
            $("#nextPage").prop("disabled", true);

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
            $("#jobsTableBody").empty().append(`
                <tr><td colspan="7" class="text-center">Error loading results</td></tr>`);
            $("#searchResults").hide();
        }
    });
});

$("#searchResults").on("click", "li", function () {
    let selectedText = $(this).text();
    $("#searchInput").val(selectedText);
    $("#searchResults").hide();

    $.ajax({
        url: "http://localhost:8080/api/v1/job/search/" + selectedText,
        method: "GET",
        success: function (data) {
            renderTable(data);
            $("#currentPage").text("Search results");
            $("#prevPage").prop("disabled", true);
            $("#nextPage").prop("disabled", true);
        },
        error: function () {
            $("#jobsTableBody").empty().append(`
                <tr><td colspan="7" class="text-center">Error loading results</td></tr>`);
        }
    });
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
        error: function (error) {
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
        error: function (error) {
            console.error('Error updating job status:', error);
        }
    });
}

function getSelectRow(jobId, callback) {
    id = jobId;

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
    getSelectRow(jobId, function (row) {
        if (row) {
            $('#editJobTitle').val(row.jobTitle);
            $('#editCompanyName').val(row.company);
            $('#editJobLocation').val(row.location);
            $('#editJobType').val(row.type);
            $('#editJobDescription').val(row.jobDescription);
            status = row.status;
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

    let job = {
        id: jobId,
        jobTitle: jobTitle,
        company: companyName,
        location: jobLocation,
        type: jobType,
        jobDescription: description,
        status: status
    };

    $.ajax({
        url: "http://localhost:8080/api/v1/job/update/" + jobId,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(job),
        success: function (response) {
            alert("Job updated successfully!");
            loadJobs();
        },
        error: function (error) {
            console.error('Error updating job:', error);
        }
    });
});

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
        error: function (error) {
            console.error('Error saving job:', error);
        }
    });
});
