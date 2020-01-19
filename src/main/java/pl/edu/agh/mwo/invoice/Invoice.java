package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products;

	public Invoice() {
		products = new ArrayList();
	}
	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity < 1) throw new IllegalArgumentException("Number of products must be at least 1!"); 
		
		for (int i = 0; i<quantity; i++) {
			this.addProduct(product);
		}
	}

	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal("0");
		
		for (Product product: products) {
			subtotal = subtotal.add(product.getPrice());
		}
		return subtotal;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal("0");
		
		for (Product product: products) {
			total = total.add(product.getPriceWithTax());
		}
		return total;
	}
	
	public BigDecimal getTax() {
		BigDecimal tax = new BigDecimal("0");
		for (Product product: products) {
			tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
		}
		return tax;
	}
}
