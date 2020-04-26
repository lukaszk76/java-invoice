package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
<<<<<<< HEAD
        if (name == null
                || name.equals("")
                || price == null
                || tax == null
                || tax.compareTo(new BigDecimal(0)) < 0
                || price.compareTo(new BigDecimal(0)) < 0) {
=======
        Boolean condition1 = (name == null || name.equals("") || price == null || tax == null);
        Boolean condition2 = (tax.compareTo(new BigDecimal(0)) < 0);
        Boolean condition3 = (price.compareTo(new BigDecimal(0)) < 0);
        if (condition1 || condition2 || condition3) {
>>>>>>> c05f663882c0ddea87fdd18f813c38e14132e3ce
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return price.multiply(taxPercent).add(price);
    }
}
