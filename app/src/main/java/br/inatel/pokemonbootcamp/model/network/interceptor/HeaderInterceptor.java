package br.inatel.pokemonbootcamp.model.network.interceptor;


import android.text.TextUtils;

import java.io.IOException;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.di.Injector;
import br.inatel.pokemonbootcamp.di.preference.StringPreference;
import br.inatel.pokemonbootcamp.di.qualifier.ApiTokenPreference;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

  private static final String HTTP_HEADER_AUTHORIZATION = "Authorization";

  private static final String HTTP_AUTHORIZATION_PREFIX = "Bearer ";

  @Inject
  @ApiTokenPreference
  StringPreference mApiTokenPreference;

  public HeaderInterceptor() {
    Injector.getApplicationComponent().inject(this);
  }

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();

    if (!TextUtils.isEmpty(mApiTokenPreference.get())) {
      request = request.newBuilder().header(HTTP_HEADER_AUTHORIZATION,
          HTTP_AUTHORIZATION_PREFIX + mApiTokenPreference.get()).build();
    }

    return chain.proceed(request);
  }
}