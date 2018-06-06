package org.chen.book.refactor.before;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

//    public String statement() {
//
//    }
}
