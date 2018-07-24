package br.inatel.pokemonbootcamp.model.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import br.inatel.pokemonbootcamp.model.pojo.User;

/**
 * DAO for accessing the {@link User} models
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Dao
public interface UserDao extends BasicDao<User> {

  @Query("SELECT * FROM " + User.TABLE_NAME)
  LiveData<List<User>> getAllUsers();

  @Query("SELECT * FROM " + User.TABLE_NAME + " WHERE id=:id")
  LiveData<User> getUserById(String id);

  @Query("DELETE FROM " + User.TABLE_NAME)
  void nukeTable();
}
