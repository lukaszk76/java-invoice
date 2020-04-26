package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new TreeMap<Product, Integer>();
    private int number = 0;
    
    public Invoice() {
        this.number = new InvoiceNumber().getInvoiceNumber();
    }
    
    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getNumber() {
        return this.number;
    }

    public String print() {
        String printText = "Faktura numer " + this.getNumber();
        int counter = 0;
        for (Product product : products.keySet()) {
            counter++;
            printText = printText + "\n" 
                + product.getName() + " " 
                + products.get(product) + " szt. " 
                + product.getPrice() + " zł";
        }
        printText = printText + "\nLiczba pozycji: " + counter;
        return printText;
    }
}
