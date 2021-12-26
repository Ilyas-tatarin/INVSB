package com.example.invsb;

import static org.mockito.ArgumentMatchers.any;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.invsb.presenter.impl.AuthorizationPresenter;
import com.example.invsb.presenter.impl.AuthorizationPresenterImpl;
import com.example.invsb.view.AuthorizationView;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.Executor;

public class AuthorizationPresenterImplTest {

    private Context context;
    private AuthorizationView view;
    private FirebaseAuth firebaseAuth;
    private AuthorizationPresenter presenter;
    private Toast toast;

    @Before
    public void setup() {
        context = Mockito.mock(Context.class);
        view = Mockito.mock(AuthorizationView.class);
        firebaseAuth = Mockito.mock(FirebaseAuth.class);
        Mockito.mockStatic(Toast.class);
        Mockito.when(view.getContext()).thenReturn(context);
        Mockito.when(firebaseAuth.signInWithEmailAndPassword(
                "email",
                "12345678"
        )).thenReturn(new TaskLocal());
       Mockito.when(firebaseAuth.signInWithEmailAndPassword(
                "email",
                ""
        )).thenReturn(new TaskLocal());
        Mockito.when(firebaseAuth.signInWithEmailAndPassword(
                "",
                "12345678"
        )).thenReturn(new TaskLocal());
        Mockito.when(firebaseAuth.signInWithEmailAndPassword(
                "",
                ""
        )).thenReturn(new TaskLocal());

        /*Mockito.when(toast.makeText(context,
                "Поле не может быть пустым",
                toast.LENGTH_SHORT
        )).thenReturn(toast);*/

        presenter = new AuthorizationPresenterImpl();
        presenter.onBind(view, firebaseAuth);
    }

    @Test
    public void openRegScreen_Success() {
        presenter.openRegScreen();

        Mockito.verify(context).startActivity(any());
        Mockito.verify(view).onFinish();
    }

    @Test
    public void tryOpenFilterScreen_SignIn() {
        presenter.tryOpenFilterScreen(
                "email",
                "12345678"
        );
        Mockito.verify(firebaseAuth).signInWithEmailAndPassword(
                "email",
                "12345678"
        );
    }

    @Test
    public void tryOpenFilterScreen_SignIn2() {
        presenter.tryOpenFilterScreen(
                "",
                "12345678"
        );
    }

    @Test
    public void tryOpenFilterScreen_SignIn3() {
        presenter.tryOpenFilterScreen(
                "email",
                ""
        );
    }

    @Test
    public void tryOpenFilterScreen_SignIn4() {
        presenter.tryOpenFilterScreen(
                "",
                ""
        );
    }
}

class TaskLocal extends Task<AuthResult> {

    @NonNull
    @Override
    public Task<AuthResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnSuccessListener(@NonNull OnSuccessListener<? super AuthResult> onSuccessListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super AuthResult> onSuccessListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super AuthResult> onSuccessListener) {
        return null;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        return this;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        return this;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        return this;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCompleteListener(@NonNull OnCompleteListener<AuthResult> onCompleteListener) {
        return this;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<AuthResult> onCompleteListener) {
        return this;
    }

    @NonNull
    @Override
    public Task<AuthResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<AuthResult> onCompleteListener) {
        return this;
    }

    @Nullable
    @Override
    public Exception getException() {
        return null;
    }

    @Override
    public AuthResult getResult() {
        return null;
    }

    @Override
    public <X extends Throwable> AuthResult getResult(@NonNull Class<X> aClass) throws X {
        return null;
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }
}
