package com.example.invsb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.invsb.R;

/**
 * Класс, реализующий переход к курсам от Тинькофф банка
 *              со свойствами <b>button</b> и <b>button1</b>
 * @author Юлия Тарасова
 * @version 0.1
 *
 * */
public class Tinkoff extends AppCompatActivity {

    /** Поле, иницилизирующее кнопку*/
    Button button;
    /** Поле, иницилизирующее вторую кнопку*/
    Button button2;

    /**
     * Функция, инициализирующая
     *              пользовтельский интерфейс в виде кнопок для перехода к курсам
     *
     * @param savedInstanceState - сохраненное состояние
     * */
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