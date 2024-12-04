package com.example.sample.Helper;

import android.util.Log;

import com.example.sample.Domain.Foods;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Foods> cartItems;


    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<Foods> getCartItems() {
        return cartItems;
    }

    public void addToCart(Foods food) {
        cartItems.add(food);
    }
    public void removeFromCart(int position) {
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
        } else {
            Log.e("CartManager", "Invalid position: " + position);
        }

    }


}


