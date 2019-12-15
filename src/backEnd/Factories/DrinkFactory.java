package backEnd.Factories;

import java.util.HashMap;

import backEnd.Decorators.Boba;
import backEnd.Decorators.CoconutJelly;
import backEnd.Decorators.FreshStrawberry;
import backEnd.Decorators.GrassJelly;
import backEnd.Decorators.HalfHalf;
import backEnd.Decorators.LycheeJelly;
import backEnd.Decorators.PassionFruitJelly;
import backEnd.Decorators.PoppingBoba;
import backEnd.Decorators.SoyMilk;
import backEnd.Decorators.WhipCream;
import backEnd.Products.Coffee;
import backEnd.Products.Drink;
import backEnd.Products.Product;
import backEnd.Products.Tea;
import backEnd.enums.Details;
import backEnd.enums.ToppingTypes;
import backEnd.Decorators.Milk;

/**
 * Drink Factory class, implements Factory
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 11-30-2019
 */
public class DrinkFactory implements Factory{
     
    /**
     * Creates Drink Product given details of size/type and decoratorators
     * @param typeSize TypeSizeStruct Object
     * @param decorators ArrayList<ToppingType> Object
     * @return Product Object 
     */
    HashMap<String,Double> priceMap;
 
    
    public Product createProduct(Object details) {

        Drink drink;
        Details detail = (Details)details;


        drink = drinkType(detail);

        //Checks if there decorators
        if(detail.toppings != null){
        
            for(ToppingTypes i: detail.toppings){
                drink = addDecorators(i, drink);
            }

        }

        return drink;
    }

    /**
     * Selects base drink object given type and size
     * @param type DrinkType Enum
     * @param size Size Enum
     * @return Drink Object, null if not listed
     */
    public Drink drinkType(Details details){

        switch(details.type){
            case coffee: return new Coffee(details.size,details.spec);
            case tea: return new Tea(details.size, details.spec,details.sweetness);
        }
        return null;
    }

    /**
     * Adds decorator given topping and base drink
     * @param toppings 
     * @param drink
     * @return Drink Object, base drink if not found
     */
    public Drink addDecorators(ToppingTypes topping,Drink drink){

        switch(topping){
            case milk: return new Milk(drink);
            case SoyMilk: return new SoyMilk(drink);
            case halfHalf: return new HalfHalf(drink);
            case boba: return new Boba(drink);
            case poppingBoba: return new PoppingBoba(drink);
            case passionFruitJelly: return new PassionFruitJelly(drink);
            case lycheeJelly: return new LycheeJelly(drink);
            case grassJelly: return new GrassJelly(drink);
            case coconutJelly: return new CoconutJelly(drink);
            case whipCream: return new WhipCream(drink);
            case freshStrawberry: return new FreshStrawberry(drink);
        }
        return drink;
    }
}