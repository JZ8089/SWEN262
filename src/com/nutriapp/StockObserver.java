package com.nutriapp;

/* 
 * This interface is responsible for updating the stock of an ingredient.
 */
public interface StockObserver {
    void updateStock(Ingredient ingredient);
}
