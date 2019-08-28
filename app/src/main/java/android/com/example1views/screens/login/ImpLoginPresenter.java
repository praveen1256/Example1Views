package android.com.example1views.screens.login;

import android.com.example1views.network.GetDataService;
import android.com.example1views.network.RetrofitClientInstance;
import android.com.example1views.screens.login.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImpLoginPresenter implements ILoginPresenter{


    ILoginView iLoginView;

    public ImpLoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
    }

    @Override
    public void loginValidation(String userName) {

        if(userName== null || userName.trim().length()==0){
            iLoginView.failValidation("Enter User Name");
            return;
        }



        iLoginView.successValidation();

    }

    @Override
    public void callLoginApi(String userName) {
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<LoginResponse> loginResponseCall = getDataService.callLoginApi();
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                iLoginView.loginApiSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                iLoginView.loginApiFailed();
            }
        });
    }

    public void newMethod(){

    }
}
