package com.jdm.dvdlibrary;

import com.jdm.dvdlibrary.controller.DVDLibraryController;
import com.jdm.dvdlibrary.ui.DVDLibraryView;
import com.jdm.dvdlibrary.ui.UserIO;
import com.jdm.dvdlibrary.ui.UserIOConsoleImpl;
import com.jdm.dvdlibrarydao.DVDLibraryDao;
import com.jdm.dvdlibrarydao.DVDLibraryDaoFileImpl;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public static void main(String[] args){
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(dao, view);
        controller.run();
    }
}
