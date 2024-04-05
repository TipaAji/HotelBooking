package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class WelcomeThread extends Thread{
    static ExecutorService messageExecutor=newFixedThreadPool(10);
    private String[] messages = new String[2];

    public String[] messages() throws InterruptedException {
        Properties properties=new Properties();
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcome_english.properties").getInputStream();
                properties.load(stream);
               messages[0] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcome_french.properties").getInputStream();
                properties.load(stream);
                messages[1] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000);
        return messages;
    }
}
