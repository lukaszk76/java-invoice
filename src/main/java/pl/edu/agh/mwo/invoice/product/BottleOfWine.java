package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends OtherProduct {

    public BottleOfWine(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return price.multiply(taxPercent).add(price).add(new BigDecimal("5.56"));
    }
}
