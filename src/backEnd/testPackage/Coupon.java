package backEnd.testPackage;



public class Coupon{
    
    public boolean drink = false ,pastry = false, general = false;

    public double percent = 1;

    public Coupon(){
    	drink = false;
    	pastry = false;
    	general = false;
    }

    public Coupon(boolean drink, boolean pastry, boolean general){
        this.drink = drink;
        this.pastry = pastry;
        this.general = general;
    }
    
}