package com.huanche.customheadergridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by fanzhengchen on 1/3/16.
 */
public class GridViewAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private int columns;
    private int HEAD_HEIGHT;

    public GridViewAdapter(Activity activity, int columns) {
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.columns = columns;
        //this.HEAD_HEIGHT =
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(parent.getContext(), R.layout.grid_item, null);
        if (position < columns) {

            convertView.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, FormatUtil.pixOfDip(299)));
        } else {
            convertView.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, FormatUtil.pixOfDip(100)));
            ImageView imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
            imageView.setImageResource(R.drawable.wall_paper);
        }
        return convertView;
    }
}
