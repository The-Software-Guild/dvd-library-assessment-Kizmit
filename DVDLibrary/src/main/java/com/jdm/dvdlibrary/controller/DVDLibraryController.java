package com.jdm.dvdlibrary.controller;

import com.jdm.dvdlibrary.dto.DVD;
import com.jdm.dvdlibrary.ui.DVDLibraryView;
import com.jdm.dvdlibrary.ui.UserIO;
import com.jdm.dvdlibrary.ui.UserIOConsoleImpl;
import com.jdm.dvdlibrarydao.DVDLibraryDao;
import com.jdm.dvdlibrarydao.DVDLibraryDaoException;
import java.util.List;

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
        try{
            dao.loadDVDMap();
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
                        viewLibrary();
                        break;
                    case 5:
                        getDVDInfo();
                        break;
                    case 6:
                        searchForDVD();
                        break;
                    case 7:
                        exit = true;
                        break;    
                }
            }
        
        dao.saveDVDMapToFile();
        }
        catch(DVDLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        view.printMenuBanner();
        return view.printMenuGetSelection();
    }

    private void addDVD(){
        view.printAddDVDBanner();
        DVD newDvd = view.createNewDVD();
        dao.addDVD(newDvd);
        view.printAddDVDSuccessBanner();
    }

    private void editEntry(){
        view.printEditDVDBanner();
        String dvdTitle;
        boolean contains = dao.searchForDVD(dvdTitle = view.getTitleFromUser());
        if(contains){
            dao.editDVD((dvdTitle), view.getFieldFromUser(), view.getUpdatedFieldDataFromUser());
            view.printEditDVDSuccess();
        }
        else{
            view.printEditDVDFailure();
        }
    }

    private void removeDVD(){
        view.printRemoveDVDBanner();
        String dvdTitle = view.getTitleFromUser();
        DVD removedDvd = dao.removeDVD(dvdTitle);
        view.printRemoveSuccess(removedDvd);
    }

    private void viewLibrary() {
        view.printViewLibraryBanner();
        List<DVD> dvdList = dao.getDVDList();
        view.printLibraryList(dvdList);
    }

    private void getDVDInfo(){
        view.printGetDVDInfoBanner();
        DVD dvd = dao.getDVDInfo(view.getTitleFromUser());
        view.printDVDInfo(dvd);
    }

    private void searchForDVD(){
        boolean found = false;
        view.printSearchBanner();
        found = dao.searchForDVD(view.getTitleFromUser());
        view.printSearchSucces(found);
    }
}
