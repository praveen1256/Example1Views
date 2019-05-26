package android.com.example1views;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

//https://myproject.com/login/xxxx/1234	// Path URL
//        https://myproject.com/login?username='xxxx'&password='1234'	// Query URL
//        https://myproject.com/login
//        Body
//        i.e we need to create Pojo Class and send that as Body

public interface GetDataService {

    @GET("5ce8a2133500004091cf64f1")
    Call<SamplePojo> getDetails();

    // Path URL
    @POST("5ce8a2133500004091cf64f1")
    Call<SamplePojo> loginPath(@Path("username") String username,@Path("password") String password);

    @Headers({
            "Content-Type: application/json",
            "User-Agent: Your-App-Name"
    })
    @POST("5ce8a2133500004091cf64f1")
    Call<SamplePojo> loginQuery(@Query("username") String username, @Query("password") String password);

    @Headers("Authkey: key_value")
    @POST("5ce8a2133500004091cf64f1")
    Call<SamplePojo> loginBody(@Header ("Authkey") String key,@Body SamplePojo samplePojo);

}
