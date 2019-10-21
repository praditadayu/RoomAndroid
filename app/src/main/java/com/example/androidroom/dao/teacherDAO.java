package com.example.androidroom.dao;

import com.example.androidroom.entity.Teacher;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface teacherDAO {
    @Insert
    void insert(Teacher teacher);

    @Update
    void update(Teacher teacher);

    @Delete
    void delete(Teacher teacher);

    @Query("DELETE FROM Teacher")
    void deleteAll();

    @Query("SELECT * from Teacher ORDER BY teacher_name")
    LiveData<List<Teacher>> getAllTeacher();
}
