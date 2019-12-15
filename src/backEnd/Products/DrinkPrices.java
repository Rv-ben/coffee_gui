/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Products;

import backEnd.enums.DrinkTypes;
import java.util.*;

/**
 *
 * @author tansr
 */
public class DrinkPrices {
    
    private static HashMap<DrinkTypes, Double> prices = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
    public static boolean defaultPrices;
    
  public static void init(boolean DEFAULT) {
        defaultPrices = DEFAULT;
          if(defaultPrices){
            
            
            /*houseCoffee,houseDecaf,seaCream, pumpkinSpiceLatte, hazelNutLatte, Olla,housePremium
    greenTea, roseGreenTea, jasmineGreenTea, summerMintTea, taroTea,
    small, medium, large;
}*/
        double[] defaults = {1.00,1.00,1.25,2.00,1.25,1.25,1.00,
                             1.00, 1.25, 1.25, 2.00,1.25,
                             1.00,1.50,2.00};
        int i = 0;
         for (DrinkTypes top : DrinkTypes.values()) {
            
           if(top == DrinkTypes.coffee || top == DrinkTypes.tea) continue;
           System.out.println("Price for : " + top + " " + defaults[i]);
           prices.put(top, defaults[i++]);
           
      }
            
        } else {
      
        for (DrinkTypes top : DrinkTypes.values()) {
            
           if(top == DrinkTypes.coffee || top == DrinkTypes.tea)  continue;
           System.out.println("Price for : " + top);
           prices.put(top, Double.valueOf(input.nextLine()));
           
      }
     System.out.println(Arrays.asList(prices));
    }
    }
    public static double getCost(DrinkTypes top){
        return prices.get(top);
    }
    
}
