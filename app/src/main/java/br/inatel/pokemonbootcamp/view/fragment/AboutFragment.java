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

import br.inatel.pokemonbootcamp.databinding.FragmentAboutBinding;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.util.Logger;

public class AboutFragment extends Fragment {

  public static final String TAG = Logger.getTag();

  private FragmentAboutBinding mBinding;

  @Inject
  public AboutFragment() {}

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false);

    return mBinding.getRoot();
  }
}
