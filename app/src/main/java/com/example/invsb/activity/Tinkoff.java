package com.example.invsb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.invsb.R;

public class Tinkoff extends AppCompatActivity {
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinkoff);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            Intent i;
            i = new Intent(Tinkoff.this, AuthorizationActivity.class);
            startActivity(i); finish();
        });
        button.setOnClickListener(view -> {
            Intent browserIntent = new
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://journal.tinkoff.ru/pro/stonks/"));
            startActivity(browserIntent);
        });
    }
}