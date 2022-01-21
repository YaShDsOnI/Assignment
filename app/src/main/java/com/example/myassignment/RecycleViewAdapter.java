package com.example.myassignment;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    // ArrayList
    ArrayList<Integer> Image;
    Context context;

    // constructor
    public RecycleViewAdapter(Context context, ArrayList<Integer> Image) {
        super();
        this.context = context;
        this.Image = Image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // setting image resource
        viewHolder.imgview.setImageResource(Image.get(i));
    }

    @Override
    public int getItemCount() {
        return Image.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgview;
        public ViewHolder(View itemView) {
            super(itemView);

            // getting ImageView reference
            imgview = (ImageView) itemView.findViewById(R.id.imgView);
        }
    }
}
