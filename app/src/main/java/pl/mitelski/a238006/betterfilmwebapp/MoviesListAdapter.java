package pl.mitelski.a238006.betterfilmwebapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {

    private List<Movie> data;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public MoviesListAdapter(Context context, List<Movie> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recyclerview_movie_item, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie item = data.get(position);
        holder.titleView.setText(item.getTitle());
        holder.categoryView.setText(item.getCategory());

        Picasso.get()
                .load(item.getImageUrl())
                .resize(60, 60)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView;
        TextView categoryView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.movieItemTitle);
            categoryView = itemView.findViewById(R.id.movieItemCategory);
            imageView = itemView.findViewById(R.id.movieItemImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onItemClick(v, getAdapterPosition());
        }

        public String getTitle() {
            return String.valueOf(titleView.getText());
        }
    }

    Movie getItem(int id) {
        return data.get(id);
    }

    void removeItem(int id) {
        data.remove(id);
        notifyItemRemoved(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
