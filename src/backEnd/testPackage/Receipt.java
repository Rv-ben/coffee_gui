package backEnd.testPackage;

import java.util.ArrayList;
import backEnd.Products.Cookie;
import backEnd.Products.Drink;
import backEnd.Products.Product;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * Respresents a receipt object
 */
public class Receipt{
	
	String name;
	
    public ArrayList<Product> listOfProducts = new ArrayList<Product>();

    public double subTotal=0,total=0,discount=0, tax = 1;

    private Coupon coupon;
    
    private ListView display;
    
    private Label subTotalLab,totalLab,taxLab;

    Receipt(ArrayList<Product> products,double tax){
    	this.name = "In progress...!";
        this.listOfProducts = products;
        this.tax = tax;
        this.coupon = new Coupon();
    }

    Receipt(ArrayList<Product> products,double tax,Coupon coupon){
    	this.name = "In progress...!";
        this.listOfProducts = products;
        this.tax = tax;
        this.coupon = coupon;
    }
    
    public Receipt(double tax,ListView display,Label sub,Label tot, Label ta){
    	this.name = "In progress...!";
    	this.tax = tax;
    	this.display = display;
    	this.subTotalLab = sub;
    	this.totalLab = tot;
    	this.taxLab = ta;
    }

    public void setCoupon (Coupon c){
        this.coupon = c;
    }
    
    public void setName(String n) {
    	this.name = n;
    }
    
    public String getName() {
    	return this.name;
    }

    public void printReceipt(){
        //String message ="";
    	final double DRINK_RATE = -.5;
    	final double PASTRY_DISCOUNT = -1;
    	final double GENERAL_DISCOUNT = -2;
        double productPrice, drinkDiscountPrice;
        
        display.getItems().clear();
        //displaying all the purchased items
        for (int i = 0; i<listOfProducts.size(); i++) {
        	//System.out.print("Item No. " + (i+1) + "\n" );
        	display.getItems().add(listOfProducts.get(i).getDescription());
        	display.getItems().add("\t\t\t\t\t - $" + listOfProducts.get(i).getCost() + "\n\n");
        }
        
        productPrice = getTotalValue();
        
     // getting an index number of highest price drink
        if(coupon != null)
        if (this.coupon.drink == true) {
        	drinkDiscountPrice = listOfProducts.get(findDrink()).getCost() * DRINK_RATE;
        	discount += drinkDiscountPrice;
        	display.getItems().add("Applied to item No." + (findDrink()+1));
        	display.getItems().add(String.format("applied discount $%5.2f%n", drinkDiscountPrice ));
        	
        }
        
        // getting index numbers of cookies
        if(coupon != null)
    	if (this.coupon.pastry == true) {
    		//int indexNum = getAllCookies();
    		if (getAllCookies() >0) {
    			System.out.printf("The cookie coupon $ %5.2f has been applied to item No. %d%n" ,PASTRY_DISCOUNT,(getAllCookies()+1));
    			discount += PASTRY_DISCOUNT;
    		}
    		
    	}
    		
    	// applying general coupon
        if(coupon != null)
        if (coupon.general == true) {
        	
        	System.out.printf("The general coupon $ %5.2f has been applied%n" , GENERAL_DISCOUNT);
        	discount += GENERAL_DISCOUNT;
        }
        
        subTotalLab.setText(""+ productPrice);
        System.out.println("\nDiscount: "+ discount);
        System.out.println("Tax( "+ tax + "%): "+ (productPrice+discount) * tax);
        System.out.printf("Tax( %.2f %%): %.2f%n", tax, (productPrice+discount) * tax);
        taxLab.setText(""+tax);
        total = ((productPrice+discount) + (productPrice+discount)*tax);
        totalLab.setText(""+total);
        //System.out.printf( (productPrice+discount) * tax);
        System.out.println("Total: "+ ((productPrice+discount) + (productPrice+discount)*tax));


        

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
    
    
    public int getAllCookies(){
    	int coockieIndex = -1;
    	
    	for (int i = 0; i < listOfProducts.size(); i++) {
    		if(listOfProducts.get(i) instanceof Cookie) {
    			coockieIndex = i;
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
