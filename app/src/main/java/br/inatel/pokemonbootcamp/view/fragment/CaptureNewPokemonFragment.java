package br.inatel.pokemonbootcamp.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import br.inatel.pokemonbootcamp.R;
import br.inatel.pokemonbootcamp.controller.CaptureNewPokemonController;
import br.inatel.pokemonbootcamp.controller.LoginController;
import br.inatel.pokemonbootcamp.databinding.FragmentCapturePokemonBinding;
import br.inatel.pokemonbootcamp.databinding.FragmentLoginBinding;
import br.inatel.pokemonbootcamp.navigator.LoginNavigator;
import br.inatel.pokemonbootcamp.navigator.PokemonListNavigator;
import br.inatel.pokemonbootcamp.util.Logger;
import br.inatel.pokemonbootcamp.view.activity.QrCodeReaderActivity;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class CaptureNewPokemonFragment extends Fragment {

  public static final String TAG = Logger.getTag();

  private FragmentCapturePokemonBinding mBinding;

  @Inject
  CaptureNewPokemonController mCaptureNewPokemonController;

  @Inject
  Context mContext;

  @Inject
  public CaptureNewPokemonFragment() {
  }

  public void setPokemonListNavigator(PokemonListNavigator pokemonListNavigator) {
    mCaptureNewPokemonController.setPokemonListNavigator(pokemonListNavigator);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    if (Logger.DEBUG) Log.d(TAG, "onCreateView");

    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_capture_pokemon, container,
        false);
    startActivityForResult(new Intent(mContext, QrCodeReaderActivity.class), CAMERA);

    return mBinding.getRoot();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (CAMERA == requestCode) {
      if (data != null) {
        Toast.makeText(mContext, R.string.toast_pokemon_captured, Toast.LENGTH_LONG).show();
        mCaptureNewPokemonController.capturePokemon(data.getStringExtra(QrCodeReaderActivity
            .QR_CODE_RESULT));
      }
    }
  }
}
