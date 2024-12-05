package com.example.sample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sample.Adapter.CartAdapter;
import com.example.sample.Helper.CartManager;
import com.example.sample.Domain.Foods;
import com.example.sample.R;

import java.util.List;

public class mycart extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycart);

        // Log the cart contents to confirm items are added correctly



        // Initialize RecyclerView
        recyclerView = findViewById(R.id.cardview); // Ensure this ID matches your XML
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch items from the CartManager
        List<Foods> cartItems = CartManager.getInstance().getCartItems();

        // Set up the adapter with remove functionality
        cartAdapter = new CartAdapter(cartItems, position -> {
            // Remove the item from CartManager
            CartManager.getInstance().removeFromCart(position);

            // Notify the adapter about the removal
            cartAdapter.notifyItemRemoved(position);

            // Show a feedback Toast
            Toast.makeText(this, "Item removed from cart", Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(cartAdapter);
    }

    // Navigation methods (if needed)
    public void openhome(View view) {
        startActivity(new Intent(this, home.class));
    }

    public void openAboutUs(View view) {
        startActivity(new Intent(this, AboutUs.class));
    }

    public void openaccountProfile(View view) {
        startActivity(new Intent(this, accountProfile.class));
    }

    public void openselectPayment(View view) {
        startActivity(new Intent(this, selectPayment.class));
    }
}
