package com.yashkulshrestha.materialtutorial.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yashkulshrestha.materialtutorial.R;
import com.yashkulshrestha.materialtutorial.models.NavigationDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yash Kulshrestha on 2/27/2016.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder> {

    private List<NavigationDrawerItem> mData = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public NavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_item, parent, false);
        return new NavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NavViewHolder holder, int position) {
        NavigationDrawerItem current = mData.get(position);

        holder.imgIcon.setImageResource(current.getImageId());
        holder.title.setText(current.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Snackbar.make(v.getRootView().findViewById(R.id.main_app_view), holder.title.getText().toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class NavViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgIcon;

        public NavViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.nav_item_title);
            imgIcon = (ImageView) itemView.findViewById(R.id.nav_item_icon);
        }
    }
}
