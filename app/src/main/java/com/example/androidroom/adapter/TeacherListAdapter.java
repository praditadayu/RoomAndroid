package com.example.androidroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidroom.R;
import com.example.androidroom.entity.Teacher;
import com.example.androidroom.viewmodel.TeacherViewModel;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherViewHolder> {
private TeacherViewModel teacherViewModel;

    class TeacherViewHolder extends RecyclerView.ViewHolder{
        private final TextView teacherNameView, teacherNipView, teacherGolView;
        private final Button editButton, deleteButton;
        private TeacherViewHolder (final View itemView) {
            super(itemView);
            teacherNameView = itemView.findViewById(R.id.textView_teacher_name);
            teacherNipView = itemView.findViewById(R.id.textView_teacher_nip);
            teacherGolView = itemView.findViewById(R.id.textView_teacher_gol);

            editButton = itemView.findViewById(R.id.button_edit);
            deleteButton = itemView.findViewById(R.id.button_delete);

        }
    }

    private final LayoutInflater mInflater;
    private List<Teacher> mTeacher; // Cached copy of words

    public TeacherListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TeacherViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder(final TeacherViewHolder holder, int position) {
        if (mTeacher != null) {
            Teacher current = mTeacher.get(position);
            holder.teacherNameView.setText("Name      : "+current.getTeacherName());
            holder.teacherNipView.setText("Code   : "+current.getTeacherNip());
            holder.teacherGolView.setText("Desc  : "+current.getTeacherGol());


        } else {
            // Covers the case of data not being ready yet.
            holder.teacherNameView.setText("No Teacher");
        }

    }

    public void setmTeacher(List<Teacher> teachers){
        mTeacher = teachers;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTeacher != null)
            return mTeacher.size();
        else return 0;
    }

    public Teacher getTeacherAt (int position) {
        return mTeacher.get(position);
    }
}
