package com.example.infonegara;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kyky on 03/11/2016.
 */

public class finishActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_activity);

        ImageView cake = (ImageView)findViewById(R.id.cakee);
        TextView ucapan = (TextView)findViewById(R.id.ucapanselamat);
        TextView to = (TextView)findViewById(R.id.tujuan);
        TextView from = (TextView)findViewById(R.id.from);

        Bundle data = getIntent().getExtras();
        String cakee = data.getString("Cake");
        String anda = data.getString("Anda");
        String Friend = data.getString("Friend");
        String ucapanselamat = data.getString("Ucapan");
        int Gambar = data.getInt("Gambar");

        ucapan.setText(ucapanselamat);
        to.setText(Friend);
        from.setText(anda);
        cake.setImageResource(
                MainActivity.ID_BENDERA[Gambar - 1]);
    }
}
