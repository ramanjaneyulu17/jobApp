package com.example.JobApp.controller;

import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public  String addjob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model m){
        List<JobPost> jobs= service.viewalljobs();
        m.addAttribute("jobPosts",jobs);
        return "/viewalljobs";
    }
}
