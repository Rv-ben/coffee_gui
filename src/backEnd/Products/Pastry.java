package backEnd.Products;

import backEnd.enums.PastryTypes;

public abstract class Pastry implements Product {
    
    String name;

    PastryTypes general;

    public Pastry(){

    }

    public Pastry(String name, PastryTypes general){
        this.name = name;
        this.general = general;
    }

    public double getCost() {
        double cost = 0;
        System.out.println("General here " + general.toString());
        cost += PastryPrices.getCost(general);
        return cost;
    }

    

}