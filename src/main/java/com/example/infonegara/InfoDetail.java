package com.example.infonegara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class InfoDetail extends Activity {

    private String[] arraykirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_detail);
        final ImageView imageViewGambarBendera = (ImageView) findViewById(
        		R.id.imageViewGambarBendera);
        final TextView textViewNamaNegara = (TextView) findViewById(
        		R.id.textViewNamaNegara);

        final Spinner spinnerkirim = (Spinner)findViewById(R.id.kirim);
        this.arraykirim = new String[]{
          "Teman","Keluarga","Kabogoh","Guru",
        };
        final EditText pengirim = (EditText)findViewById(R.id.pengirim);
        final EditText ucapan = (EditText)findViewById(R.id.ucapan);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arraykirim);
        spinnerkirim.setAdapter(adapter);
        // Peroleh data
        Bundle data = getIntent().getExtras();
     	final String negara = data.getString("Negara");
     	final int idBendera = data.getInt("Bendera");
     	
     	imageViewGambarBendera.setImageResource(
     			MainActivity.ID_BENDERA[idBendera - 1]);
     	textViewNamaNegara.setText(negara);


        Button tombolTutup = (Button) findViewById(R.id.buttonTutup);
        tombolTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String anda = String.valueOf(pengirim.getText());
                int Makanan = idBendera;
                String friend = spinnerkirim.getSelectedItem().toString();
                String selamat = String.valueOf(ucapan.getText());

                Bundle data = new Bundle();
                data.putInt("Cake",idBendera);
                data.putInt("Gambar",Makanan);
                data.putString("Anda",anda);
                data.putString("Friend",friend);
                data.putString("Ucapan",selamat);

                Intent intent = new Intent(InfoDetail.this,finishActivity.class);
                intent.putExtras(data);
                startActivityForResult(intent,1);
            }
        });




	}
}
