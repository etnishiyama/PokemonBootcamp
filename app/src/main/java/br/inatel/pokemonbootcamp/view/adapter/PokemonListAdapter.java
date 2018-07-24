package br.inatel.pokemonbootcamp.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.databinding.RowPokemonListItemBinding;
import br.inatel.pokemonbootcamp.model.pojo.Pokemon;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.view_holder.MyViewHolder;

public class PokemonListAdapter extends RecyclerView.Adapter<MyViewHolder> {

  private static final String TAG = Logger.getTag();

  private List<Pokemon> mPokemonList;

  private PokemonListNavigator mPokemonListNavigator;

  @Inject
  Context mContext;

  @Inject
  public PokemonListAdapter() {
  }

  public List<Pokemon> getPokemonList() {
    return mPokemonList;
  }

  public void setPokemonListNavigator(PokemonListNavigator pokemonListNavigator) {
    mPokemonListNavigator = pokemonListNavigator;
  }

  public void setPokemonList(List<Pokemon> pokemonList) {
    if (Logger.DEBUG) Log.d(TAG, "setPokemonList");
    mPokemonList = pokemonList;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    RowPokemonListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
        R.layout.row_pokemon_list_item, parent, false);

    return new MyViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Pokemon pokemon = mPokemonList.get(position);
    holder.getBinding().setPokemon(pokemon);

    holder.getBinding().alarmStationCardView.setOnClickListener(view ->
        mPokemonListNavigator.onPokemonClicked(pokemon));
  }

  @Override
  public int getItemCount() {
    return mPokemonList != null ? mPokemonList.size() : 0;
  }

}
