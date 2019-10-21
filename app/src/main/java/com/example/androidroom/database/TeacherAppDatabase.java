package com.example.androidroom.database;

import android.content.Context;

import com.example.androidroom.dao.teacherDAO;
import com.example.androidroom.entity.Teacher;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Teacher.class}, version = 1)
public abstract  class TeacherAppDatabase extends RoomDatabase {

    public abstract teacherDAO teacherDAO();

    private static volatile TeacherAppDatabase INSTANCE;

    static TeacherAppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TeacherAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TeacherAppDatabase.class, "teacher_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
