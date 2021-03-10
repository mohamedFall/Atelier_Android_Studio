package fr.epsi.atelierandroidstudio_prj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Categories extends ProjectActivity {
    ArrayList<Category> categoriesList;
    CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;
    String products_url = "https://djemam.com/epsi/categories.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        setTitle("Rayons");
        showBack();

        recyclerView = findViewById(R.id.categoriesList);

        categoriesList = new ArrayList<Category>();
        categoryAdapter = new CategoryAdapter(this, categoriesList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);

        WebServiceCall wsCall= new WebServiceCall(products_url, new WebServiceCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonItems = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonItems.length(); i++){
                        Category category = null;
                        category = new Category(jsonItems.getJSONObject(i));
                        categoriesList.add(category);
                    }
                    categoryAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(Categories.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}