package com.example.androidroom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidroom.R;

import androidx.appcompat.app.AppCompatActivity;

public class NewTeacherActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY_TEACHER_ID = "com.example.androidroom.EXTRA_ID";
    public static final String EXTRA_REPLY_TEACHER_NAME = "com.example.androidroom.NAME";
    public static final String EXTRA_REPLY_TEACHER_NIP = "com.example.androidroom.NIP";
    public static final String EXTRA_REPLY_TEACHER_GOL = "com.example.androidroom.GOL";

    private EditText mEditTeacherNameView, mEditTeacherNipView, mEditTeacherGolView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_teacher);

        mEditTeacherNameView = findViewById(R.id.edit_teacher_name);
        mEditTeacherNipView = findViewById(R.id.edit_teacher_nip);
        mEditTeacherGolView = findViewById(R.id.edit_teacher_gol);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_REPLY_TEACHER_ID)) {
            setTitle("Edit Teacher");
            mEditTeacherNameView.setText(intent.getStringExtra(EXTRA_REPLY_TEACHER_NAME));
            mEditTeacherNipView.setText(intent.getStringExtra(EXTRA_REPLY_TEACHER_NIP));
            mEditTeacherGolView.setText(intent.getStringExtra(EXTRA_REPLY_TEACHER_GOL));

        } else {
            setTitle("Add Teacher");
        }

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTeacherNameView.getText()) || TextUtils.isEmpty(mEditTeacherNipView.getText()) || TextUtils.isEmpty(mEditTeacherGolView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String teacherName = mEditTeacherNameView.getText().toString();
                    String teacherNip = mEditTeacherNipView.getText().toString();
                    String teacherGol = mEditTeacherGolView.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY_TEACHER_NAME, teacherName);
                    replyIntent.putExtra(EXTRA_REPLY_TEACHER_NIP, teacherNip);
                    replyIntent.putExtra(EXTRA_REPLY_TEACHER_GOL, teacherGol);

                    int id = getIntent().getIntExtra(EXTRA_REPLY_TEACHER_ID, -1);
                    if (id != -1) {
                        replyIntent.putExtra(EXTRA_REPLY_TEACHER_ID, id);
                    }

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
