package br.inatel.pokemonbootcamp.model.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

/**
 * Basic DAO for all models
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Dao
public interface BasicDao<T> {

  @Insert
  void insert(T data);

  @Delete
  void delete(T data);

  @Update
  void update(T data);
}
