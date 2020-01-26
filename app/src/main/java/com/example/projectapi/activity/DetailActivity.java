package com.example.projectapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projectapi.R;

public class DetailActivity extends AppCompatActivity {
    private ImageView pictureIV;
    private TextView name,mobileTV,passaTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pictureIV = findViewById(R.id.image_id);
        name = findViewById(R.id.textView_name);
        mobileTV = findViewById(R.id.textView_mobile);
        passaTV = findViewById(R.id.textView_person);

        Intent intent = getIntent();
        String names = intent.getExtras().getString("name");
        String mobile = intent.getExtras().getString("mobile");
        String who = intent.getExtras().getString("who");
        String logo = intent.getExtras().getString("image");

        name.setText(names);
        mobileTV.setText(mobile);
        passaTV.setText(who);
        Glide.with(this)
                .load(logo)
                .into(pictureIV);

    }
}
