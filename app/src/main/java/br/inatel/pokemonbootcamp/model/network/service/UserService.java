package br.inatel.pokemonbootcamp.model.network.service;

import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

  @GET("user/authenticate?")
  Observable<ApiResponse<UserAuthResponse>> authenticate(@Query("username") User user);

  @POST("user")
  Observable<ApiResponse<User>> createUser(@Body User user);
}
