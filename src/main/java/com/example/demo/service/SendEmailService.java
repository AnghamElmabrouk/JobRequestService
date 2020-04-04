package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }



    public void sendEmail(String email) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Your Chatbot verification code");
        mail.setText("Hello,\n" +
            " \n" +
            "Thank you for signing up for RAK Chatbot!\n" +
            " \n" );
        mail.setText("Your 6-digit verification code is:\n " +generateOTP("12345678")+
            "\n" +
            " Enter this verification code on our chatbot page where you requested the code.\n" +
            " \n" +
            "Welcome and happy building!\n" +
            "\n" +
            "Thank you,\n" +
            "PX Test");
       /* mail.setText("Enter this verification code on our chatbot page where you requested the code.\n" +
            " \n" +
            "Welcome and happy building!\n" +
            "\n" +
            "Thank you,\n" +
            "PX Test");*/

        javaMailSender.send(mail);

      }

        public int generateOTP(String key) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return otp;

    }

}
