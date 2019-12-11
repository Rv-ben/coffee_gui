package backEnd.Factories;

import backEnd.Products.Cookie;
import backEnd.Products.Croissant;
import backEnd.Products.Drink;
import backEnd.Products.Macaroon;
import backEnd.Products.Pastry;
import backEnd.Products.Product;
import backEnd.enums.Details;

/**
 * Pastry Factory class, implements Factory
 * @author Vanessa Montiel
 * @version 1.0.0
 * @since 11-30-2019
 */
public class PastryFactory implements Factory{

    /**
     * Creates Pastry product given details of type and decoratorators
     * @param pastryType PastryTypes Object
     * @param quantity int 
     * @return Product Object 
     */
    public Product createProduct(Object det) {
        Pastry pastry;

        Details details = (Details)det;

        switch(details.pType){
            case croissant: return new Croissant(details.pType,details.special,details.heated);
            case cookie: return new Cookie(details.pType,details.special,details.qty);
            case macaroon: return new Macaroon(details.pType, details.special,details.qty);
        }
        return null;
    }
    
   
}