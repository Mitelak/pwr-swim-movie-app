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

public class ActorAdapter extends ArrayAdapter<Actor> {
    public ActorAdapter(Context context, ArrayList<Actor> actors) {
        super(context, 0, actors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_actor_item, parent, false);
        }

        Actor actor = getItem(position);
        TextView name = convertView.findViewById(R.id.actorName);
        TextView age = convertView.findViewById(R.id.actorAge);
        ImageView img = convertView.findViewById(R.id.actorImg);

        name.setText(actor.getName() + " " + actor.getSurname());
        age.setText(Integer.toString(actor.getAge()));
        Picasso.get()
                .load(actor.getAvatarUrl())
                .resize(50, 50)
                .centerCrop()
                .into(img);

        return convertView;
    }

}
