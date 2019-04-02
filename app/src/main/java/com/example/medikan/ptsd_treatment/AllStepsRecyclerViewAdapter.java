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
    private List<TreatmentStep> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView treatmentNameTextView, treatmentDescriptionTextView;
        public MyViewHolder(View itemView) {
            super(itemView);

            treatmentNameTextView = itemView.findViewById(R.id.treatmentNameTextView);
            treatmentDescriptionTextView = itemView.findViewById(R.id.treatmentDescriptionTextView);
        }
    }

    public AllStepsRecyclerViewAdapter(Context context, Class targetClass){

        mContext = context;
        mClass = targetClass;
    }

    @Override
    public AllStepsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        AllStepsRecyclerViewAdapter.MyViewHolder vh = new AllStepsRecyclerViewAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AllStepsRecyclerViewAdapter.MyViewHolder holder, final int position) {

        holder.treatmentNameTextView.setText(mContext.getResources().getString(mContext.getResources().getIdentifier(mDataset.get(position).getTreatmentStep(), "string", "com.example.medikan.ptsd_treatment")));
        holder.treatmentDescriptionTextView.setText(mContext.getResources().getString(mContext.getResources().getIdentifier(mDataset.get(position).getDescription(), "string", "com.example.medikan.ptsd_treatment")));

        if (mDataset.get(position).getIsComplete()) {
            //TODO add something to show completion
        }
        else if (position == 0 || mDataset.get(position - 1).getIsComplete()) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(mContext, mClass);
                    intent.putExtra("treatmentStepID", mDataset.get(position).getTreatmentStepID());
                    mContext.startActivity(intent);
                }
            });
        }
        else {
            //TODO add something to show not complete but not 'unlocked' yet (b/c you need to do the previous treatment step)
        }
    }

    @Override
    public int getItemCount() {
        if(mDataset != null)
            return mDataset.size();
        else return 0;
    }


    void setTreatmentSteps(List<TreatmentStep> treatmentSteps) {

        mDataset = treatmentSteps;
        notifyDataSetChanged();
    }
}

