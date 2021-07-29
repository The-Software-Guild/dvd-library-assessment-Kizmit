/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.dvdlibrary.ui;

import com.jdm.dvdlibrary.dto.DVD;
import java.util.List;

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

    public void printAddDVDBanner() {
        System.out.println("=======ENTER DVD DETAILS=======");
    }
    
    public void printAddDVDSuccessBanner() {
        System.out.println("=======DVD ADDED=======");
    }
    
    public void printViewLibraryBanner() {
        System.out.println("=======DVD LIBRARY=======");
    }
    
    public void printRemoveDVDBanner() {
        System.out.println("=======DVD REMOVAL=======");
    }

    public void printRemoveSuccess(DVD removedDvd) {
        System.out.println("DVD \"" + removedDvd.getTitle() + "\" removed");
    }
     /*ORDER OF ELEMENTS FOR TEXTFILE/CONSTRUCTOR:
    title::director::studio::note::mpaaRating::releaseDate
    */
    public DVD createNewDVD(){
        DVD dvd = new DVD(io.readString("Title:"), io.readString("Director:"), io.readString("Studio:")
                          , io.readString("Note:"), io.readString("MPAA Rating:"), io.readString("Release Date:"));
        return dvd;
    }


    public void printLibraryList(List<DVD> dvdList) {
        System.out.printf("%-35s%-25s%-25s%-25s%-25s%-25s\n", "Title", "Director", "Studio", "Note", "MPAA Rating", "Release Date");
        for(DVD dvd : dvdList){
            System.out.printf("%-35s%-25s%-25s%-25s%-25s%-25s\n", dvd.getTitle(), dvd.getDirector(), dvd.getStudio()
                              ,dvd.getNote(), dvd.getMpaaRating(), dvd.getReleaseDate());
        }
    }

    public String getTitleFromUser() {
        String title = io.readString("Enter the title of the DVD you want to remove: ");
        return title;
    }
}
