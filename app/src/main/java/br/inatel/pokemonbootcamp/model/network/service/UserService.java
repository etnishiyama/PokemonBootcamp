package br.inatel.pokemonbootcamp.model.network.service;

import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

  @POST("user/authenticate")
  Observable<ApiResponse<UserAuthResponse>> authenticate(@Body User user);

  @POST("user")
  Observable<ApiResponse<User>> createUser(@Body User user);
}
