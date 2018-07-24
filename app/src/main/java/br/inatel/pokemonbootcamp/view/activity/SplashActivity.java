package br.inatel.pokemonbootcamp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.di.Injector;
import br.inatel.pokemonbootcamp.di.preference.StringPreference;
import br.inatel.pokemonbootcamp.di.qualifier.ApiTokenPreference;
import br.inatel.pokemonbootcamp.util.Logger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Splash screen to avoid blank screen on start, adding a 2 second delay on start
 */
public class SplashActivity extends AppCompatActivity {

  private static final String TAG = Logger.getTag();

  private static final int SPLASH_TIMEOUT = 1;

  @Inject
  @ApiTokenPreference
  StringPreference mApiTokenPreference;

  private Disposable mSubscription;
  private Consumer mConsumer = o -> {
    if (mApiTokenPreference.get() != null) {
      MainDrawerActivity.startActivity(this);
    } else {
      LoginActivity.startActivity(this);
    }
    finish();
  };

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Injector.getApplicationComponent().inject(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    mSubscription.dispose();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mSubscription = Observable.timer(SPLASH_TIMEOUT, TimeUnit.SECONDS).subscribe(mConsumer);
  }
}
