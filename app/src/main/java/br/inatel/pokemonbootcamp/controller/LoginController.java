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

public class LoginController {

  private static final String TAG = Logger.getTag();

  public ObservableField<Integer> loadingVisibility;

  public ObservableField<String> username;

  public ObservableField<String> password;

  private LoginNavigator mLoginNavigator;

  @Inject
  @ApiTokenPreference
  StringPreference mApiTokenPreference;

  @Inject
  UserRepository mUserRepository;

  @Inject
  Context mContext;

  @Inject
  public LoginController() {
    loadingVisibility = new ObservableField<>(View.GONE);
    username = new ObservableField<>();
    password = new ObservableField<>();
  }

  public void setLoginNavigator(LoginNavigator loginNavigator) {
    mLoginNavigator = loginNavigator;
  }

  public View.OnClickListener onClickLogin() {
    return view -> {
      if (Logger.DEBUG) Log.d(TAG, "onClickLogin");
      User loginUser = new User();
      loginUser.setPassword(password.get());
      loginUser.setUsername(username.get());
      mUserRepository.authenticate(loginUser).subscribe(this::onResult, this::onError);
    };
  }

  public View.OnClickListener onClickNewAccount() {
    return view -> {
      if (Logger.DEBUG) Log.d(TAG, "onClickNewAccount");
      mLoginNavigator.onNewAccountButtonClicked();
    };
  }

  private void onResult(ApiResponse<UserAuthResponse> authResponse) {
    if (Logger.DEBUG) Log.d(TAG, "onResult: " + authResponse.getData());
    mApiTokenPreference.put(authResponse.getData().getToken());
    MainDrawerActivity.startActivity(mContext);
  }

  private void onError(Throwable throwable) {
    if (Logger.DEBUG) Log.d(TAG, throwable.getMessage());
    Toast.makeText(mContext, R.string.toast_credentials_not_valid, Toast.LENGTH_LONG).show();
  }
}
