package com.example.invsb.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invsb.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    public EditText emailReg;
    public EditText passReg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this,AuthorizationActivity.class);
                startActivity(intent);finish();
            }
        });

        emailReg = findViewById(R.id.emailRegText);
        passReg = findViewById(R.id.passRegText);
        mAuth = FirebaseAuth.getInstance();
        Button saveButton = (Button)findViewById(R.id.registrButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailReg.getText().toString().isEmpty() || passReg.getText().toString().isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(emailReg.getText().toString(), passReg.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(RegistrationActivity.this, Tinkoff.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegistrationActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}