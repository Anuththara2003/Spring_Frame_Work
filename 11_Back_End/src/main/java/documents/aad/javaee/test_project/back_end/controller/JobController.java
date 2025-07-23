package documents.aad.javaee.test_project.back_end.controller;


import documents.aad.javaee.test_project.back_end.DTO.JobDto;
import documents.aad.javaee.test_project.back_end.Entity.Job;
import documents.aad.javaee.test_project.back_end.Service.JobService;
import documents.aad.javaee.test_project.back_end.Service.impl.JobServiceImpl;
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
    public void createJob(@RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
    }

    @PutMapping("/update/{id}")
    public void updateJob(@PathVariable Integer id, @RequestBody JobDto jobDto) {
        jobDto.setId(id);
        jobService.updateJob(jobDto);
    }

    @GetMapping("get")
    public ResponseEntity<Page<JobDto>> getJobs(
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        Page<JobDto> jobs = jobService.getJob(pageable);
        return ResponseEntity.ok(jobs);
    }
    @PatchMapping("status/{id}")
    public void changeStatus(@PathVariable String id){
        jobService.changeStatus(id);
    }

    @GetMapping("search/{keyword}")
    public List<JobDto> searchJob(@PathVariable String keyword){
        return jobService.getAllJobsByKeyword(keyword);
    }

    @GetMapping("/row/{id}")
    public JobDto getSelectedJob(@PathVariable String id){
        return jobService.getSelectedJob(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable Integer id){
        jobService.deleteJob(id);
    }

}
