package br.inatel.pokemonbootcamp.util;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * This provides methods to help Activities load their UI.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
public class FragmentHelper {

  private static final String TAG = Logger.getTag();

  /**
   * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
   * performed by the {@code fragmentManager}.
   */
  public static void addFragment(@NonNull FragmentManager fragmentManager,
                                 @NonNull Fragment fragment, int frameId, @Nullable String tag) {
    if (Logger.DEBUG) Log.d(TAG, "addFragment: " + tag);
    if (!fragment.isAdded()) {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      transaction.add(frameId, fragment);
      if (tag != null) transaction.addToBackStack(tag);
      transaction.commit();
    } else {
      Log.e(TAG, "addFragment error: Fragment already added!");
    }
  }

  /**
   * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
   * performed by the {@code fragmentManager}.
   */
  public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                     @NonNull Fragment fragment, int frameId, @Nullable String
                                         tag) {
    if (Logger.DEBUG) Log.d(TAG, "replaceFragment: " + tag);
    if (!fragment.isAdded()) {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      transaction.replace(frameId, fragment);
      if (tag != null) transaction.addToBackStack(tag);
      transaction.commit();
    } else {
      Log.e(TAG, "addFragment error: Fragment already added!");
    }
  }
}