package com.example.tugasakhir.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugasakhir.Model.Getbahasa.DataBahasaPemrogramanItem;
import com.example.tugasakhir.databinding.ItemBahasapemrogramanBinding;

import java.util.List;

public class BahasaAdapter extends RecyclerView.Adapter<BahasaAdapter.ViewHolder> {

    List<DataBahasaPemrogramanItem> data;

    private OnClickListener onClickListener;

    boolean toogle;

    public void setToogle(boolean Toogle) {
        this.toogle = toogle;
    }

    public BahasaAdapter(List<DataBahasaPemrogramanItem> datalist) {
        this.data = datalist;
    }

    ;


    @NonNull
    @Override
    public BahasaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBahasapemrogramanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BahasaAdapter.ViewHolder holder, int position) {
        DataBahasaPemrogramanItem responseGetBahasa = data.get(position);

        holder.binding.tvNama.setText(responseGetBahasa.getNama());
        holder.binding.tvTahun.setText(responseGetBahasa.getTahun());
        holder.binding.tvDeskripsi.setText(responseGetBahasa.getDeskripsi());
        Glide.with(holder.binding.imgEvent)
                .load(responseGetBahasa.getImage())
                .into(holder.binding.imgEvent);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnClickListener {
        void OnClick(boolean now);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBahasapemrogramanBinding binding;

        public ViewHolder(@NonNull ItemBahasapemrogramanBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
