package br.inatel.pokemonbootcamp.di.component;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import br.inatel.pokemonbootcamp.PokemonBootcampApplication;
import br.inatel.pokemonbootcamp.di.module.ApplicationModule;
import br.inatel.pokemonbootcamp.di.module.NetworkModule;
import br.inatel.pokemonbootcamp.di.module.RoomModule;
import br.inatel.pokemonbootcamp.di.module.SharedPreferenceModule;
import br.inatel.pokemonbootcamp.model.network.interceptor.HeaderInterceptor;
import br.inatel.pokemonbootcamp.view.activity.LoginActivity;
import br.inatel.pokemonbootcamp.view.activity.MainDrawerActivity;
import br.inatel.pokemonbootcamp.view.activity.SplashActivity;
import dagger.Component;

/**
 * Main application {@link dagger.Component}.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Singleton
@Component(modules = {
    ApplicationModule.class,
    SharedPreferenceModule.class,
    NetworkModule.class,
    RoomModule.class
})
public interface ApplicationComponent {

  void inject(@NonNull PokemonBootcampApplication app);

  void inject(@NonNull MainDrawerActivity mainDrawerActivity);

  void inject(@NonNull LoginActivity loginActivity);

  void inject(@NonNull SplashActivity splashActivity);

  void inject(@NonNull HeaderInterceptor headerInterceptor);
}
