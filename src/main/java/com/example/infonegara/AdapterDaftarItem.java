package com.example.infonegara;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterDaftarItem extends BaseAdapter {
    private static ArrayList<RincianData> listData;
    private LayoutInflater layout;

    // Konstruktor
    public AdapterDaftarItem(Context context,
                             ArrayList<RincianData> results) {
        listData = results;
        layout = LayoutInflater.from(context);
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View cV, ViewGroup parent) {
        ViewData vd;
        if (cV == null) {
            cV = layout.inflate(R.layout.detail, null);
            vd = new ViewData();
            vd.imageViewBendera = (ImageView) cV.findViewById(
                    R.id.imageViewBendera);

            vd.textViewNegara = (TextView) cV.findViewById(
                    R.id.textViewNegara);

            cV.setTag(vd);
        } else {
            vd = (ViewData) cV.getTag();
        }

        vd.imageViewBendera.setImageResource(
                MainActivity.ID_BENDERA[listData.get(position)
                        .perolehIdBendera() - 1]);
        vd.textViewNegara.setText(listData.get(position)
                .perolehNegara());
        return cV;
    }

    static class ViewData {
        ImageView imageViewBendera;
        TextView textViewNegara;
        TextView textViewIbukota;
    }
}
