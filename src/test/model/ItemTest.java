package test.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sales.model.Item;
import sales.model.ItemsDescription;

import static org.junit.jupiter.api.Assertions.*;


class ItemTest {

    private Item item;
    private int quantity;
    private String name;
    private Double cost;
    private ItemsDescription desc;

    @BeforeEach
    public void setUp() {
        quantity = 1;
        name = "Soup";
        cost = 6.99;
        desc = ItemsDescription.FOOD;
        item = new Item(quantity, name, cost, desc);
    }

    @Test
    public void getQtyReturnsTheCorrectQuantity() {
        assertEquals(quantity, item.getQty());
    }

    @Test
    public void getDetailsReturnsTheCorrectName()  {
        assertEquals(name, item.getName());
    }

    @Test
    public void getCostReturnsTheCorrectCost()  {
        assertEquals(cost, item.getCost());
    }

    @Test
    public void setAfterTaxSetsCorrectAfterTaxPrice()  {
        Double amount = 2.00;
        item.setAfterTax(amount);
        assertEquals(amount, item.getAfterTax());
    }

    @Test
    public void getAfterTaxIsNullIfNotSet()  {
        assertNull(item.getAfterTax());
    }

}
