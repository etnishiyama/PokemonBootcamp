package br.inatel.pokemonbootcamp.controller;

import android.databinding.ObservableField;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.model.pojo.Pokemon;

public class PokemonDetailsController {

  public ObservableField<Pokemon> pokemon;

  @Inject
  PokemonDetailsController(){
    pokemon = new ObservableField<>();
  }
}
