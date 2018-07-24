package br.inatel.pokemonbootcamp.controller;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.di.preference.StringPreference;
import br.inatel.pokemonbootcamp.di.qualifier.ApiTokenPreference;
import br.inatel.pokemonbootcamp.model.network.repository.UserRepository;
import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.activity.MainDrawerActivity;

public class NewAccountController {

  private static final String TAG = Logger.getTag();

  public ObservableField<Integer> loadingVisibility;

  private User user;

  private LoginNavigator mLoginNavigator;

  @Inject
  UserRepository mUserRepository;

  @Inject
  Context mContext;

  @Inject
  public NewAccountController() {
    loadingVisibility = new ObservableField<>(View.GONE);
    user = new User();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setLoginNavigator(LoginNavigator loginNavigator) {
    mLoginNavigator = loginNavigator;
  }

  public View.OnClickListener onClickCreateNewAccount() {
    return view -> {
      if (Logger.DEBUG) Log.d(TAG, "onClickCreateNewAccount" + user);
      mUserRepository.createUser(user).subscribe(this::onResult, this::onError);
    };
  }

  private void onResult(ApiResponse<User> userResponse) {
    if (Logger.DEBUG) Log.d(TAG, "onResult: " + userResponse.getData());
    Toast.makeText(mContext, R.string.toast_user_created_successfully, Toast.LENGTH_LONG).show();
    mLoginNavigator.onNewAccountCreated();
  }

  private void onError(Throwable throwable) {
    if (Logger.DEBUG) Log.d(TAG, throwable.getMessage());
    Toast.makeText(mContext, R.string.network_problem, Toast.LENGTH_LONG).show();
  }
}
