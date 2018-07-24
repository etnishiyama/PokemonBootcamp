package br.inatel.pokemonbootcamp.model.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.inatel.pokemonbootcamp.model.db.dao.UserDao;
import br.inatel.pokemonbootcamp.model.pojo.User;

/**
 * Database for accessing the App DAOs local objects
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 06/02/2018.
 */
@Database(entities = {User.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

  public abstract UserDao usersDao();
}