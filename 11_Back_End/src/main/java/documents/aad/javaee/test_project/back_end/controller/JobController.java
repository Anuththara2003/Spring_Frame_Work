package documents.aad.javaee.test_project.back_end.controller;


import documents.aad.javaee.test_project.back_end.DTO.JobDto;
import documents.aad.javaee.test_project.back_end.Entity.Job;
import documents.aad.javaee.test_project.back_end.Service.JobService;
import documents.aad.javaee.test_project.back_end.Service.impl.JobServiceImpl;
import documents.aad.javaee.test_project.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // allow frontend origin
@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
public class JobController {
    //property Injection
    // @Autowired

    //constructor injection

    private final JobService jobService;

    @PostMapping("create")
    public ResponseEntity<APIResponse> createJob(@RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "successfully created!",
                        jobDto
                ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse> updateJob(@PathVariable Integer id, @RequestBody JobDto jobDto) {
        jobDto.setId(id);
        jobService.updateJob(jobDto);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "successfully Updated",
                        jobDto
                ));

    }

    @GetMapping("get")
    public ResponseEntity<APIResponse> getJobs() {
        List<JobDto> jobs = jobService.getJob();
        return ResponseEntity.ok(
                new APIResponse(
                       200,
                        "success",
                        jobs
                ));

    }
    @PatchMapping("status/{id}")
    public ResponseEntity<APIResponse> changeStatus(@PathVariable String id){
        jobService.changeStatus(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Active",
                        id
                ));
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse> searchJob(@PathVariable String keyword){
        List<JobDto> jobs = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "success",
                        jobs
                ));
    }

    @GetMapping("/row/{id}")
    public ResponseEntity<APIResponse> getSelectedJob(@PathVariable String id){
        JobDto jobDto = jobService.getSelectedJob(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "success",
                        jobDto
                ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteJob(@PathVariable Integer id){
        jobService.deleteJob(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "successfully deleted!",
                        id
                ));

    }

}
