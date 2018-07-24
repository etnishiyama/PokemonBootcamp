package br.inatel.pokemonbootcamp.model.pojo;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import java.util.Arrays;

public class Pokemon {

  private String name;
  private int weight;
  private String picture;
  private int pokeNumber;
  private String[] types;
  private PokemonStats stats;

  @BindingAdapter("android:text")
  public static void setWeight(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setPokeNumber(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setTypes(TextView view, String[] value) {
    view.setText(Arrays.toString(value));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public int getPokeNumber() {
    return pokeNumber;
  }

  public void setPokeNumber(int pokeNumber) {
    this.pokeNumber = pokeNumber;
  }

  public String[] getTypes() {
    return types;
  }

  public void setTypes(String[] types) {
    this.types = types;
  }

  public PokemonStats getStats() {
    return stats;
  }

  public void setStats(PokemonStats stats) {
    this.stats = stats;
  }

  @Override
  public String toString() {
    return "Pokemon{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        ", picture='" + picture + '\'' +
        ", pokeNumber=" + pokeNumber +
        ", types=" + Arrays.toString(types) +
        ", stats=" + stats +
        '}';
  }
}
