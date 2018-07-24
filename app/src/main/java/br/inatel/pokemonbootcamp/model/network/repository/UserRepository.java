package br.inatel.pokemonbootcamp.model.network.repository;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.di.qualifier.RetrofitQualifier;
import br.inatel.pokemonbootcamp.model.network.service.UserService;
import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class UserRepository extends BaseRespository {

  private UserService mService;

  @Inject
  public UserRepository(@RetrofitQualifier Retrofit retrofit) {
    mService = retrofit.create(UserService.class);
  }

  public Observable<ApiResponse<UserAuthResponse>> authenticate(User user) {
    return mService.authenticate(user).compose(applySchedulers()).share();
  }

  public Observable<ApiResponse<User>> createUser(User user) {
    return mService.createUser(user).compose(applySchedulers()).share();
  }
}
