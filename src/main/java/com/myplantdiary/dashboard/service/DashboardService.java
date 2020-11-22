package com.myplantdiary.dashboard.service;

import com.myplantdiary.dashboard.dao.IDashboardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DashboardService implements IDashboardService {

    @Autowired
    private IDashboardDAO dashboardDAO;


    @Override
    public Set<String> getProcessedPhotos() {
        Set<String> intersection = new HashSet<String>(dashboardDAO.getPhotoIn());
        intersection.retainAll(dashboardDAO.getPhotoOut());
        return intersection;
    }

    @Override
    public Set<String> getUnprocessedPhotos() {
          Set<String> difference = new HashSet<String>(dashboardDAO.getPhotoIn());
          difference.removeAll(dashboardDAO.getPhotoOut());
          difference.removeAll(dashboardDAO.getPhotoException());
          return difference;
    }

    @Override
    public Set<String> getExceptions() {
        return dashboardDAO.getPhotoException();
    }

}
