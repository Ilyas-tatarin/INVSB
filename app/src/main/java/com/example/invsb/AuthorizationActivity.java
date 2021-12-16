package com.example.invsb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthorizationActivity extends AppCompatActivity {
    private EditText emailLogin;
    private EditText passLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        emailLogin = findViewById(R.id.emailText);
        passLogin = findViewById(R.id.passText);
        mAuth = FirebaseAuth.getInstance();

        Button buttonReg = (Button)findViewById(R.id.regButton);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthorizationActivity.this,RegistrationActivity.class);
                startActivity(intent);finish();
            }
        });

        Button enterButton = (Button)findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailLogin.getText().toString().isEmpty() || passLogin.getText().toString().isEmpty()){
                    Toast.makeText(AuthorizationActivity.this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), passLogin.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        Intent intent = new Intent(AuthorizationActivity.this, MainActivity.class);
                                        startActivity(intent); finish();
                                    }
                                    else {
                                        Toast.makeText(AuthorizationActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}