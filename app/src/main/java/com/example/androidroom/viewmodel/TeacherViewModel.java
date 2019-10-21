package com.example.androidroom.viewmodel;

import android.app.Application;

import com.example.androidroom.database.TeacherRepository;
import com.example.androidroom.entity.Teacher;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TeacherViewModel extends AndroidViewModel {

    private TeacherRepository mRepository;

    private LiveData<List<Teacher>> mAllTeacher ;

    public TeacherViewModel(Application application) {
        super(application);
        mRepository = new TeacherRepository(application);
        mAllTeacher = mRepository.getmAllTeacher();
    }

    public LiveData<List<Teacher>> getmAllTeacher() { return mAllTeacher; }

    public void insert(Teacher teacher) { mRepository.insert(teacher); }
    public void update(Teacher teacher) { mRepository.update(teacher); }
    public void delete(Teacher teacher) { mRepository.delete(teacher); }
}