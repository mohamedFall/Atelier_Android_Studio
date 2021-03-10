package fr.epsi.atelierandroidstudio_prj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StudentInfo extends ProjectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        String studentName = getIntent().getExtras().getString("studentName","");
        String studentImageUrl = getIntent().getExtras().getString("studentImageUrl","");
        String studentEmail = getIntent().getExtras().getString("studentEmail","");
        String studentGroup = getIntent().getExtras().getString("studentGroup","");

        setTitle(studentName);
        showBack();

        ImageView studentAvatarView = findViewById(R.id.studentAvatar);
        TextView studentNameView = findViewById(R.id.studentName);
        TextView studentEmailView = findViewById(R.id.studentEmail);
        TextView studentGroupView = findViewById(R.id.studentGroup);
        studentNameView.setText(studentName);
        studentEmailView.setText(studentEmail);
        studentGroupView.setText(studentGroup);
        Picasso.get().load(studentImageUrl).into(studentAvatarView);
//        Picasso.get().setLoggingEnabled(true);
    }
}