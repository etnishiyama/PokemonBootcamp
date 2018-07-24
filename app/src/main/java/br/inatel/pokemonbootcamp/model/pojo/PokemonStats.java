package br.inatel.pokemonbootcamp.model.pojo;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class PokemonStats {

  private int hp;
  private int attack;
  private int defense;
  private int speed;
  private int specialAttack;
  private int specialDefense;

  @BindingAdapter("android:text")
  public static void setHp(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setAttack(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setDefense(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setSpeed(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setSpecialAttack(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  @BindingAdapter("android:text")
  public static void setSpecialDefense(TextView view, int value) {
    view.setText(String.valueOf(value));
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpecialAttack() {
    return specialAttack;
  }

  public void setSpecialAttack(int specialAttack) {
    this.specialAttack = specialAttack;
  }

  public int getSpecialDefense() {
    return specialDefense;
  }

  public void setSpecialDefense(int specialDefense) {
    this.specialDefense = specialDefense;
  }

  @Override
  public String toString() {
    return "PokemonStats{" +
        "hp=" + hp +
        ", attack=" + attack +
        ", defense=" + defense +
        ", speed=" + speed +
        ", specialAttack=" + specialAttack +
        ", specialDefense=" + specialDefense +
        '}';
  }
}
