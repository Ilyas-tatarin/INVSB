package com.example.invsb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText emailReg;
    private EditText passReg;
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
        Button saveButton = (Button)findViewById(R.id.enterButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailReg.getText().toString().isEmpty() || passReg.getText().toString().isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(emailReg.getText().toString(), passReg.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                startActivity(intent); finish();
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