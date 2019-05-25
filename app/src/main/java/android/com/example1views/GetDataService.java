package android.com.example1views;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("5ce8a2133500004091cf64f1")
    Call<SamplePojo> getDetails();



}
