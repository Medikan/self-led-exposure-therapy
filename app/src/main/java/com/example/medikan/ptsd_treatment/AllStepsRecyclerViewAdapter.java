package com.example.medikan.ptsd_treatment;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AllStepsRecyclerViewAdapter extends RecyclerView.Adapter<AllStepsRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private Class mClass;
    private String[][] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView treatmentNameTextView, treatmentDescriptionTextView;
        public MyViewHolder(View itemView) {
            super(itemView);

            treatmentNameTextView = itemView.findViewById(R.id.treatmentNameTextView);
            treatmentDescriptionTextView = itemView.findViewById(R.id.treatmentDescriptionTextView);
        }
    }

    public AllStepsRecyclerViewAdapter(Context context, Class targetClass, String[][] myDataset){

        mContext = context;
        mClass = targetClass;
        mDataset = myDataset;
    }

//    void setTreatments(List<String> treatments) {
//
//        mDataset = treatments;
//        notifyDataSetChanged();
//    }

    @Override
    public AllStepsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        AllStepsRecyclerViewAdapter.MyViewHolder vh = new AllStepsRecyclerViewAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AllStepsRecyclerViewAdapter.MyViewHolder holder, final int position) {

        holder.treatmentNameTextView.setText(mDataset[position][0]);
        holder.treatmentDescriptionTextView.setText(mDataset[position][1]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, mClass);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

