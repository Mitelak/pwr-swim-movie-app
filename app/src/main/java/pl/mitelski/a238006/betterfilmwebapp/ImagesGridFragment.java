package pl.mitelski.a238006.betterfilmwebapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagesGridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.images_grid_fragment, container, false);

        ImageView img1 = rootView.findViewById(R.id.imageGridItem1);
        ImageView img2 = rootView.findViewById(R.id.imageGridItem2);
        ImageView img3 = rootView.findViewById(R.id.imageGridItem3);
        ImageView img4 = rootView.findViewById(R.id.imageGridItem4);
        ImageView img5 = rootView.findViewById(R.id.imageGridItem5);
        ImageView img6 = rootView.findViewById(R.id.imageGridItem6);
        FakeDataProvider fdp = new FakeDataProvider();
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img1);
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img2);
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img3);
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img4);
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img5);
        Picasso.get().load(fdp.getImageUrl()).fit().centerCrop().into(img6);

//        GridView gridView = rootView.findViewById(R.id.imagesGridView);
//        ArrayList<String> images = new ArrayList<>();
//        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
//        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
//        images.add("https://static.gamespot.com/uploads/scale_super/171/1712892/3367434-aiw_master-1-960x540.jpg");
//        images.add("https://i.annihil.us/u/prod/marvel/i/mg/9/a0/537ba3a2c988e.jpg");
//        images.add("https://static.gamespot.com/uploads/scale_super/171/1712892/3367434-aiw_master-1-960x540.jpg");
//        gridView.setAdapter(new ImageAdapter(getContext(), images));


        return rootView;
    }
}
