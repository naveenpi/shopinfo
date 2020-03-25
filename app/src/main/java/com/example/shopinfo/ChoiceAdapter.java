package com.example.shopinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ChoiceViewHolder>{


    ChoiceModel  choiceModel ;
    public ChoiceAdapter() {
        super();
        choiceModel = choiceModel.getSingleton();
    }

    @NonNull
    @Override
    public ChoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.betterchoiceview,parent,false);
        ChoiceViewHolder vh = new ChoiceViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceViewHolder holder, int position) {
        TextView choiceName = holder.convienceViewReference.findViewById(R.id.choiceName);
        TextView choiceDescription=holder.convienceViewReference.findViewById(R.id.choiceDescription);
        ImageView image=holder.convienceViewReference.findViewById(R.id.choiceImageView);
       // if(position%2==0) {
//            text.setBackgroundResource(R.color.colorAccent);
//            text.setText(choiceModel.choiceList.get(position).choice);
        choiceName.setText(choiceModel.choiceList.get(position).name);
        choiceDescription.setText(choiceModel.choiceList.get(position).description);
        image.setImageResource(choiceModel.choiceList.get(position).image);
//        }
//        else{
//            //text.setText(choiceModel.choiceList.get(position).choice);
//        }

    }

    @Override
    public int getItemCount() {
        return choiceModel.choiceList.size();
    }

    public static class ChoiceViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout convienceViewReference;
        public ChoiceViewHolder(LinearLayout a) {
            super(a);
            convienceViewReference = a;
        }
    }
}