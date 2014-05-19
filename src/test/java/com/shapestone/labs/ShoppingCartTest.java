package com.shapestone.labs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Test
    public void testOfAddingToShoppingCartShouldContainOneItem() throws Exception {
        // given
        shoppingCart = new ShoppingCartImpl();
        ProductItem item = new ProductItem("stapler", 1, 5.99D);

        // when
        shoppingCart.addItem(item);

        // then
        assertThat(shoppingCart, is(not(nullValue())));
        assertThat(shoppingCart.getOrderItemCount(), is(equalTo(1)));
        assertThat(shoppingCart.getProductItemCount(), is(equalTo(1)));
        assertThat(shoppingCart.calculateTotal(), is(equalTo(5.99D)));
    }

    @Test
    public void testOfAddingProductItemWithACountOfTheeShouldYieldTheCorrectTotal() throws Exception {
        // given
        shoppingCart = new ShoppingCartImpl();
        ProductItem item = new ProductItem("stapler", 3, 5.99D);

        // when
        shoppingCart.addItem(item);

        // then
        assertThat(shoppingCart, is(not(nullValue())));
        assertThat(shoppingCart.getOrderItemCount(), is(equalTo(3)));
        assertThat(shoppingCart.getProductItemCount(), is(equalTo(1)));
        assertThat(shoppingCart.calculateTotal(), is(equalTo(3*5.99D)));
    }

    @Test
    public void testOfAddingMultipleProductItemsWithDifferentCountsShouldYieldTheCorrectTotalAndCounts() throws Exception {
        // given
        shoppingCart = new ShoppingCartImpl();
        ProductItem item1 = new ProductItem("stapler", 3, 5.99D);
        ProductItem item2 = new ProductItem("pencils", 10, 0.49D);

        // when
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        // then
        assertThat(shoppingCart, is(not(nullValue())));
        assertThat(shoppingCart.getOrderItemCount(), is(equalTo(13)));
        assertThat(shoppingCart.getProductItemCount(), is(equalTo(2)));
        assertThat(shoppingCart.calculateTotal(), is(equalTo(3*5.99D + 10*0.49)));
    }
}