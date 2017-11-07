// Listing 9.1  Skeleton Java class implementing the concept of the expense item

package com.curry.expenses;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Expense {
    private Calendar date;
    private int amountDollars;
    private int amountCents;
    private String merchantName;
    private String category;
    public Expense(String dateString, int amountDollars, int amountCents,
		   String category, String merchantName) throws ParseException {
	this.date = Calendar.getInstance();
	this.date.setTime(new SimpleDateFormat(
					       "yyyy-MM-dd").parse(dateString));
	this.amountDollars = amountDollars;
	this.amountCents = amountCents;
	this.merchantName = merchantName;
	this.category = category;
    }
    public Calendar getDate() {
	return date;
    }
    public int getAmountDollars() {
	return amountDollars;
    }
    public int getAmountCents() {
	return amountCents;
    }
    public String getMerchantName() {
	return merchantName;
    }
    public String getCategory() {
	return category;
    }
    public int amountInCents() {
	return this.amountDollars*100 + this.amountCents;
    }
}
