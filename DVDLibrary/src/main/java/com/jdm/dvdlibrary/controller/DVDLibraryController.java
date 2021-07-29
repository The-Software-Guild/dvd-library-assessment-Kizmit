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
    private DvdLibraryDao dao;
    private DvdLibraryView view;
    
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean exit = false;
        int menuSelection;
        try{
            dao.loadDvdMap();
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
        
        dao.saveDvdMapToFile();
        }
        catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        view.printMenuBanner();
        return view.printMenuGetSelection();
    }

    private void addDVD(){
        view.printAddDVDBanner();
        Dvd newDvd = view.createNewDVD();
        dao.addDvd(newDvd);
        view.printAddDVDSuccess();
    }

    private void editEntry(){
        view.printEditDVDBanner();
        String dvdTitle;
        boolean contains = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        if(contains){
            dao.editDvd((dvdTitle), view.getFieldFromUser(), view.getUpdatedFieldDataFromUser());
            view.printEditDVDSuccess();
        }
        else{
            view.printEditDVDFailure();
        }
    }

    private void removeDVD(){
        view.printRemoveDVDBanner();
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

    private void viewLibrary() {
        view.printViewLibraryBanner();
        List<Dvd> dvdList = dao.getDvdList();
        view.printLibraryList(dvdList);
    }

    private void getDVDInfo(){
        String dvdTitle;
        boolean contains = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        Dvd dvd = dao.getDvdInfo(dvdTitle);
        if(contains){
            view.printGetDVDInfoBanner();
            view.printDVDInfo(dvd);
        }
        else{
            view.printDVDInfoFailure();
        }
    }

    private void searchForDVD(){
        boolean found = false;
        found = dao.searchForDvd(view.getTitleFromUser());
        view.printSearchBanner();
        if(found){
            view.printSearchSucces();
        }
        else{
            view.printSearchFailure();
        }
    }
}
