package android.com.example1views.network;

import android.com.example1views.screens.login.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;

//https://myproject.com/login/xxxx/1234	// Path URL
//        https://myproject.com/login?username='xxxx'&password='1234'	// Query URL
//        https://myproject.com/login
//        Body
//        i.e we need to create Pojo Class and send that as Body

public interface GetDataService {

    @GET("5d576464300000c6c730ae63")
    Call<LoginResponse> callLoginApi();

}
