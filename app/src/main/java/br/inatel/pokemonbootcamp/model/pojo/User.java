package br.inatel.pokemonbootcamp.model.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import static br.inatel.pokemonbootcamp.model.pojo.User.TABLE_NAME;

/**
 * Model class that represents a user within the app.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Entity(tableName = TABLE_NAME)
public class User {

  public static final String TABLE_NAME = "Users";

  @PrimaryKey(autoGenerate = true)
  private int databaseId;
  public String id;
  public String name;
  public String username;
  public String password;
  public String email;

  public int getDatabaseId() {
    return databaseId;
  }

  public void setDatabaseId(int databaseId) {
    this.databaseId = databaseId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
