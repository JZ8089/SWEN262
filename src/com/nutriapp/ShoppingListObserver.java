package com.nutriapp;

/*
 * This interface is responsible for updating a shopping list.
 */
public interface ShoppingListObserver {
    void update(ShoppingList shoppingList);
}