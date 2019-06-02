package android.com.example1views.screens.login;

public interface ILoginPresenter {
    void loginValidation(String userName);
    void callLoginApi(String userName);
}
