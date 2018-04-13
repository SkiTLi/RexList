package com.sktl.rexlist.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sktl.rexlist.R;
import com.sktl.rexlist.models.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by USER-PC on 13.04.2018.
 */

public class FilmsAdapter extends ArrayAdapter<Film> {
    public FilmsAdapter(Context ctx, ArrayList<Film> films) {
        super(ctx, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Film film = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_film_item, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.textViewItemName);
        TextView nameEng = (TextView) convertView.findViewById(R.id.textViewItemNameEng);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageViewItem);
        name.setText(position + 1 + ". " + film.getName());
        nameEng.setText(film.getName_eng());
        Glide.with(getContext()).load(film.getImage()).into(image);
        return convertView;
    }

}
