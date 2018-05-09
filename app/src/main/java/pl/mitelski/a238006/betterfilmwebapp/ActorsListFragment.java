package pl.mitelski.a238006.betterfilmwebapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ActorsListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.actors_list_fragment, container, false);

        ListView listView = rootView.findViewById(R.id.actorsListView);

        ActorAdapter adapter = new ActorAdapter(getContext(), loadData());
        listView.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<Actor> loadData() {
        FakeDataProvider fdp = new FakeDataProvider();
        ArrayList<Actor> actors = new ArrayList<>();
        for (int i=0; i < 7; ++i) {
            actors.add(fdp.getActor());
        }
        return actors;
    }

}
