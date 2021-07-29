/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class UserIOConsoleImpl implements UserIO {
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        
        String returnString;
        Scanner scanner = new Scanner(System.in);
        returnString = scanner.nextLine();
        
        return returnString;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        
        int returnInt;
        Scanner scanner = new Scanner(System.in);
        returnInt = scanner.nextInt();
        
        return returnInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        
        int returnInt;
        while(true){
            Scanner scanner = new Scanner(System.in);
            returnInt = scanner.nextInt();
            if(returnInt >= min & returnInt <= max){
                break;
            }
            else{
                System.out.println("Not in the range. Re-enter a value between the min and max value:");
            }
        }
        
        
        return returnInt;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        
        double returnDouble;
        Scanner scanner = new Scanner(System.in);
        returnDouble = scanner.nextDouble();
        
        
        return returnDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        
        double returnDouble;
        while(true){
            Scanner scanner = new Scanner(System.in);
            returnDouble = scanner.nextDouble();
            if(returnDouble >= min & returnDouble <= max){
                break;
            }
            else{
                System.out.println("Not in the range. Re-enter a value between the min and max value:");
            }
        }
        
        return returnDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        
        float returnFloat;
        Scanner scanner = new Scanner(System.in);
        returnFloat = scanner.nextFloat();

        return returnFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        
        float returnFloat;
        while(true){
            Scanner scanner = new Scanner(System.in);
            returnFloat = scanner.nextFloat();
            if(returnFloat >= min & returnFloat <= max){
                break;
            }
            else{
                System.out.println("Not in the range. Re-enter a value between the min and max value:");
            }
        }
        
        return returnFloat;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        
        long returnLong;
        Scanner scanner = new Scanner(System.in);
        returnLong = scanner.nextLong();
        
        return returnLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        
        long returnLong;
        while(true){
            Scanner scanner = new Scanner(System.in);
            returnLong = scanner.nextLong();
            if(returnLong > min & returnLong < max){
                break;
            }
            else{
                System.out.println("Not in the range. Re-enter a value between the min and max value:");
            }
        }
        
        return returnLong;
    }
    
}
