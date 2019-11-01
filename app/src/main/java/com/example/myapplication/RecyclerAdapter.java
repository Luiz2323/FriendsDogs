package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Ani-Mall",
            "Mascotilove",
            "Duncan",
            "Pelos y Patas",
            "Canis e Cattus",
            "Bigotes",
            "Sanimascotas",
            "Kyron"};

    private String[] details = {"Dirección:",
            "Dirección:", "Dirección:",
            "Dirección:", "Dirección:",
            "Dirección:", "Dirección:",
            "Dirección:"};

    private String[] adress = {"trggwtw",
            "nkodnd", "ondobd",
            "eecec", "cdccecec",
            "ddccec", "dececec",
            "dccecec"};

    private int[] images = { R.mipmap.ic_launcher_animall,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher_duncan,
            R.mipmap.ic_launcher_pelos,
            R.mipmap.ic_launcher_canis,
            R.mipmap.ic_launcher_bigotes,
            R.mipmap.ic_launcher_sanimascotas,
            R.mipmap.ic_launcher_kyron };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView itemAdress;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            itemAdress = (TextView)itemView.findViewById(R.id.item_adress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemAdress.setText(adress[i]);

        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}