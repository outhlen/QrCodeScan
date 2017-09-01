package cn.com.zhrl.qrcodescan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import cn.hugo.android.scanner.view.BaseQrCodeScannerView;


public class MainActivity extends AppCompatActivity  {

    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 10;
    private BaseQrCodeScannerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view = (BaseQrCodeScannerView) findViewById(R.id.scan_view);
        view.onCreate();
        view.setOnScanResultListener(new BaseQrCodeScannerView.OnScanResultListener() {
            @Override
            public boolean scanResult(String result) {
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG)
                        .show();
                return false;//true则结束页面，false则不结束
            }
        });

    }

    private void requestPermission(final String[] permission, final int requestCode) {
        ActivityCompat.requestPermissions(this, permission, requestCode);
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        view.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return view.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }


}
