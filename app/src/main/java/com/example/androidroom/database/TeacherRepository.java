package com.example.androidroom.database;

import android.app.Application;
import android.os.AsyncTask;

import com.example.androidroom.dao.teacherDAO;
import com.example.androidroom.entity.Teacher;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TeacherRepository {
    private teacherDAO teacherDAO;
    private LiveData<List<Teacher>> mAllTeacher;

   public TeacherRepository(Application application) {
        TeacherAppDatabase db = TeacherAppDatabase.getDatabase(application);
        teacherDAO = db.teacherDAO();
       mAllTeacher = teacherDAO.getAllTeacher();
    }

    public LiveData<List<Teacher>> getmAllTeacher() {
        return mAllTeacher;
    }

    public void insert (Teacher teacher) {
        new insertAsyncTask(teacherDAO).execute(teacher);
    }

    public void delete(Teacher teacher) { new DeleteTeacherAsyncTask(teacherDAO).execute(teacher);
    }

    public void update(Teacher teacher) { new UpdateTeacherAsyncTask(teacherDAO).execute(teacher); }

    private static class insertAsyncTask extends AsyncTask<Teacher, Void, Void> {

        private teacherDAO mAsyncTaskDao;

        insertAsyncTask(teacherDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Teacher... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class UpdateTeacherAsyncTask extends AsyncTask<Teacher, Void, Void> {
        private teacherDAO teacherDAO;

        private UpdateTeacherAsyncTask(teacherDAO teacherDAO) {
            this.teacherDAO = teacherDAO;
        }

        @Override
        protected Void doInBackground(Teacher... teachers) {
            teacherDAO.update(teachers[0]);
            return null;
        }
    }

    private static class DeleteTeacherAsyncTask extends AsyncTask<Teacher, Void, Void> {
        private teacherDAO teacherDAO;

        private DeleteTeacherAsyncTask(teacherDAO teacherDAO) {
            this.teacherDAO = teacherDAO;
        }

        @Override
        protected Void doInBackground(Teacher... teachers) {
            teacherDAO.delete(teachers[0]);
            return null;
        }
    }
}
