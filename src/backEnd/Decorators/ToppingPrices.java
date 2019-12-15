/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.Decorators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import backEnd.enums.ToppingTypes;
/**
 *
 * @author tansr
 */
public class ToppingPrices {
    public static boolean defaultPrices;
    private static HashMap<ToppingTypes, Double> prices = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
  
    


   
     public static void init(boolean dPrice ) {
         System.out.println("beep 1");
         defaultPrices = dPrice;
         
                 System.out.println("beep 2");
       if(defaultPrices) {
           
                   
           for (ToppingTypes top : ToppingTypes.values()) { 
               if(top == ToppingTypes.halfHalf) {
                   prices.put(top,.25);
                       System.out.println("Price for : " + top + " " + .25 );
                       continue;
               }
           System.out.println("Price for : " + top + " " + .5 );
           prices.put(top, .5);
       }
       
       } else {
        for (ToppingTypes top : ToppingTypes.values()) { 
           System.out.println("Price for : " + top);
           prices.put(top, Double.valueOf(input.nextLine()));
       }
         }
       System.out.println(Arrays.asList(prices));
    }
     
       public static double getCost(ToppingTypes top){
        return prices.get(top);
    }
    
}
