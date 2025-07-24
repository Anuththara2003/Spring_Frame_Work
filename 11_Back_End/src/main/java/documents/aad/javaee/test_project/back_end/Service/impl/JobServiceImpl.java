package documents.aad.javaee.test_project.back_end.Service.impl;

import documents.aad.javaee.test_project.back_end.DTO.JobDto;
import documents.aad.javaee.test_project.back_end.Entity.Job;
import documents.aad.javaee.test_project.back_end.Repository.JobRepository;
import documents.aad.javaee.test_project.back_end.Service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDto jobDto) {
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }

    @Override
    public void updateJob(JobDto jobDto) {
        if (jobRepository.existsById(jobDto.getId())) {
            jobRepository.save(modelMapper.map(jobDto, Job.class));
        }
    }

    @Override
    public void deleteJob(Integer id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
        }
    }

    @Override
    public void changeStatus(String id) {
            jobRepository.changeStatus(id);
    }


    @Override
    public List<JobDto> getAllJobsByKeyword(String keyword) {
        List<Job> list = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        return modelMapper.map(list,new TypeToken<List<JobDto>>(){}.getType());

    }

    @Override
    public JobDto getSelectedJob(String id) {
        int integerId = Integer.parseInt(id);
        Optional<Job> job = jobRepository.findById(integerId);
        return modelMapper.map(job.get(), JobDto.class);
    }


    @Override
    public List<JobDto> getJob( ) {
       List<Job> jobPage = jobRepository.findAll();
        return modelMapper.map(jobPage,new TypeToken<List<JobDto>>(){}.getType());

    }

}
