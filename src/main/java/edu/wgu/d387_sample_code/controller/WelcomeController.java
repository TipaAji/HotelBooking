package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.WelcomeThread;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    @GetMapping
    public String[] welcomeMessage() throws InterruptedException {
        WelcomeThread welcome = new WelcomeThread();
        String[] messages = welcome.messages();
        welcome.start();

        return messages;
    }
}
