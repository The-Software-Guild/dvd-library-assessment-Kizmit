package com.jdm.dvdlibrary.controller;

import com.jdm.dvdlibrary.ui.DVDLibraryView;
import com.jdm.dvdlibrary.ui.UserIO;
import com.jdm.dvdlibrary.ui.UserIOConsoleImpl;
import com.jdm.dvdlibrarydao.DVDLibraryDao;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class DVDLibraryController {
    private DVDLibraryDao dao;
    private DVDLibraryView view;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean exit = false;
        int menuSelection;
        
        //Populate program with DVDs from file
        
        while(!exit){
            menuSelection = getMenuSelection();
            
            switch(menuSelection){
                case 1: 
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editEntry();
                    break;
                case 4:
                    //display list of dvds
                    break;
                case 5:
                    //Get info on a DVD
                    break;
                case 6:
                    //Search for a DVD
                    break;
                case 7:
                    //quit       
            }
        }
    }

    private int getMenuSelection() {
        view.printMenuBanner();
        return view.printMenuGetSelection();
    }

    private void addDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
