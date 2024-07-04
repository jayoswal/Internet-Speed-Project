package com.jayoswal.internet_speed.service;

import com.jayoswal.internet_speed.document.Speed;
import com.jayoswal.internet_speed.repository.SpeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpeedService {

    @Autowired
    private SpeedRepository speedRepository;

    public void saveSpeed(Speed speed) {
        speed.setId(UUID.randomUUID().toString());
        speedRepository.save(speed);
        System.out.println(speed.toString());
    }

    public double getUploadSpeed(){
        // TODO - calculate real speed
        return Math.random() * 100;
    }
}
