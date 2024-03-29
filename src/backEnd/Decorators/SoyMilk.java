/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.Decorators;

import backEnd.Products.Drink;
import backEnd.enums.ToppingTypes;

/**
 *Extension of topping
 * @author tansr
 */
public class SoyMilk extends Topping {
    /**
     *Soymilk constructor
     * @param base - takes base for topping to be added to
     * @author tansr
     */
    public SoyMilk(Drink base){
        super(base);
    }
    
      
    @Override
    public String getDescription() {
        return base.getDescription() + "Added: Soy Milk\n";
    }

    @Override
    public double getCost() {
        return base.getCost() + ToppingPrices.getCost(ToppingTypes.soyMilk);
    }
}
