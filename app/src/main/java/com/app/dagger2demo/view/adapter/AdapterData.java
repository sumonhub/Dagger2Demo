package com.app.dagger2demo.view.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dagger2demo.R;
import com.app.dagger2demo.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.BrandHolder> {

    private final Context context;
    private List<User> datas = new ArrayList<>();

    public AdapterData(Context context) {
        this.context = context;
    }

    public void setDatas(List<User> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);
        return new BrandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandHolder holder, final int position) {
        holder.tvName.setText(datas.get(position).getFirst_name());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class BrandHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public BrandHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
