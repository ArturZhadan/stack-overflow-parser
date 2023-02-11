package configuration;

import com.simplemented.okdelay.DelayInterceptor;
import com.simplemented.okdelay.SimpleDelayProvider;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {
    public static final String BASE_URL = "https://api.stackexchange.com/2.3/";

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient.Builder()
                        .callTimeout(60, TimeUnit.MINUTES)
                        .addInterceptor(new DelayInterceptor(
                                new SimpleDelayProvider(3L, TimeUnit.SECONDS)))
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
