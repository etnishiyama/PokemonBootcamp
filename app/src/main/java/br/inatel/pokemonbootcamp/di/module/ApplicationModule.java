package br.inatel.pokemonbootcamp.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import br.inatel.pokemonbootcamp.PokemonBootcampApplication;
import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} that exposes the {@link android.app.Application} to the whole app.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Module
public class ApplicationModule {

  private final PokemonBootcampApplication mApplication;

  public ApplicationModule(PokemonBootcampApplication application) {
    mApplication = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @Singleton
  Context provideContext() {
    return mApplication.getApplicationContext();
  }
}
