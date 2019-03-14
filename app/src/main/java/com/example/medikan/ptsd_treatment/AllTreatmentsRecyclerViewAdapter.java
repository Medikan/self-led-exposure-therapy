package com.example.medikan.ptsd_treatment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;

//TODO Change name to be more generic since this is the recylcer view adapter for both All Treatments and All steps
public class AllTreatmentsRecyclerViewAdapter extends Adapter<AllTreatmentsRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private Class mClass;
    private List<Treatment> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView treatmentNameTextView, treatmentDescriptionTextView;
        public MyViewHolder(View itemView) {
            super(itemView);

            treatmentNameTextView = itemView.findViewById(R.id.treatmentNameTextView);
            treatmentDescriptionTextView = itemView.findViewById(R.id.treatmentDescriptionTextView);
        }
    }

    public AllTreatmentsRecyclerViewAdapter(Context context, Class targetClass){

        mContext = context;
        mClass = targetClass;
    }

    @Override
    public AllTreatmentsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AllTreatmentsRecyclerViewAdapter.MyViewHolder holder, final int position) {

        holder.treatmentNameTextView.setText(mDataset.get(position).getTreatment());
        holder.treatmentDescriptionTextView.setText(mDataset.get(position).getDescription());

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
        if (mDataset != null)
            return mDataset.size();
        return 0;
    }


    public void setTreatments(List<Treatment> treatments) {

        mDataset = treatments;
        notifyDataSetChanged();
    }
}
