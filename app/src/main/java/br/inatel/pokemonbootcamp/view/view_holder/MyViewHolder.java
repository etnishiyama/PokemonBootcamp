package br.inatel.pokemonbootcamp.view.view_holder;

import android.support.v7.widget.RecyclerView;

import br.inatel.pokemonbootcamp.databinding.RowPokemonListItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

  private final RowPokemonListItemBinding mBinding;

  public MyViewHolder(RowPokemonListItemBinding binding) {
    super(binding.getRoot());
    this.mBinding = binding;
  }

  public RowPokemonListItemBinding getBinding() {
    return mBinding;
  }
}
