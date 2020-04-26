package pl.edu.agh.mwo.invoice;

public class InvoiceNumber {
    private static int number = 0;
    
    public int getInvoiceNumber() {
        number++;
        return number;
    }
}
