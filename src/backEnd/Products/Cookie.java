package backEnd.Products;

import backEnd.enums.PastryTypes;

public class Cookie extends Pastry{
    
    PastryTypes spec;
    int qty;
    double groupPrice;
    
    
    public Cookie(PastryTypes general, PastryTypes spec,int qty){
        super("Cookie", spec);
        this.spec = spec;
        this.qty = qty;
    }

    @Override
    public double getCost(){
        double cost = super.getCost();
        if(spec == PastryTypes.oatMeal) groupPrice = PastryPrices.getCost(PastryTypes.threeOatMeal);
        if(spec == PastryTypes.nutChocolateChip) groupPrice = PastryPrices.getCost(PastryTypes.threeNut);
        if(spec == PastryTypes.chocalateChip) groupPrice = PastryPrices.getCost(PastryTypes.threeCookie);
        if(qty%3 == 0){
            cost = (int)(qty/3)*groupPrice;
        }  else if(qty%3 != 0 ){
            cost = (int)(qty/3)*groupPrice   + PastryPrices.getCost(spec)*(qty%3);
        }

        return cost;
    }
    @Override
    public String getDescription(){
       return spec.name() + "\n" + "\t\t\t\tQuantity: "+ qty + "\n";
    }
}