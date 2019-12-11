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
    private static HashMap<ToppingTypes, Double> prices = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
  
    
    static {
        for (ToppingTypes top : ToppingTypes.values()) { 
           System.out.println("Price for : " + top);
           prices.put(top, Double.valueOf(input.nextLine()));
      }
        
     System.out.println(Arrays.asList(prices));
    }
     public void init() {}
    public static double getCost(ToppingTypes top){
        return prices.get(top);
    }
    
}
