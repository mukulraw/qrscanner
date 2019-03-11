package com.example.qrscanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrscanner.getDataPOJO.getDataBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView photo, qr , seva , group , remark , name , address , marfet;
    TextView fno, rno , mobile , aadhar , age;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        code = getIntent().getStringExtra("code");

        photo = findViewById(R.id.imageView19);
        qr = findViewById(R.id.imageView20);
        fno = findViewById(R.id.textView2);
        rno = findViewById(R.id.textView3);
        seva = findViewById(R.id.imageView21);
        group = findViewById(R.id.imageView22);
        remark = findViewById(R.id.imageView23);
        name = findViewById(R.id.imageView26);
        age = findViewById(R.id.imageView28);
        address = findViewById(R.id.imageView30);
        aadhar = findViewById(R.id.imageView43);
        mobile = findViewById(R.id.imageView45);
        marfet = findViewById(R.id.imageView47);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.sdos.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<getDataBean> call = cr.getData(code);
        //Call<getDataBean> call = cr.getData("1");

        call.enqueue(new Callback<getDataBean>() {
            @Override
            public void onResponse(Call<getDataBean> call, Response<getDataBean> response) {

                //Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                if (response.body().getStatus().equals("1")) {

                    //Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    String ph = response.body().getData().get(0).getPhoto();
                    String ba = response.body().getData().get(0).getBar();
                    String fn = response.body().getData().get(0).getFormNo();
                    String rn = response.body().getData().get(0).getRegNo();
                    String se = response.body().getData().get(0).getSeva();
                    String gr = response.body().getData().get(0).getGroupp();
                    String re = response.body().getData().get(0).getRemark();
                    String na = response.body().getData().get(0).getName();
                    String ag = response.body().getData().get(0).getAge();
                    String ad = response.body().getData().get(0).getAddress();
                    String aa = response.body().getData().get(0).getAadhar();
                    String mo = response.body().getData().get(0).getMobile();
                    String ma = response.body().getData().get(0).getRef();

                    byte[] phbyte = Base64.decode(ph, Base64.DEFAULT);
                    byte[] babyte = Base64.decode(ba, Base64.DEFAULT);
                    byte[] sebyte = Base64.decode(se, Base64.DEFAULT);
                    byte[] grbyte = Base64.decode(gr, Base64.DEFAULT);
                    byte[] rebyte = Base64.decode(re, Base64.DEFAULT);
                    byte[] nabyte = Base64.decode(na, Base64.DEFAULT);
                    //byte[] agbyte = Base64.decode(ag, Base64.DEFAULT);
                    byte[] adbyte = Base64.decode(ad, Base64.DEFAULT);
                    //byte[] aabyte = Base64.decode(aa, Base64.DEFAULT);
                    //byte[] mobyte = Base64.decode(mo, Base64.DEFAULT);
                    byte[] mabyte = Base64.decode(ma, Base64.DEFAULT);

                    Bitmap phbm = BitmapFactory.decodeByteArray(phbyte, 0, phbyte.length);
                    Bitmap babm = BitmapFactory.decodeByteArray(babyte, 0, babyte.length);
                    Bitmap sebm = BitmapFactory.decodeByteArray(sebyte, 0, sebyte.length);
                    Bitmap grbm = BitmapFactory.decodeByteArray(grbyte, 0, grbyte.length);
                    Bitmap rebm = BitmapFactory.decodeByteArray(rebyte, 0, rebyte.length);
                    Bitmap nabm = BitmapFactory.decodeByteArray(nabyte, 0, nabyte.length);
                    //Bitmap agbm = BitmapFactory.decodeByteArray(agbyte, 0, agbyte.length);
                    Bitmap adbm = BitmapFactory.decodeByteArray(adbyte, 0, adbyte.length);
                    //Bitmap aabm = BitmapFactory.decodeByteArray(aabyte, 0, aabyte.length);
                    //Bitmap mobm = BitmapFactory.decodeByteArray(mobyte, 0, mobyte.length);
                    Bitmap mabm = BitmapFactory.decodeByteArray(mabyte, 0, mabyte.length);

                    photo.setImageBitmap(phbm);
                    qr.setImageBitmap(babm);
                    seva.setImageBitmap(sebm);
                    group.setImageBitmap(grbm);
                    remark.setImageBitmap(rebm);
                    name.setImageBitmap(nabm);
                    age.setText(ag);
                    address.setImageBitmap(adbm);
                    aadhar.setText(aa);
                    mobile.setText(mo);
                    marfet.setImageBitmap(mabm);
                    fno.setText(fn);
                    rno.setText(rn);

                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<getDataBean> call, Throwable t) {
                Log.d("failure", t.toString());
            }
        });

        /*switch (code) {
            case "1":
                banner.setImageDrawable(getResources().getDrawable(R.drawable.pic2));
                break;
            case "2":
                banner.setImageDrawable(getResources().getDrawable(R.drawable.pic3));
                break;
            case "3":
                banner.setImageDrawable(getResources().getDrawable(R.drawable.pic4));
                break;
            case "4":
                banner.setImageDrawable(getResources().getDrawable(R.drawable.pic5));
                break;
        }*/

    }
}
