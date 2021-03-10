package fr.epsi.atelierandroidstudio_prj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GroupInfos extends ProjectActivity {

    ArrayList<Student> studentsList;
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_infos);

        setTitle("Infos");
        showBack();

        recyclerView = findViewById(R.id.studentsList);

        studentsList = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(GroupInfosData.studentsData);
            JSONArray jsonItems = jsonObject.getJSONArray("students");
            for (int i = 0; i < jsonItems.length(); i++){
                Student student = new Student(jsonItems.getJSONObject(i));
                studentsList.add(student);
            }

            studentAdapter = new StudentAdapter(this,studentsList);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(studentAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}