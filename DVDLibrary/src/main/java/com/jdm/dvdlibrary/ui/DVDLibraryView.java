/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.dvdlibrary.ui;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class DVDLibraryView {
    private final UserIO io;
    
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuGetSelection(){
        System.out.println("1. Add a DVD");
        System.out.println("2. Remove a DVD");
        System.out.println("3. Edit a DVD");
        System.out.println("4. List DVD collection");
        System.out.println("5. Get information about a DVD");
        System.out.println("6. Search for a DVD");
        System.out.println("7. Exit");
        
        return io.readInt("Please make your menu selection from the above choices: ", 1, 7);
    }
    
    public void printMenuBanner(){
        System.out.println("=======Menu=======");
    }
    
}
