package br.inatel.pokemonbootcamp.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.databinding.FragmentPokemonDetailsBinding;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.util.Logger;

public class PokemonDetailsFragment extends Fragment {

  public static final String TAG = Logger.getTag();

  private FragmentPokemonDetailsBinding mBinding;

  public ObservableField<Pokemon> mPokemonObservableField;

  @Inject
  Context mContext;

  @Inject
  public PokemonDetailsFragment() {
    mPokemonObservableField = new ObservableField<>();
  }

  public void setPokemon(Pokemon pokemon) {
    mPokemonObservableField.set(pokemon);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_details, container,
        false);
    mBinding.setPokemon(mPokemonObservableField.get());

    Picasso.with(mContext)
        .load(mPokemonObservableField.get().getPicture())
        .fit()
        .centerCrop()
        .into(mBinding.ivPokemonPicture);

    return mBinding.getRoot();
  }
}
