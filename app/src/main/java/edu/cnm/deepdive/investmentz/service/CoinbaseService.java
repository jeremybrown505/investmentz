package edu.cnm.deepdive.investmentz.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.investmentz.BuildConfig;
import edu.cnm.deepdive.investmentz.model.pojo.CoinbaseResponse;
import edu.cnm.deepdive.investmentz.model.pojo.CoinbaseResponse.Price;
import edu.cnm.deepdive.investmentz.view.PriceDeserializer;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CoinbaseService {

  @GET("products/{from}-{to}/book")
  Single<CoinbaseResponse> get(@Path("from") String from, @Path("to") String to, @Query("level") int level);

  static CoinbaseService getInstance()  {
    return InstanceHolder.INSTANCE;
  }



  //

  class InstanceHolder {

    private static final CoinbaseService INSTANCE;

    static {
      Gson gson  = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .registerTypeAdapter(Price.class, new PriceDeserializer())
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
      OkHttpClient client = new OkHttpClient.Builder()
          .readTimeout(60, TimeUnit.SECONDS)
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .build();
      INSTANCE = retrofit.create(CoinbaseService.class);
    }

  }

}
