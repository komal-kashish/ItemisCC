package sales.model;

public class Item {

    private int quantity;
    private String name;
    private double cost;
    private ItemsDescription desc;
    private Double afterTax;


    public Item(int count, String product_name, double price, ItemsDescription itemDesc){

        this.quantity = count;
        this.name = product_name;
        this.cost = price;
        this.desc = itemDesc;
    }


    public Double getCost() {
        return this.cost;
    }

    public int getQty() {
        return this.quantity;
    }

    public boolean isItemExempted() {
        return this.desc.isExempted();
    }

    public boolean isItemImported() {
        return this.desc.isImported();
    }

    public Double setAfterTax(Double amount){
        return this.afterTax = amount;
    }

    public Double getAfterTax(){
        return this.afterTax;
    }

    public String getName() {
        return this.name;
    }
}

