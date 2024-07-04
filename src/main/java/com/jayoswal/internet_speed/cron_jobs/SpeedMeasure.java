package com.jayoswal.internet_speed.cron_jobs;

import com.jayoswal.internet_speed.document.Speed;
import com.jayoswal.internet_speed.service.SpeedService;
import com.jayoswal.internet_speed.utility.UploadSpeedMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpeedMeasure {

    @Autowired
    private SpeedService speedService;

    @Scheduled(fixedRate = 1000)
    public void uploadSpeed(){
        Speed speed = new Speed();
        speed.setUpload(UploadSpeedMeasure.getUploadSpeed());
        speed.setDateTime(new Date());
        speedService.saveSpeed(speed);
    }
}
