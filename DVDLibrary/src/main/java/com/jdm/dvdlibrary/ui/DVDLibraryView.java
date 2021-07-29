package com.jdm.dvdlibrary.ui;

import com.jdm.dvdlibrary.dto.Dvd;
import java.util.InputMismatchException;

import java.util.List;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class DvdLibraryView {
    private final UserIO io;
    
    public DvdLibraryView(UserIO io){
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
        System.out.println("=============MENU=============");
    }

    public void printAddDVDBanner() {
        System.out.println("=======ENTER DVD DETAILS=======");
    }
    public void printAddDVDSuccess() {
        System.out.println("The DVD was successfully added to the collection.");
    }
    
    public void printViewLibraryBanner() {
        System.out.println("==========DVD LIBRARY==========");
    }
    
    public void printRemoveDVDBanner() {
        System.out.println("==========DVD REMOVAL==========");
    }
    public void printRemoveSuccess(Dvd removedDvd){
        System.out.println("DVD \"" + removedDvd.getTitle() + "\" removed.");
    }
    public void printRemoveFailure() {
        System.out.println("Failed to remove entry; it doesn't exist in the collection.");
    }
    
    public void printEditDVDBanner() {
        System.out.println("==========DVD EDITOR==========");
    }
    public void printEditDVDSuccess() {
        System.out.println("DVD field updated successfully.");
    }
    public void printEditDVDFailure() {
        System.out.println("Edit failed: The DVD you wish to update doesn't exist.");
    }
    
    public void printSearchBanner(){
        System.out.println("==========SEARCHING==========");
    }
    public void printSearchSucces() {
        System.out.println("The DVD was found in the collection.");
    }
    public void printSearchFailure() {
        System.out.println("No DVD with that name exists in the collection.");
    }
    
    public void printGetDVDInfoBanner() {
        System.out.println("=====GETTING DVD INFORMATION=====");
    }
    public void printDVDInfo(Dvd dvd){
        io.print("Title: " + dvd.getTitle());
        io.print("Director: " + dvd.getDirector());
        io.print("Studio: " + dvd.getStudio());
        io.print("Note: " + dvd.getNote());
        io.print("MPAA Rating: " + dvd.getMpaaRating());
        io.print("Release Date: " + dvd.getReleaseDate());
    }
    public void printDVDInfoFailure() {
        System.out.println("Failed to get information on DVD; it doesn't exist in the collection.");
    }
 
    public Dvd createNewDVD(){
        Dvd dvd = new Dvd(io.readString("Title:"), io.readString("Director:"), io.readString("Studio:")
                          , io.readString("Note:"), io.readString("MPAA Rating:"), io.readString("Release Date:"));
        return dvd;
    }

    public void printLibraryList(List<Dvd> dvdList) {
        System.out.printf("%-35s%-25s%-25s%-50s%-25s%-25s\n", "Title", "Director", "Studio", "Note", "MPAA Rating", "Release Date");
        for(Dvd dvd : dvdList){
            System.out.printf("%-35s%-25s%-25s%-50s%-25s%-25s\n", dvd.getTitle(), dvd.getDirector(), dvd.getStudio()
                              , dvd.getNote(), dvd.getMpaaRating(), dvd.getReleaseDate());
        }
    }

    public String getTitleFromUser() {
        String title = io.readString("Enter the title of the DVD: ");
        return title;
    }
    
    public int getFieldFromUser(){
        System.out.println("Which field would you like to update: ");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Studio");
        System.out.println("4. Note");
        System.out.println("5. MPAA Rating");
        System.out.println("6. Release Date");
        int field = io.readInt("Enter the value of the menu choices above: ", 1, 6);
        return field;
    }

    public String getUpdatedFieldDataFromUser() {
        String newField = io.readString("Enter the new field information to update using: "); //To change body of generated methods, choose Tools | Templates.
        return newField;
    }

    public void displayErrorMessage(String message) {
        System.out.println(message);
    }
}
