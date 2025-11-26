package com.JobApp.JobAppManagement;

import com.JobApp.JobAppManagement.Model.JobPost;
import com.JobApp.JobAppManagement.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    public JobService service;

    @PostMapping("JobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @GetMapping("JobPosts/{postId}")
    public void getJob(@PathVariable int postId)
    {
        service.getJob(postId);
    }



    @GetMapping("JobPosts")
    public List<JobPost> getalljobs()
    {
        return  service.getalljobs();
    }


    @PutMapping("JobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updatejob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("JobPost/{id}")
    public void deletebyidjob(@PathVariable int id)
    {
         service.deletebyidjob(id);
    }

    @GetMapping("load")
    public String Load()
    {
        service.load();
        return  "Sucess";
    }

    @GetMapping("JobPosts/keyword/{keyword}")
    public  List<JobPost> search(@PathVariable String keyword)
    {
       return service.search(keyword);

    }
}
