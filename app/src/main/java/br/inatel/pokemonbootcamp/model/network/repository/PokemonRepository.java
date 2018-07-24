package br.inatel.pokemonbootcamp.model.network.repository;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.di.qualifier.RetrofitQualifier;
import br.inatel.pokemonbootcamp.model.network.service.PokemonService;
import br.inatel.pokemonbootcamp.model.network.service.UserService;
import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.model.pojo.PokemonResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class PokemonRepository extends BaseRespository {

  private PokemonService mService;

  @Inject
  public PokemonRepository(@RetrofitQualifier Retrofit retrofit) {
    mService = retrofit.create(PokemonService.class);
  }

  public Observable<ApiResponse<PokemonResponse>> getMyPokemonList() {
    return mService.getMyPokemonList().compose(applySchedulers()).share();
  }

  public Observable<ApiResponse<Pokemon>> capturePokemon(String id) {
    return mService.capturePokemon(id).compose(applySchedulers()).share();
  }
}
