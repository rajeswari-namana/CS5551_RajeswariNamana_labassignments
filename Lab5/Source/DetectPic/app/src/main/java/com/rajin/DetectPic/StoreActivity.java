package com.rajin.DetectPic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class StoreActivity extends AppCompatActivity {

    public class ApiClient {
        public static final String BASE_URL = "https://api.bestbuy.com/v1/";
        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
        public interface BestBuyInterface {

            @GET("products/{p}/stores.json")
            Call<StoreOutput> getResponse(@Path("p") String productcd, @Query("postalCode") String postalCode, @Query("apiKey") String apiKey);

            @GET("products(search={name})?format=json&show=sku&apiKey=77qthcka6yz8w2xy3c2x8uh")
            Call<StorePlace> getResponse(@Path("name") String name);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
}
