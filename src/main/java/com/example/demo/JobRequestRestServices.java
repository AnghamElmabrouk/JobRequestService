package com.example.demo;


import com.example.demo.dao.JobRequestRepository;
import com.example.demo.entities.JobRequest;
import com.example.demo.service.SendEmailService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRequestRestServices {

    @Autowired
    private JobRequestRepository jobRequestRepository;


    @Autowired
    private SendEmailService sendEmailService;

   // private JavaMailSender javaMailSender;

    @GetMapping(value = "/JobRequestslist")
    public List<JobRequest> listStagiaires() {
        return jobRequestRepository.findAll();

    }

    @PostMapping(value = "/JobRequestslist")
    public JobRequest save(@RequestBody JobRequest p) {
        return jobRequestRepository.save(p);
    }


    @PostMapping("/JobRequest")
    public JSONObject createStagiaire(@RequestParam("first_name") String firstname, @RequestParam("last_name") String lastname, @RequestParam("email") String email, @RequestParam("telephone_number") String telephone_number) {

        System.out.println("******************");
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(telephone_number);
        System.out.println("******************");

       JobRequest jobRequest = new JobRequest();
       jobRequest.setFirstname(firstname);
       jobRequest.setLastname(lastname);
       jobRequest.setEmail(email);
       jobRequest.setTelephone(telephone_number);
       jobRequestRepository.save(jobRequest);
       sendEmailService.sendEmail(email);
       JSONObject obj = new JSONObject("{Can you send me the code to verify your email?: Thank you}");
       return obj;
    }

}
