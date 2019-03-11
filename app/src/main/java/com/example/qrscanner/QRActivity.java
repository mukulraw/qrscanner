package com.example.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class QRActivity extends AppCompatActivity {

    CodeScannerView codeScanner;
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        codeScanner = findViewById(R.id.scanner_view);

        mCodeScanner = new CodeScanner(this, codeScanner);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                QRActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                            Intent intent = new Intent(QRActivity.this , MainActivity.class);
                            intent.putExtra("code" , result.getText());
                            startActivity(intent);
                            Toast.makeText(QRActivity.this, result.getText(), Toast.LENGTH_SHORT).show();



                    }
                });
            }
        });
        codeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

}
