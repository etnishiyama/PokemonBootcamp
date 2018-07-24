package br.inatel.pokemonbootcamp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import br.inatel.pokemonbootcamp.di.Injector;
import br.inatel.pokemonbootcamp.util.Logger;

public class PokemonBootcampApplication extends Application {

  private static final String TAG = Logger.getTag();

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    Log.d(TAG, "PokemonBootcampApplication started");

    Injector.initializeApplicationComponent(this);
    Injector.getApplicationComponent().inject(this);
  }
}
