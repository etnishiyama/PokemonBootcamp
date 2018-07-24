package br.inatel.pokemonbootcamp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.controller.MainDrawerController;
import br.inatel.pokemonbootcamp.di.Injector;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.FragmentHelper;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.fragment.AboutFragment;
import br.inatel.pokemonbootcamp.view.fragment.CaptureNewPokemonFragment;
import br.inatel.pokemonbootcamp.view.fragment.MyPokemonListFragment;
import br.inatel.pokemonbootcamp.view.fragment.PokemonDetailsFragment;

public class MainDrawerActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, PokemonListNavigator {

  private static final String TAG = Logger.getTag();

  private DrawerLayout mDrawerLayout;

  private Toolbar mToolbar;

  @Inject
  MainDrawerController mMainDrawerController;

  @Inject
  AboutFragment mAboutFragment;

  @Inject
  MyPokemonListFragment mMyPokemonListFragment;

  @Inject
  CaptureNewPokemonFragment mCaptureNewPokemonFragment;

  @Inject
  PokemonDetailsFragment mPokemonDetailsFragment;

  public static void startActivity(Context context) {
    if (Logger.DEBUG) Log.d(TAG, "startActivity");
    Intent intent = new Intent(context, MainDrawerActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_drawer);

    Injector.getApplicationComponent().inject(this);
    mCaptureNewPokemonFragment.setPokemonListNavigator(this);
    mMyPokemonListFragment.setPokemonListNavigator(this);

    setupToolbar();
    setupNavigationDrawer();
    attachInitialFragment();
  }

  private void attachInitialFragment() {
    if (Logger.DEBUG) Log.d(TAG, "attachInitialFragment");
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mMyPokemonListFragment,
        R.id.contentFrame, null);
  }

  private void setupToolbar() {
    mToolbar = findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
  }

  private void setupNavigationDrawer() {
    mDrawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    mDrawerLayout.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      mDrawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_drawer, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_about) {
      FragmentHelper.replaceFragment(getSupportFragmentManager(), mAboutFragment,
          R.id.contentFrame, AboutFragment.TAG);
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.nav_my_pokemon:
        break;
      case R.id.nav_pokemons:
        break;
      case R.id.nav_logout:
        mMainDrawerController.onClickLogout();
        break;
    }

    mDrawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onPokemonClicked(Pokemon pokemon) {
    if (Logger.DEBUG) Log.d(TAG, "onPokemonClicked: " + pokemon);
    mPokemonDetailsFragment.setPokemon(pokemon);
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mPokemonDetailsFragment,
        R.id.contentFrame, PokemonDetailsFragment.TAG);
  }

  @Override
  public void onPokemonCaptured() {
    getSupportFragmentManager().popBackStack();
  }

  @Override
  public void onCaptureNewPokemonClicked() {
    FragmentHelper.replaceFragment(getSupportFragmentManager(), mCaptureNewPokemonFragment,
        R.id.contentFrame, CaptureNewPokemonFragment.TAG);
  }
}
