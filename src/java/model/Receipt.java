package java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Receipt {

    private double total;
    private double taxTotal;
    private ArrayList<Item> ItemsList = new ArrayList<>();

    //Reads an input txt file and parsed to extract product details

    public Receipt(String inputFileName) throws FileNotFoundException {

        new Scanner(System.in);
        Scanner filereader;
        File file = new File(inputFileName);
        filereader = new Scanner(file);
        while (filereader.hasNextLine()) { //while input file still has content to read

            String mline = filereader.nextLine();

            //splitting items in the list
            String[] words = mline.split(" ");

            //item description in the file starts with quantity info. Reading this info
            int quantity = Integer.parseInt(words[0]);

            //checking if the item is imported
            boolean isImported = mline.contains("imported");

            String[] ItemsExempted = new String[]{"book", "pills", "chocolate"}; //checking if the item in the exempted list
            //add bandaids, chips etc to expand the list of exempted products in the future

            //Find which type of exemption
            int exemptIndex = ItemfromArray(mline, ItemsExempted);


            String exemptedItemType = null;
            if (exemptIndex != -1) {
                //the item is tax exempted
                //the exempted word is contained at exempted item index
                exemptedItemType = ItemsExempted[exemptIndex];
            }


            int Index = mline.lastIndexOf("at"); // cost of item follows 'at' keyword in the input
            if (Index != -1) { //In lastIndexOf if last index of the given character value is not found, it returns -1

                double cost = Double.parseDouble((mline.substring(Index + 2))); //the cost is after "at"
                String product_name = mline.substring(1, Index); //the name is everything between the quantity and at

                for(int i = 0; i<quantity; i++){
                    //loop for the total quantity of the item in the cart/input file
                    Item mItem = null;

                    if(isImported){
                        /*  --------------- IMPORTED GOODS----------------*/

                        if(exemptedItemType != null){
                            //imported products
                            switch (exemptedItemType) {
                                case "book":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.IMPORTED_BOOK);
                                    break;
                                case "pills":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.IMPORTED_MEDICAL);
                                    break;
                                case "chocolate":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.IMPORTED_FOOD);
                                    break;
                            }

                        } else {
                            //the product is imported and not in any of the exempted categories
                            mItem = new Item(quantity, product_name, cost, ItemsDescription.IMPORTED_OTHERS);
                        }


                    }

                    /*--------------- NON IMPORTED GOODS----------------*/
                    else {
                        //the product is not imported
                        if(exemptedItemType != null){
                            //the product is domestic and is exempt of sales tax

                            switch (exemptedItemType) {
                                case "book":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.BOOK);
                                    break;
                                case "pills":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.MEDICAL);
                                    break;
                                case "chocolate":
                                    mItem = new Item(quantity, product_name, cost, ItemsDescription.FOOD);
                                    break;
                            }

                        } else {
                            //the product is not imported and is sales taxed
                            mItem = new Item(quantity, product_name, cost, ItemsDescription.OTHERS);
                        }
                    }
                    ItemsList.add(mItem); //adding the product to the final receipt
                }
            }

            else{
                System.out.println("couldn't parse the input file. Check for formatting issues");
            }

        }

        filereader.close(); //closing the scanner
    }

    public double[] TotalCost(){


        return new double[]{taxTotal, total};
    }

    private static int ItemfromArray(String line, String[] items) {

        int index;
        int i = 0;
        while (i<items.length) {
            index = line.indexOf(items[i]);
            if(index != -1)
                return i;
            i++;
        }
        return -1;
    }
}
