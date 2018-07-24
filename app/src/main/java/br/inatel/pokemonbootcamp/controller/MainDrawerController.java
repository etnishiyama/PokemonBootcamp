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
import br.inatel.pokemonbootcamp.view.activity.LoginActivity;
import br.inatel.pokemonbootcamp.view.activity.MainDrawerActivity;

public class MainDrawerController {

  private static final String TAG = Logger.getTag();

  @Inject
  @ApiTokenPreference
  StringPreference mApiTokenPreference;

  @Inject
  Context mContext;

  @Inject
  public MainDrawerController() {
  }

  public void onClickLogout() {
    mApiTokenPreference.put(null);
    LoginActivity.startActivity(mContext);
  }
}
