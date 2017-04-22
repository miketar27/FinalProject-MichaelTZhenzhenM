package com.example.miket.finalproject_michaeltzhenzhenm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miket on 4/21/2017.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    Context mContext;
    private ArrayList<Player> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public PlayerAdapter(ArrayList<Player> dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;


//        // create a new view
//        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);
        holder.mPlayerFirstName.setText(mDataset.get(position).getFirstName());
        holder.mPlayerLastName.setText(mDataset.get(position).getLastName());
        holder.mJerseyNumber.setText(mDataset.get(position).getJerseyNumber());
        holder.mPlayerFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProfileActivity.class);
                intent.putExtra("A Player", mDataset.get(holder.getAdapterPosition()));
                mContext.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setFilter(ArrayList<Player> newList) {
        mDataset = new ArrayList<>();
        mDataset.addAll(newList);
        notifyDataSetChanged();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mPlayerImage;
        public TextView mPlayerFirstName;
        public TextView mPlayerLastName;
        public TextView mJerseyNumber;


        public ViewHolder(View v) {
            super(v);
            mPlayerImage = (ImageView) v.findViewById(R.id.roster_player_profile_pic);
            mPlayerFirstName = (TextView) v.findViewById(R.id.roster_player_first_name);
            mPlayerLastName = (TextView) v.findViewById(R.id.roster_player_last_name);
            mJerseyNumber = (TextView) v.findViewById(R.id.roster_player_jersey_number);
//            v.setOnClickListener(new View.OnClickListener() {
//                int position = getAdapterPosition();

//                @Override
//                public void onClick(View v) {
//                    Intent intent= new Intent(mContext, DetailActivity.class);
//                    intent.putExtra("A Blogpost", mDataset.get(holder.getAdapterPosition()));
//                    mContext.startActivity(intent);
//                }
//            });
        }
    }


}
