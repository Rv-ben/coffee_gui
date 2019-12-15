package backEnd.Products;

import backEnd.enums.PastryTypes;

public class Croissant extends Pastry{
    boolean heated;
    PastryTypes spec;
    
    public Croissant(PastryTypes general, PastryTypes spec, boolean heated){
        super("Croissant", general);
        this.spec = spec;
        this.heated = heated;
    }

    public double getCost(){
        double cost = 0;
        if (heated == true){
            cost += 0.50;
            System.out.print("here");
        }
        cost += PastryPrices.getCost(this.spec);
        return cost;
    }
    public String getDescription(){
        if (heated)
            return "Heated: " + spec.name()+ "\n";
       return spec.name()+ "\n";
    }
}