package com.example.invsb.view;

import android.content.Context;

public interface AuthorizationView {

    Context getContext();

    void onFinish();

    void showToast(String message);
}
