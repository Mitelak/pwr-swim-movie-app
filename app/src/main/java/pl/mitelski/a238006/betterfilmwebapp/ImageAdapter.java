package pl.mitelski.a238006.betterfilmwebapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class ImageAdapter extends ArrayAdapter<String> {
    public ImageAdapter(Context context, ArrayList<String> urls) {
        super(context, 0, urls);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.gridview_image_item, parent, false);
        }


        String url = getItem(position);
//

        ImageView img = convertView.findViewById(R.id.imageItem);

        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(img);

        return convertView;
    }
}
