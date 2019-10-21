package com.example.androidroom.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher")
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    private int teacherId;

    @NonNull
    @ColumnInfo(name = "teacher_name")
    private String teacherName;

    @NonNull
    @ColumnInfo(name = "teacher_nip")
    private String teacherNip;

    @NonNull
    @ColumnInfo(name = "teacher_gol")
    private String teacherGol;


    public Teacher(@NonNull String teacherName, @NonNull String teacherNip, String teacherGol) {
        this.teacherName = teacherName;
        this.teacherNip = teacherNip;
        this.teacherGol = teacherGol;

    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @NonNull
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(@NonNull String teacherName) {
        this.teacherName = teacherName;
    }

    @NonNull
    public String getTeacherNip() { return teacherNip ; }

    public void setTeacherNip (@NonNull String teacherNip) {this.teacherNip = teacherNip; }

    public String getTeacherGol () {
        return teacherGol;
    }

    public void setTeacherGol(String teacherGol) {
        this.teacherGol = teacherGol;
    }

}
