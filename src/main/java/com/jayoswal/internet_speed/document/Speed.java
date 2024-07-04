package com.jayoswal.internet_speed.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "SpeedObject")
public class Speed {

    @Id
    private String id;

    private double upload;

    private Date dateTime;

    public Speed() {
    }

    public Speed(String id, double upload, Date dateTime) {
        this.id = id;
        this.upload = upload;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getUpload() {
        return upload;
    }

    public void setUpload(double upload) {
        this.upload = upload;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "id=" + id +
                ", upload=" + upload +
                ", dateTime=" + dateTime +
                '}';
    }
}
