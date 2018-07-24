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
import br.inatel.pokemonbootcamp.model.network.repository.PokemonRepository;
import br.inatel.pokemonbootcamp.model.network.repository.UserRepository;
import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.model.pojo.User;
import br.inatel.pokemonbootcamp.model.pojo.UserAuthResponse;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.activity.MainDrawerActivity;

public class CaptureNewPokemonController {

  private static final String TAG = Logger.getTag();

  public ObservableField<Integer> loadingVisibility;

  public ObservableField<String> username;

  public ObservableField<String> password;

  private PokemonListNavigator mPokemonListNavigator;

  @Inject
  PokemonRepository mPokemonRepository;

  @Inject
  Context mContext;

  @Inject
  public CaptureNewPokemonController() {
    loadingVisibility = new ObservableField<>(View.GONE);
    username = new ObservableField<>();
    password = new ObservableField<>();
  }

  public void setPokemonListNavigator(PokemonListNavigator pokemonListNavigator) {
    mPokemonListNavigator = pokemonListNavigator;
  }

  public void capturePokemon(String id) {
    mPokemonRepository.capturePokemon(id).subscribe(this::onResult, this::onError);
  }

  public View.OnClickListener onClickLogin() {
    return view -> {
      if (Logger.DEBUG) Log.d(TAG, "onClickLogin");
    };
  }

  private void onResult(ApiResponse<Pokemon> response) {
    if (Logger.DEBUG) Log.d(TAG, "onResult: " + response.getData());
    mPokemonListNavigator.onPokemonCaptured();
  }

  private void onError(Throwable throwable) {
    if (Logger.DEBUG) Log.d(TAG, throwable.getMessage());
    Toast.makeText(mContext, R.string.network_problem, Toast.LENGTH_LONG).show();
  }
}
