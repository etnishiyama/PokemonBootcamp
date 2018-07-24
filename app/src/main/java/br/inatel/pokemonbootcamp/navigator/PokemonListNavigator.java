package br.inatel.pokemonbootcamp.navigator;

import br.inatel.pokemonbootcamp.model.pojo.Pokemon;

public interface PokemonListNavigator {

  void onPokemonClicked(Pokemon pokemon);

  void onPokemonCaptured();

  void onCaptureNewPokemonClicked();
}
