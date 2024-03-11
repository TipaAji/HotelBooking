package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.Time;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/time")
public class TimeController {
    @GetMapping
    public String[] getTime(){
        Time time = new Time();

        return time.getTime();
    }
}
