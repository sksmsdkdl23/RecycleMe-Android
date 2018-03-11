package com.hackuvic.twoblocksaway.recycleme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hackuvic.twoblocksaway.recycleme.Map.MapActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cameraBtn = findViewById(R.id.btn_camera);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ClassifierActivity.class);
                startActivity(i);
            }
        });
    }

    public void onMap(View view) {
        Intent navNext = new Intent(this, MapActivity.class);
        startActivity(navNext);
    }
}
