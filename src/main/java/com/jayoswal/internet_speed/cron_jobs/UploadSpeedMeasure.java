package com.jayoswal.internet_speed.cron_jobs;

import com.jayoswal.internet_speed.document.Speed;
import com.jayoswal.internet_speed.service.SpeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UploadSpeedMeasure {

    @Autowired
    private SpeedService speedService;

    @Scheduled(fixedRate = 1000)
    public void uploadSpeed(){
        Speed speed = new Speed();
        speed.setDateTime(new Date());
        speed.setUpload(speedService.getUploadSpeed());
        speedService.saveSpeed(speed);
    }
}
