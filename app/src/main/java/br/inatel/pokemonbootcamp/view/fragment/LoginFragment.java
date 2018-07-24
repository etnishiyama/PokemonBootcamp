package br.inatel.pokemonbootcamp.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.controller.LoginController;
import br.inatel.pokemonbootcamp.databinding.FragmentAboutBinding;
import br.inatel.pokemonbootcamp.databinding.FragmentLoginBinding;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import io.reactivex.Observable;

public class LoginFragment extends Fragment {

  private static final String TAG = Logger.getTag();

  private FragmentLoginBinding mBinding;

  @Inject
  LoginController mLoginController;

  @Inject
  public LoginFragment() {
  }

  public void setLoginNavigatorListener(LoginNavigator loginNavigator) {
    mLoginController.setLoginNavigator(loginNavigator);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
    mBinding.setController(mLoginController);

    return mBinding.getRoot();
  }
}
