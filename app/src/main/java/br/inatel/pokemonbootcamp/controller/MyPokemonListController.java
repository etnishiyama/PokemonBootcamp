package br.inatel.pokemonbootcamp.controller;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.model.network.repository.PokemonRepository;
import br.inatel.pokemonbootcamp.model.pojo.ApiResponse;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.model.pojo.PokemonResponse;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class MyPokemonListController {

  private static final String TAG = Logger.getTag();

  public ObservableField<Integer> loadingVisibility;

  private PokemonListNavigator mPokemonListNavigator;

  private PublishSubject<List<Pokemon>> mPokemonListSubject;

  @Inject
  PokemonRepository mPokemonRepository;

  @Inject
  Context mContext;

  @Inject
  public MyPokemonListController() {
    loadingVisibility = new ObservableField<>(View.GONE);
    mPokemonListSubject = PublishSubject.create();
  }

  public Observable<List<Pokemon>> getPokemonListSubject() {
    return mPokemonListSubject;
  }

  public void setPokemonListNavigator(PokemonListNavigator pokemonListNavigator) {
    mPokemonListNavigator = pokemonListNavigator;
  }

  public void loadPokemons() {
    mPokemonRepository.getMyPokemonList().subscribe(this::onResult, this::onError);
  }

  private void onResult(ApiResponse<PokemonResponse> response) {
    if (Logger.DEBUG) Log.d(TAG, "onResult");
    List<Pokemon> pokemonList = Arrays.asList(response.getData().getPokemons());
    mPokemonListSubject.onNext(pokemonList);
  }

  private void onError(Throwable throwable) {
    if (Logger.DEBUG) Log.d(TAG, throwable.getMessage());
    Toast.makeText(mContext, R.string.network_problem, Toast.LENGTH_LONG).show();
  }
}
