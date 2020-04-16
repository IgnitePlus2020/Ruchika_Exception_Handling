/*
Simple program for the Use case of Swiggy Delivery where we first enter the pincodes where delivery is possible and
prompt the user for input of his/her pincode and then display if delivery is possible or not!
 */
package com.tgt.igniteplus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by user on 4/15/2020.
 */
public class SwiggyDelivery {
    public static void main(String args[]){
        System.out.println("Welcome to Swiggy Delivery System!");
        //Administrator Level
        Scanner in = new Scanner(System.in);
        Set hash = new HashSet<Integer>();
        int n,input;
        System.out.println("For the Swiggy Administrator:");
        System.out.println("Enter the number of pincodes where delivery is possible:");
        n = in.nextInt();
        System.out.println("Enter the 6 digit pin code of the areas where delivery is possible");
        for(int i = 0; i < n;i++){
            int pincode = in.nextInt();
            hash.add(pincode);
        }
        System.out.println("For the Swiggy user:");
        System.out.println("Please enter the 6 digit pincode to check for delivery:");
        input = in.nextInt();
        try{
            if(hash.contains(input))
                System.out.println("Delivery possible!");
            else{
                throw new IllegalPinCode("Oops! We're not in your area yet!");
            }
        }
        catch(IllegalPinCode e){
            System.out.println(e);
        }

    }
}
class IllegalPinCode extends Exception{
    String str;
    IllegalPinCode(String s){
        str = s;
    }
    public String toString(){
        return str;
    }
}
/*
Output 1:
Welcome to Swiggy Delivery System!
For the Swiggy Administrator:
Enter the number of areas where delivery happens
4
Enter the 6 digit pin code of the areas where delivery is possible
560045
542688
547537
560016
For the Swiggy user:
Please enter the 6 digit pincode to check for delivery:
560016
Delivery possible!

Output 2:
Welcome to Swiggy Delivery System!
For the Swiggy Administrator:
Enter the number of pincodes where delivery is possible:
1
Enter the 6 digit pin code of the areas where delivery is possible
560016
For the Swiggy user:
Please enter the 6 digit pincode to check for delivery:
560036
Oops! We're not in your area yet!
 */