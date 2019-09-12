package android.com.example1views;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static RetrofitClientInstance retrofitClientInstance;
//    private static final String BASE_URL = "http://www.mocky.io/v2/";
    private static final String BASE_URL = BuildConfig.API;

    private RetrofitClientInstance() {

    }

    public static RetrofitClientInstance getMainInstance() {
        if (retrofitClientInstance == null) {
            retrofitClientInstance = new RetrofitClientInstance();
        }
        return retrofitClientInstance;
    }

    // Singleton Design Pattern
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
