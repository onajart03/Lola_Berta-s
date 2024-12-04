package com.example.sample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sample.Domain.Foods;
import com.example.sample.Helper.CartManager;
import com.example.sample.R;

public class home extends AppCompatActivity {
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cartManager = CartManager.getInstance();

        // Find the button in your layout
        Button addExtraSmallButton = findViewById(R.id.addExtraSmall); // Ensure this ID matches the one in your layout XML

        // Set an OnClickListener for the Add to Cart button
        addExtraSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the item to be added to the cart
                Foods extraSmallPizza = new Foods("Extra Small Pizza", 10000.00);

                // Add to the cart using CartManager
                cartManager.addToCart(extraSmallPizza);

                // Optionally, show a message or update UI
                // Example: Toast.makeText(HomeActivity.this, "Item added to cart!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openaccountProfile(View view) {
        startActivity(new Intent(this, accountProfile.class));
    }


    public void openAboutUs(View view) {
        startActivity(new Intent(this,AboutUs.class));
    }
    public void openmycart(View view) {
        startActivity(new Intent(this, mycart.class));
    }
}


