/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.Products;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import backEnd.enums.PastryTypes;

/**
 *
 * @author tansr
 */
public class PastryPrices {

    private static HashMap<PastryTypes, Double> prices = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
    public static boolean defaultPrices;
 
    public  static void init(boolean DEF) {
        defaultPrices = DEF;
        
         System.out.println(defaultPrices);
        if(defaultPrices){
            double[] defaults = {1.50,3.25,1.50,1.00,2.00,2.00,3.00,10.00,2.50,5.00};
            //empty
            int i = 0;
             for (PastryTypes top : PastryTypes.values()) { 
            if(top == PastryTypes.cookie) continue;
           System.out.println("Price for : " + top + " " +defaults[i] );
           prices.put(top, defaults[i++]);
      }
  
            
        } else {
        for (PastryTypes top : PastryTypes.values()) { 
            if(top == PastryTypes.cookie) continue;
           System.out.println("Price for : " + top);
           prices.put(top, Double.valueOf(input.nextLine()));
      }
        System.out.println("Price for three cookies");
        prices.put(PastryTypes.threeCookie,Double.valueOf(input.nextLine()));
        System.out.println("Price for six macaroons");
        prices.put(PastryTypes.sixMac,Double.valueOf(input.nextLine()));
        
        
     System.out.println(Arrays.asList(prices));
    }
    
    }
    public static double getCost(PastryTypes top){
        return prices.get(top);
    }
    
}
