package com.myplantdiary.dashboard.dao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class DashboardDAO implements IDashboardDAO {

    private Set<String> photoIn = new HashSet<>();
    private Set<String> photoOut = new HashSet<>();
    private Set<String> photoException = new HashSet<>();

    @KafkaListener(topics="photoIn", groupId="dashboard")
    public void processPhotoIn(String path) {
        photoIn.add(path);
    }

    @KafkaListener(topics="photoOut", groupId="dashboard")
    public void processPhotoOut(String path) {
        photoOut.add(path);
    }

    @KafkaListener(topics="photoException", groupId="dashboard")
    public void processPhotoException(String path) {
        photoException.add(path);
    }

    @Override
    public Set<String> getPhotoIn() {
        return photoIn;
    }

    @Override
    public void setPhotoIn(Set<String> photoIn) {
        this.photoIn = photoIn;
    }

    @Override
    public Set<String> getPhotoOut() {
        return photoOut;
    }

    @Override
    public void setPhotoOut(Set<String> photoOut) {
        this.photoOut = photoOut;
    }

    @Override
    public Set<String> getPhotoException() {
        return photoException;
    }

    @Override
    public void setPhotoException(Set<String> photoException) {
        this.photoException = photoException;
    }


}
