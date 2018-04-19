package pl.mitelski.a238006.betterfilmwebapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_CATEGORY;
import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_IMAGE;
import static pl.mitelski.a238006.betterfilmwebapp.MainActivity.EXTRA_MOVIE_TITLE;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        displayData(intent.getStringExtra(EXTRA_MOVIE_TITLE),
                intent.getStringExtra(EXTRA_MOVIE_CATEGORY),
                intent.getStringExtra(EXTRA_MOVIE_IMAGE));

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
}
