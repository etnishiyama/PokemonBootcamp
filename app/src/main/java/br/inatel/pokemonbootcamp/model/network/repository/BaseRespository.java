package br.inatel.pokemonbootcamp.model.network.repository;

import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class BaseRespository {

  /**
   * Apply the default schedulers to the {@link io.reactivex.Observable}.
   *
   * @param <T> type of the observable
   * @return observable with the schedules set
   */
  protected <T> ObservableTransformer<T, T> applySchedulers() {
    return upstream -> upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
