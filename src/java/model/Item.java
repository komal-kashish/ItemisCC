package java.model;

public class Item {

    private int quantity;
    private String name;
    private double cost;
    private ItemsDescription desc;

    public Item(int count, String product_name, double price, ItemsDescription itemDesc){

        this.quantity = count;
        this.name = product_name;
        this.cost = price;
        this.desc = itemDesc;
    }


}

