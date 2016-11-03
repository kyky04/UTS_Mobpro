package com.example.infonegara;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class MainActivity extends Activity { 
    static final public Integer[] ID_BENDERA = {
        R.drawable.at_s,
        R.drawable.au_s,
        R.drawable.bt_s,
        R.drawable.ca_s,
        R.drawable.fr_s,
    };

	ArrayList<RincianData> hasil; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
		
        ArrayList<RincianData> listData = perolehData();
	        
        final ListView listViewData = (ListView) findViewById(R.id.listViewData);
        AdapterDaftarItem adapter = new AdapterDaftarItem(this, listData);
        listViewData.setAdapter(adapter);
        listViewData.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
                Object terpilih = listViewData.getItemAtPosition(position);
                RincianData rincian = (RincianData) terpilih;
                
                // Bentuk Intent untuk menampilkan detail negara
                Intent intent = new Intent(MainActivity.this, InfoDetail.class);

                Bundle data = new Bundle();
                data.putString("Negara", rincian.perolehNegara());
                data.putInt("Bendera", rincian.perolehIdBendera());
                
                intent.putExtras(data);
                startActivityForResult(intent, 1);
         	}          	 
        });
    }
	
    private ArrayList<RincianData> perolehData(){
        hasil = new ArrayList<RincianData>(); 
    	
        RincianData data;
    	
        data = new RincianData("Cake 1",1);
        hasil.add(data);
  
        data = new RincianData("Cake 2", 2);
        hasil.add(data);

        data = new RincianData("Cake 3", 3);
        hasil.add(data);

        data = new RincianData("Cake 4", 4);
        hasil.add(data);

        data = new RincianData("Cake 5", 5);
        hasil.add(data);

        return(hasil);
    }	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
