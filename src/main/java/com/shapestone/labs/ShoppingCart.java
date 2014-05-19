package com.shapestone.labs;

/**
 * User: msundell
 */
public interface ShoppingCart {
    void addItem(ProductItem item);

    void removeItem(ProductItem item);

    double calculateTotal();

    void emptyShoppingCart();

    int getOrderItemCount();

    int getProductItemCount();
}
