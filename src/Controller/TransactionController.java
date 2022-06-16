package Controller;

import Model.Customer;
import Model.Product;
import Model.Transaction;

public class TransactionController {
    private final Transaction transaction;

    public TransactionController(Transaction transaction) {
        this.transaction = transaction;
    }

    public boolean startTransaction() {
        Customer customer = transaction.getCustomer();
        Product product = transaction.getProduct();

        if (customer.getBalance() < product.getProductPrice() * product.getBOUGHT_QUANTITY()) {
            System.out.println("You have insufficient amount of money. ");
            return false;
        }

        double newBalance = customer.getBalance() - product.getProductPrice() * product.getBOUGHT_QUANTITY();
        customer.setBalance(newBalance);

        System.out.println("Success! your new balance is " + newBalance);

        return true;
    }
}
