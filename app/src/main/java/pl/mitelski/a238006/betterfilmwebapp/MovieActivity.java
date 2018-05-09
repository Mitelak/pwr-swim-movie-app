package pl.mitelski.a238006.betterfilmwebapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_CATEGORY;
import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_IMAGE;
import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_TITLE;

public class MovieActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        displayData(intent.getStringExtra(EXTRA_MOVIE_TITLE),
                intent.getStringExtra(EXTRA_MOVIE_CATEGORY),
                intent.getStringExtra(EXTRA_MOVIE_IMAGE));

        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    private void displayData(String title, String category, String backgroundImg) {
        TextView titleView = findViewById(R.id.movieTitle);
        TextView categoryView = findViewById(R.id.movieCategory);
        ImageView imageView = findViewById(R.id.movieImage);

        titleView.setText(title);
        categoryView.setText(category);
        Picasso.get()
                .load(backgroundImg)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ActorsListFragment();
                case 1:
                    return new ImagesGridFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
