package br.inatel.pokemonbootcamp.di;

import java.util.Objects;

import br.inatel.pokemonbootcamp.PokemonBootcampApplication;
import br.inatel.pokemonbootcamp.di.component.ApplicationComponent;
import br.inatel.pokemonbootcamp.di.component.DaggerApplicationComponent;
import br.inatel.pokemonbootcamp.di.module.ApplicationModule;
import br.inatel.pokemonbootcamp.di.module.NetworkModule;
import br.inatel.pokemonbootcamp.di.module.RoomModule;
import br.inatel.pokemonbootcamp.di.module.SharedPreferenceModule;

/**
 * Initialized the {@link ApplicationComponent}, setting all application {@link dagger.Module}.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
public class Injector {

  private static ApplicationComponent sApplicationComponent;

  private Injector() {
  }

  public static void initializeApplicationComponent(PokemonBootcampApplication app) {
    sApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(app))
        .sharedPreferenceModule(new SharedPreferenceModule())
        .networkModule(new NetworkModule())
        .roomModule(new RoomModule(app))
        .build();
  }

  public static ApplicationComponent getApplicationComponent() {
    Objects.requireNonNull(sApplicationComponent, "Null ApplicationComponent");
    return sApplicationComponent;
  }
}
