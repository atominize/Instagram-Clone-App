package com.atominize.instagramcloneapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.atominize.instagramcloneapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context context;
    private LayoutInflater inflater;
    private int layoutResource;
    private ArrayList<String> imageUrls;

    public GridImageAdapter(Context context, int layoutResource, ArrayList<String> imageUrls) {
        super(context, layoutResource, imageUrls);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.layoutResource = layoutResource;
        this.imageUrls = imageUrls;
    }

    private static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.ivGridImage);
            viewHolder.progressBar = convertView.findViewById(R.id.pbGridImage);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String imageUrl = getItem(position);

        Picasso.get().load(imageUrl).placeholder(R.mipmap.ic_launcher).into(viewHolder.imageView);

        return convertView;
    }
}
