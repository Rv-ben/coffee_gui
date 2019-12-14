package backEnd.testPackage;

import java.util.ArrayList;
import backEnd.Products.Cookie;
import backEnd.Products.Drink;
import backEnd.Products.Product;

/**
 * Respresents a receipt object
 */
public class Receipt{
	
    public ArrayList<Product> listOfProducts;

    public double subTotal=0,total=0,tax = 1;

    Coupon coupon;

    Receipt(ArrayList<Product> products,double tax){
        this.listOfProducts = products;
        this.tax = tax;
        this.coupon = new Coupon();
    }

    Receipt(ArrayList<Product> products,double tax,Coupon coupon){
        this.listOfProducts = products;
        this.tax = tax;
        this.coupon = coupon;
    }
    
    public Receipt(double tax){
    	this.tax = tax;
    }

    public void setCoupon (Coupon c){
        this.coupon = c;
    }

    public void printReceipt(){
        //String message ="";
    	final double DRINK_RATE = .5;
    	final double PASTRY_DISCOUNT = -1;
    	final double GENERAL_DISCOUNT = -2;
        double productPrice, drinkDiscountPrice;
        
        //listOfProducts.get(0).getName();  //create a method "getName" in product+++++++++++++++++++++++++++++++++
        
        //displaying all the purchased items
        for (int i = 0; i<listOfProducts.size(); i++) {
        	System.out.print("Item No. " + (i+1) + "\n" );
        	System.out.print("Type: " + listOfProducts.get(i).getDescription());
        	System.out.println("Price: " + listOfProducts.get(i).getCost() + "\n\n");
        }
        
        productPrice = getTotalValue();
        
        System.out.println("\nSubtotal: "+ productPrice);
        System.out.println("Tax( "+ tax + "%): "+ productPrice * tax);
        System.out.println("Total: "+ (productPrice + productPrice*tax));

        
        
        // getting an index number of highest price drink
        if (this.coupon.drink == true) {
        	
        	drinkDiscountPrice = listOfProducts.get(findDrink()).getCost() * DRINK_RATE;
        	
        	System.out.print("The drink coupon has been applied to item No." + (findDrink()+1));
        	System.out.printf(", applied discout $%5.2f%n", drinkDiscountPrice );
        	
        }
        	
        
        // getting index numbers of cookies
    	if (this.coupon.pastry == true) {
    		if (getAllCookies() == true) {
            	System.out.printf("The cookie coupon $ %5.2f has been applied%n" ,PASTRY_DISCOUNT );
    		}
    	}
    		
    	// applying general coupon
        if (coupon.general == true) {
        	System.out.printf("The general coupon $ %5.2f has been applied%n" , GENERAL_DISCOUNT);
        }
        	
    	
        
        
        

        

//        for(Product i : listOfProducts){
//
//            message = "Coupon Applied:   ";
//            productPrice = 0;
//
//            if(coupon.drink && i instanceof Drink)
//                productPrice += i.getCost() - i.getCost() * coupon.percent;
//            else if(coupon.pastry && i instanceof Pastry)
//                productPrice += i.getCost() - i.getCost() * coupon.percent;
//            else{
//                message = "";
//                productPrice += i.getCost();
//            }
//
//            subTotal += productPrice;
//            
//            System.out.println(message + i.getDescription() + " - " + productPrice);
//
//        }
//        System.out.println("Subtotal: "+ subTotal);
//        System.out.println("Total: "+ (subTotal + subTotal*tax));
//        subTotal = 0;
//        total = 0;
    }
    
    
    public int findDrink() {
    	//indexOfDicountItems = new ArrayList<Integer>();
    	double price = 0;
    	int priceIndex = 0;

    	for (int i = 0; i < listOfProducts.size(); i++) {
    		if(listOfProducts.get(i) instanceof Drink && (price < listOfProducts.get(i).getCost())) {
    			price = listOfProducts.get(i).getCost();
    			priceIndex = i;
    		}
    	}
    	return priceIndex;
    }
    
    
    public boolean getAllCookies(){
    	boolean coockieIndex = false;
    	
    	for (int i = 0; i < listOfProducts.size(); i++) {
    		if(listOfProducts.get(i) instanceof Cookie) {
    			coockieIndex = true;
    		}
    	}
    	return coockieIndex;
    }
    
    public double getTotalValue(){
    	double price = 0;

    	for (int i = 0; i < listOfProducts.size(); i++) 
    		price += listOfProducts.get(i).getCost();
    	
    	return price;
    }

    
    
}