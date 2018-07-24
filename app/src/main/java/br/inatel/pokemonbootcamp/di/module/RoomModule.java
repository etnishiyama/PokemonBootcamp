package br.inatel.pokemonbootcamp.di.module;


import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import br.inatel.pokemonbootcamp.model.db.ApplicationDatabase;
import br.inatel.pokemonbootcamp.model.db.dao.UserDao;
import dagger.Module;
import dagger.Provides;

/**
 * Module containing the dependencies for the database operations.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Module
public class RoomModule {

  private final ApplicationDatabase mDatabase;

  public RoomModule(Application application) {
    this.mDatabase = Room.databaseBuilder(application,
        ApplicationDatabase.class, "db-pokemon-bootcamp").build();
  }

  @Provides
  @Singleton
  UserDao provideUserDao() {
    return mDatabase.usersDao();
  }
}
