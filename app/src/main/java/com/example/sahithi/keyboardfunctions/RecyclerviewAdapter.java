package com.example.sahithi.keyboardfunctions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements Filterable {
    Context context;
    List<String> months;
    List<String> filteredmonths;

    boolean flag = false;

    RecyclerviewAdapter(Context context, List<String> months) {
        this.context = context;
        this.months = months;
        this.filteredmonths=months;
    }


    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.months_data, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textView.setText(filteredmonths.get(i));

    }

    @Override
    public int getItemCount() {
        return filteredmonths.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String query = constraint.toString();
                if(query.isEmpty())
                {
                    filteredmonths=months;
                }
                else
                {
                    List<String> filtered = new ArrayList<>();

                    for (int i = 0; i < months.size(); i++) {
                        if (months.get(i).toLowerCase().contains(query.toLowerCase())) {
                            filtered.add(months.get(i));
                        }
                    }
                    filteredmonths=filtered;
                }


                FilterResults filterResults = new FilterResults();
                filterResults.count = filteredmonths.size();
                filterResults.values = filteredmonths;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.count > 0) {
                filteredmonths= (List<String>) results.values;
                    notifyDataSetChanged();

                }
            }
        };
    }



            class MyViewHolder extends RecyclerView.ViewHolder {
                TextView textView;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    textView = itemView.findViewById(R.id.tv_months);

                }
            }



    }

