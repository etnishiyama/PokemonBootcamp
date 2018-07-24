package br.inatel.pokemonbootcamp.di.module;


import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.di.preference.StringPreference;
import br.inatel.pokemonbootcamp.di.qualifier.ApiTokenPreference;
import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} to provide all application {@link SharedPreferences}.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Module(includes = DataModule.class)
public class SharedPreferenceModule {

  @Provides
  @Singleton
  @ApiTokenPreference
  StringPreference provideApiTokenPreferencePreference(Context context, SharedPreferences prefs) {
    final String key = context.getString(R.string.shared_preference_api_token);
    return new StringPreference(prefs, key, null);
  }
}