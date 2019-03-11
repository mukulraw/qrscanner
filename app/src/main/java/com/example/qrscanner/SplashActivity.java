package com.example.qrscanner;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };

    private Handler mWaitHandler = new Handler();

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (hasPermissions(this, PERMISSIONS)) {

            mWaitHandler.postDelayed(new Runnable() {

                @Override
                public void run() {

                    //The following code will execute after the 5 seconds.

                    try {

                        Intent intent = new Intent(SplashActivity.this , QRActivity.class);
                        startActivity(intent);
                        //Let's Finish Splash Activity since we don't want to show this when user press back button.
                        finish();
                    } catch (Exception ignored) {
                        ignored.printStackTrace();
                    }
                }
            }, 1000);

        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_CODE_ASK_PERMISSIONS);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_ASK_PERMISSIONS) {

            Log.d("permmm" , "1");

            if (hasPermissions(this , PERMISSIONS)) {

                mWaitHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //The following code will execute after the 5 seconds.

                        try {

                            Intent intent = new Intent(SplashActivity.this , QRActivity.class);
                            startActivity(intent);
                            //Let's Finish Splash Activity since we don't want to show this when user press back button.
                            finish();
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }
                    }
                }, 1000);

            } else {
                if (
                        ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)
                ) {

                    Log.d("permmm" , "3");

                    Toast.makeText(getApplicationContext(), "Permissions are required for this app", Toast.LENGTH_SHORT).show();
                    finish();

                } else {

                    Log.d("permmm" , "4");
                    Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                            .show();
                    finish();
                    //                            //proceed with logic by disabling the related features or quit the app.
                }
            }
        }

    }

}
