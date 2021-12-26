package com.example.invsb.presenter.impl;

import android.content.Intent;
import android.widget.Toast;

import com.example.invsb.activity.RegistrationActivity;
import com.example.invsb.activity.Tinkoff;
import com.example.invsb.view.AuthorizationView;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthorizationPresenterImpl implements AuthorizationPresenter {

    private AuthorizationView view;

    private FirebaseAuth firebaseAuth;

    @Override
    public void onBind(
            AuthorizationView view,
            FirebaseAuth firebaseAuth
    ) {
        this.view = view;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void openRegScreen() {
        Intent intent = new Intent(
                view.getContext(),
                RegistrationActivity.class
        );
        view.getContext().startActivity(intent);
        view.onFinish();
    }

    @Override
    public void tryOpenFilterScreen(String emailLogin, String passLogin) {
        if (emailLogin.isEmpty() || passLogin.isEmpty()) {
            view.showToast("Поле не может быть пустым");
        } else {
            firebaseAuth.signInWithEmailAndPassword(emailLogin, passLogin)
                    .addOnCompleteListener(task -> openFilterScreen(task.isSuccessful()));
        }
    }

    private void openFilterScreen(boolean isSuccessful) {
        if (isSuccessful) {
            Intent intent = new Intent(
                    view.getContext(),
                    Tinkoff.class
            );
            view.getContext().startActivity(intent);
        } else {
            view.showToast("Ошибка");
        }
    }

}
