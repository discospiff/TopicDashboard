package com.myplantdiary.dashboard.dao;

import java.util.Set;

public interface IDashboardDAO {
    Set<String> getPhotoIn();

    void setPhotoIn(Set<String> photoIn);

    Set<String> getPhotoOut();

    void setPhotoOut(Set<String> photoOut);

    Set<String> getPhotoException();

    void setPhotoException(Set<String> photoException);
}
