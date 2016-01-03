package com.huanche.customheadergridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.gridView)
    GridView gridView;
    @Bind(R.id.top_image)
    ImageView imageView;
    @Bind(R.id.stickyHeader)
    TextView header;

    private GridViewAdapter adapter;
    private View headerView;
    private View headerStickyView;
    private LayoutInflater inflater;
    private int height = FormatUtil.pixOfDip(250);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inflater = this.getLayoutInflater();
        adapter = new GridViewAdapter(this, 4);
        gridView.setAdapter(adapter);
        headerView = inflater.inflate(R.layout.header_layout, null);
        headerStickyView = (View) headerView.findViewById(R.id.stickyViewPlaceHolder);


        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem == 0) {
                    int stickyTopY = 0;
                    int imageTopY = 0;
                    View v = gridView.getChildAt(0);
                    v = gridView.getChildAt(0);
                    if (v != null) {
                        imageTopY = v.getTop();
                    }
                    stickyTopY = Math.max(0, height + imageTopY);
                    imageView.setY(imageTopY * 0.8f);
                    header.setY(stickyTopY);
                }
            }
        });
    }
}
