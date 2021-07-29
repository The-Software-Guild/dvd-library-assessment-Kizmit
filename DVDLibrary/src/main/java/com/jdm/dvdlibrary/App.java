package com.jdm.dvdlibrary;

import com.jdm.dvdlibrary.controller.DvdLibraryController;
import com.jdm.dvdlibrary.ui.DvdLibraryView;
import com.jdm.dvdlibrary.ui.UserIO;
import com.jdm.dvdlibrary.ui.UserIOConsoleImpl;
import com.jdm.dvdlibrarydao.DvdLibraryDaoFileImpl;
import com.jdm.dvdlibrarydao.DvdLibraryDao;

/**
 * @author  Joe McAdams
 * @email   joedmcadams@gmail.com
 * @purpose DVD collection program for 2nd MThree Java bootcamp assessment
 */

public class App {
    public static void main(String[] args){
        UserIO io = new UserIOConsoleImpl();
        DvdLibraryView view = new DvdLibraryView(io);
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(dao, view);
        controller.run();
    }
}
