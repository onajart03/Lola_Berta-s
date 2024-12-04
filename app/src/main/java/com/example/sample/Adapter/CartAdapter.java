package com.example.sample.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sample.Domain.Foods;
import com.example.sample.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Foods> cartItems;
    private OnRemoveClickListener removeClickListener;

    public CartAdapter(List<Foods> cartItems, OnRemoveClickListener removeClickListener) {
        this.cartItems = cartItems;
        this.removeClickListener = removeClickListener;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, true);
        return new CartViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Foods foodItem = cartItems.get(position);
        holder.title.setText(cartItems.get(position).getTitle());
        holder.price.setText(String.format("₱%.2f"+ cartItems.get(position).getPrice()));
        holder.imageView.setImageResource(R.drawable.extralargelechon); // Replace with your image logic


        // Handle Remove button click
        holder.removeBtn.setOnClickListener(v -> {
            if (removeClickListener != null) {
                removeClickListener.onRemoveClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, removeBtn;
        ImageView imageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            removeBtn = itemView.findViewById(R.id.RemoveBtn);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public interface OnRemoveClickListener {
        void onRemoveClick(int position);
    }
}
