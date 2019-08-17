package android.com.example1views.screens.login;

import android.com.example1views.screens.login.model.LoginResponse;

public interface ILoginView {
    void successValidation();

    void failValidation();

    void loginApiSuccess(LoginResponse loginResponse);

    void loginApiFailed();
}
