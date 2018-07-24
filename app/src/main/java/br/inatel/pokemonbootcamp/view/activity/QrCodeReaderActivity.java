package br.inatel.pokemonbootcamp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import br.inatel.pokemonbootcamp.util.Logger;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrCodeReaderActivity extends AppCompatActivity
    implements ZXingScannerView.ResultHandler {

  public static final String TAG = Logger.getTag();

  public static final String QR_CODE_RESULT = "QR_CODE_RESULT";

  private ZXingScannerView mScannerView;

  public static void startActivity(Context context) {
    if (Logger.DEBUG) Log.d(TAG, "startActivity");
    Intent intent = new Intent(context, QrCodeReaderActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  public QrCodeReaderActivity() {
    if (Logger.DEBUG) Log.d(TAG, "contructor");
  }

  @Override
  public void onCreate(Bundle state) {
    super.onCreate(state);
    mScannerView = new ZXingScannerView(this);
    List<BarcodeFormat> types = new ArrayList<>();
    types.add(BarcodeFormat.QR_CODE);
    mScannerView.setFormats(types);
    mScannerView.setAutoFocus(true);
    setContentView(mScannerView);
  }

  @Override
  public void onResume() {
    super.onResume();
    mScannerView.setResultHandler(this);
    mScannerView.startCamera();
  }

  @Override
  public void onPause() {
    super.onPause();
    mScannerView.stopCamera();
  }

  @Override
  public void handleResult(Result rawResult) {
    if (Logger.DEBUG) Log.d(TAG, "handleResult");

    if (!"".equals(rawResult.getText())) {
      if (Logger.DEBUG) Log.d(TAG, rawResult.getText());
      Intent intent = new Intent();
      intent.putExtra(QR_CODE_RESULT, rawResult.getText());
      setResult(RESULT_OK, intent);
      mScannerView.resumeCameraPreview(this);
      finish();
    }
  }
}