package br.inatel.pokemonbootcamp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.di.Injector;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.util.FragmentHelper;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.fragment.LoginFragment;
import br.inatel.pokemonbootcamp.view.fragment.NewAccountFragment;

public class LoginActivity extends AppCompatActivity implements LoginNavigator {

  private static final String TAG = Logger.getTag();

  @Inject
  LoginFragment mLoginFragment;

  @Inject
  NewAccountFragment mNewAccountFragment;

  public static void startActivity(Context context) {
    if (Logger.DEBUG) Log.d(TAG, "startActivity");
    Intent intent = new Intent(context, LoginActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Injector.getApplicationComponent().inject(this);
    mLoginFragment.setLoginNavigatorListener(this);
    mNewAccountFragment.setLoginNavigatorListener(this);

    attachInitialFragment();
  }

  private void attachInitialFragment() {
    if (Logger.DEBUG) Log.d(TAG, "attachInitialFragment");
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mLoginFragment,
        R.id.contentFrame, null);
  }

  @Override
  public void onNewAccountButtonClicked() {
    getSupportFragmentManager().popBackStack();
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mNewAccountFragment,
        R.id.contentFrame, null);
  }

  @Override
  public void onNewAccountCreated() {
    getSupportFragmentManager().popBackStack();
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mLoginFragment,
        R.id.contentFrame, null);
  }
}
