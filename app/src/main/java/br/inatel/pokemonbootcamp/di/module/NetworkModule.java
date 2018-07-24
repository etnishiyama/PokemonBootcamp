package br.inatel.pokemonbootcamp.di.module;

import javax.inject.Singleton;

import br.inatel.pokemonbootcamp.BuildConfig;
import br.inatel.pokemonbootcamp.di.qualifier.RetrofitQualifier;
import br.inatel.pokemonbootcamp.model.network.interceptor.HeaderInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * {@link Module} containing classes needed to do network operations.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Module
public class NetworkModule {

  @RetrofitQualifier
  @Provides
  @Singleton
  Retrofit providesRetrofitAdapter() {
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(new HeaderInterceptor())
        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build();

    return new Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
