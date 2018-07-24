package br.inatel.pokemonbootcamp.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.controller.LoginController;
import br.inatel.pokemonbootcamp.controller.NewAccountController;
import br.inatel.pokemonbootcamp.databinding.FragmentLoginBinding;
import br.inatel.pokemonbootcamp.databinding.FragmentNewAccountBinding;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.util.Logger;

public class NewAccountFragment extends Fragment {

  private static final String TAG = Logger.getTag();

  private FragmentNewAccountBinding mBinding;

  private Toolbar mToolbar;

  @Inject
  NewAccountController mNewAccountController;

  @Inject
  public NewAccountFragment() {
  }

  public void setLoginNavigatorListener(LoginNavigator loginNavigator) {
    mNewAccountController.setLoginNavigator(loginNavigator);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_account, container, false);
    mBinding.setController(mNewAccountController);
    mBinding.setUser(mNewAccountController.getUser());
    setupToolbar();

    return mBinding.getRoot();
  }

  private void setupToolbar() {
    mToolbar = mBinding.toolbar;
    mToolbar.setTitle(R.string.toolbar_new_account);
  }
}
