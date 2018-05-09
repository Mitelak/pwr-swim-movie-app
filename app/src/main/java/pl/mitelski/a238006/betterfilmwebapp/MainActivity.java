package pl.mitelski.a238006.betterfilmwebapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

// TODO OnRestore
// TODO Fragment
// TODO REFACTOR
public class MainActivity extends AppCompatActivity implements MoviesListAdapter.ItemClickListener {
    public static final String EXTRA_MOVIE_TITLE = "pl.mitelski.TITLE";
    public static final String EXTRA_MOVIE_CATEGORY = "pl.mitelski.CATEGORY";
    public static final String EXTRA_MOVIE_IMAGE = "pl.mitelski.IMAGE";

    private MoviesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.rvMovies);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MoviesListAdapter(this, loadData());

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(getApplicationContext(), "Usunieto", Toast.LENGTH_LONG).show();
                adapter.removeItem(viewHolder.getAdapterPosition());
            }
        };

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


    }

    private ArrayList<Movie> loadData() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        FakeDataProvider provider = new FakeDataProvider();
        for (int i=0; i<15; i++)
            moviesList.add(new Movie(provider.getTitle(), provider.getCategory(), provider.getImageUrl()));
        return moviesList;
    }

    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "Clicked " + adapter.getItem(position) + " on item " + position, Toast.LENGTH_SHORT).show();

        Movie item = adapter.getItem(position);

        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(EXTRA_MOVIE_TITLE, item.getTitle());
        intent.putExtra(EXTRA_MOVIE_CATEGORY, item.getCategory());
        intent.putExtra(EXTRA_MOVIE_IMAGE, item.getImageUrl());
        startActivity(intent);
    }

}
