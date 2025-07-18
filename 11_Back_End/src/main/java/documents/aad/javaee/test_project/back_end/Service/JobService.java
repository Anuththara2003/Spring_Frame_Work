package documents.aad.javaee.test_project.back_end.Service;

import documents.aad.javaee.test_project.back_end.DTO.JobDto;

import java.util.List;

public interface JobService {
     void saveJob(JobDto jobDto);
     void updateJob(JobDto jobDto);
    List<JobDto> getAllJobs();
    void deleteJob(Integer id);
    void changeStatus(String id);
    List<JobDto> getAllJobsByKeyword(String keyword);


    JobDto getSelectedJob(String id);
}
