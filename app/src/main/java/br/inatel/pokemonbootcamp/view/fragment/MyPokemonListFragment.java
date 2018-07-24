package br.inatel.pokemonbootcamp.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.controller.MyPokemonListController;
import br.inatel.pokemonbootcamp.databinding.FragmentMyPokemonListBinding;
import br.inatel.pokemonbootcamp.model.network.repository.PokemonRepository;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.adapter.PokemonListAdapter;

public class MyPokemonListFragment extends Fragment {

  private static final String TAG = Logger.getTag();

  private FragmentMyPokemonListBinding mBinding;

  private RecyclerView mRecyclerViewPokemonList;

  private PokemonListNavigator mPokemonListNavigator;

  @Inject
  PokemonListAdapter mPokemonListAdapter;

  @Inject
  MyPokemonListController mMyPokemonListController;

  @Inject
  PokemonRepository mPokemonRepository;

  @Inject
  Context mContext;

  @Inject
  public MyPokemonListFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_pokemon_list, container,
        false);

    mRecyclerViewPokemonList = mBinding.rvPokemonList;
    mRecyclerViewPokemonList.setAdapter(mPokemonListAdapter);
    mMyPokemonListController.getPokemonListSubject().subscribe(pokemons -> mPokemonListAdapter
        .setPokemonList(pokemons));
    mMyPokemonListController.loadPokemons();
    setupFab();

    return mBinding.getRoot();
  }

  public void setPokemonListNavigator(PokemonListNavigator pokemonListNavigator) {
    mPokemonListNavigator = pokemonListNavigator;
    mPokemonListAdapter.setPokemonListNavigator(pokemonListNavigator);
  }

  private void setupFab() {
    FloatingActionButton fab = mBinding.fab;
    fab.setOnClickListener(view -> mPokemonListNavigator.onCaptureNewPokemonClicked());
  }
}
