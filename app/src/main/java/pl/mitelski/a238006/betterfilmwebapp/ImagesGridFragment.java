package pl.mitelski.a238006.betterfilmwebapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class ImagesGridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.images_grid_fragment, container, false);

        GridView gridView = rootView.findViewById(R.id.imagesGridView);
        ArrayList<String> images = new ArrayList<>();
        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
        images.add("https://static.gamespot.com/uploads/scale_super/171/1712892/3367434-aiw_master-1-960x540.jpg");
        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
        images.add("https://static.gamespot.com/uploads/scale_super/171/1712892/3367434-aiw_master-1-960x540.jpg");
        gridView.setAdapter(new ImageAdapter(getContext(), images));


        return rootView;
    }
}
