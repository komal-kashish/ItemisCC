package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sales.model.Receipt;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SalesTaxTest {

    @BeforeEach
    public void setUp()  {
    }

    @Test
    public void testSalesTaxes1() throws FileNotFoundException {
        Receipt r1 = new Receipt("assets/input1.txt");
        r1.TotalCost();
        assertEquals(String.format("%.2f", r1.getTaxTotal()), "1.50");
        assertEquals(String.format("%.2f", r1.getSaleTotal()), "29.83");
    }

    @Test
    public void testSalesTaxes2() throws FileNotFoundException {
        Receipt r2 = new Receipt("assets/input2.txt");
        r2.TotalCost();
        assertEquals(String.format("%.2f", r2.getTaxTotal()), "7.65");
        assertEquals(String.format("%.2f", r2.getSaleTotal()), "65.15");
    }

    @Test
    public void testSalesTaxes3() throws FileNotFoundException {
        Receipt r3 = new Receipt("assets/input3.txt");
        r3.TotalCost();
        assertEquals(String.format("%.2f", r3.getTaxTotal()), "6.70");
        assertEquals(String.format("%.2f", r3.getSaleTotal()), "74.68");
    }

}