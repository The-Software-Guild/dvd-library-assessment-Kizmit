package com.jdm.dvdlibrary.controller;

import com.jdm.dvdlibrary.dto.Dvd;
import com.jdm.dvdlibrary.ui.DvdLibraryView;
import com.jdm.dvdlibrarydao.DvdLibraryDaoException;
import java.util.List;
import com.jdm.dvdlibrarydao.DvdLibraryDao;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class DvdLibraryController {
    private final DvdLibraryDao dao;
    private final DvdLibraryView view;
    
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean exit = false;
        int menuSelection;
        
        try{
            dao.loadDvdLibrary();
            
            while(!exit){
                menuSelection = getMenuSelection();

                switch(menuSelection){
                    case 1: 
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editEntry();
                        break;
                    case 4:
                        viewDvdLibrary();
                        break;
                    case 5:
                        getDvdInfo();
                        break;
                    case 6:
                        searchForDvd();
                        break;
                    case 7:
                        exit = true;
                        break; 
                }
            }
        
        dao.saveDvdLibrary();
        }
        catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        view.printMenuBanner();
        return view.printMenuGetSelection();
    }

    private void addDvd(){
        view.printAddDvdBanner();
        Dvd newDvd = view.createDvd();
        dao.addDvd(newDvd);
        view.printAddDvdSuccess();
    }

    private void editEntry(){
        view.printEditDvdBanner();
        String dvdTitle;
        boolean contains = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        if(contains){
            dao.editDvd(dvdTitle, view.getFieldFromUser(), view.getUpdatedFieldDataFromUser());
            view.printEditDvdSuccess();
        }
        else{
            view.printEditDvdFailure();
        }
    }

    private void removeDvd(){
        view.printRemoveDvdBanner();
        String dvdTitle;
        boolean contains = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        if(contains){
            Dvd removedDvd = dao.removeDvd(dvdTitle);
            view.printRemoveSuccess(removedDvd);
        }
        else{
            view.printRemoveFailure();
        }
        
    }

    private void viewDvdLibrary() {
        view.printViewLibraryBanner();
        List<Dvd> dvdList = dao.getDvdList();
        view.printLibraryList(dvdList);
    }

    private void getDvdInfo(){
        String dvdTitle;
        view.printGetDvdInfoBanner();
        boolean contains = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        Dvd dvd = dao.getDvdInfo(dvdTitle);
        if(contains){
            view.printDvdInfo(dvd);
        }
        else{
            view.printDvdInfoFailure();
        }
    }

    private void searchForDvd(){
        boolean found;
        view.printSearchBanner();
        found = dao.searchForDvd(view.getTitleFromUser());
        if(found){
            view.printSearchSucces();
        }
        else{
            view.printSearchFailure();
        }
    }
}
