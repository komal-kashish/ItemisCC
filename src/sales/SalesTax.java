package sales;

import sales.model.Receipt;

import java.io.FileNotFoundException;

public class SalesTax {

    public static void main(String[] args) throws FileNotFoundException {

        String[] cart = { "assets/input1.txt",
                "assets/input2.txt",
                "assets/input3.txt"};

        for(int i=0;i<3;i++)
        {
            Receipt r = new Receipt(cart[i]);
            r.TotalCost();
            System.out.println("Output " + (i+1) + ":");
            r.printReceipt();
            System.out.println();
        }

    }


}
