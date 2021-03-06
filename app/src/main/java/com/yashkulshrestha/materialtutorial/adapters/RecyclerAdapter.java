package com.yashkulshrestha.materialtutorial.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yashkulshrestha.materialtutorial.R;
import com.yashkulshrestha.materialtutorial.models.SampleCard;

import java.util.List;

/**
 * Created by Yash Kulshrestha on 2/13/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.SampleCardViewHolder> {

    private String TAG = "com.yashkulshrestha.materialtutorial.adapters.RecyclerAdapter";

    private List<SampleCard> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<SampleCard> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public SampleCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        SampleCardViewHolder holder = new SampleCardViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(SampleCardViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);

        SampleCard currentObj = mData.get(position);
        holder.setData(currentObj, position);
    }

    public void addItem(int position, SampleCard sampleCard) {
        mData.add(position, sampleCard);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    class SampleCardViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        Button action1, deleteAction;
        ImageView image;
        int position;
        SampleCard current;

        public SampleCardViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.cardTitle);
            description = (TextView) itemView.findViewById(R.id.cardSubtitle);
            image = (ImageView) itemView.findViewById(R.id.cardImage);
            action1 = (Button) itemView.findViewById(R.id.cardAction1);
            deleteAction = (Button) itemView.findViewById(R.id.cardAction2);

        }

        public void setData(SampleCard currentObj, final int position) {
            View.OnClickListener onCardActionClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                String message;
                switch (v.getId()) {
                    case R.id.cardAction1:
                        message = "Position " + position + " Action 1 button pressed";
                        break;
                    case R.id.cardAction2:
                        removeItem(position);
                        message = "Item deleted!";
                        break;
                    default:
                        message = "Don't know what happened here!";
                }
                Snackbar.make(v.getRootView().findViewById(R.id.main_app_view), message, Snackbar.LENGTH_SHORT).show();
                }
            };

            this.current = currentObj;

            this.title.setText(current.getTitle());
            this.description.setText(current.getDescription());
            this.image.setImageResource(current.getImageId());
            this.action1.setOnClickListener(onCardActionClickListener);
            this.deleteAction.setOnClickListener(onCardActionClickListener);
            this.position = position;
        }
    }

}
