package fr.epsi.atelierandroidstudio_prj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductsList extends ProjectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        String categoryTitle = getIntent().getExtras().getString("categoryTitle","");

        setTitle(categoryTitle);
        showBack();
    }
}