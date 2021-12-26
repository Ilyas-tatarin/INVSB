package com.example.invsb.presenter.impl;

import com.example.invsb.view.AuthorizationView;
import com.google.firebase.auth.FirebaseAuth;

public interface AuthorizationPresenter {

    void onBind(
            AuthorizationView view,
            FirebaseAuth firebaseAuth
    );

    void openRegScreen();

    void tryOpenFilterScreen(String email, String pass);
}
