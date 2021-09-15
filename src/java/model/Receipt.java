package java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Receipt {

    //Reads an input txt file and parsed to extract product details

    public Receipt(String inputFileName) throws FileNotFoundException {

        new Scanner(System.in);
        Scanner filereader;
        File file = new File(inputFileName);
        filereader = new Scanner(file);
        while (filereader.hasNextLine()) { //while input file still has content to read

        }

        filereader.close(); //closing the scanner


    }
}
