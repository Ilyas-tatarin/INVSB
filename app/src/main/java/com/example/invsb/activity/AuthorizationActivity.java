package com.example.invsb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invsb.R;
import com.example.invsb.presenter.impl.AuthorizationPresenter;
import com.example.invsb.presenter.impl.AuthorizationPresenterImpl;
import com.example.invsb.view.AuthorizationView;
import com.google.firebase.auth.FirebaseAuth;

public class AuthorizationActivity extends AppCompatActivity implements AuthorizationView {

    private EditText emailLogin;
    private EditText passLogin;
    private FirebaseAuth mAuth;

    private AuthorizationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        presenter = new AuthorizationPresenterImpl();
        presenter.onBind(this, FirebaseAuth.getInstance());

        mAuth = FirebaseAuth.getInstance();

        emailLogin = findViewById(R.id.emailText);
        passLogin = findViewById(R.id.passText);

        initRegButton();

        Button enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(v ->
                presenter.tryOpenFilterScreen(
                        emailLogin.getText().toString(),
                        passLogin.getText().toString()
                )
        );
    }

    private void initRegButton() {
        Button regButton = findViewById(R.id.regButton);
        regButton.setOnClickListener(view -> presenter.openRegScreen());
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onFinish() {
        finish();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(),
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
}