package br.inatel.pokemonbootcamp.model.network.service;

import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.model.pojo.PokemonResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PokemonService {

  @GET("pokemon")
  Observable<ApiResponse<PokemonResponse>> getMyPokemonList();

  @Headers( {"Content-Type: application/json"})
  @POST("pokemon/{id}/capture")
  Observable<ApiResponse<Pokemon>> capturePokemon(@Path("id") String id);
}
