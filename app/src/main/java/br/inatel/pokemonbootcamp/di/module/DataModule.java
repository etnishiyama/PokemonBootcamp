package br.inatel.pokemonbootcamp.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} containing classes that persist some kind of data.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Module
public class DataModule {

  @Provides
  @Singleton
  SharedPreferences provideSharedPreferences(Application app) {
    return PreferenceManager.getDefaultSharedPreferences(app);
  }
}
