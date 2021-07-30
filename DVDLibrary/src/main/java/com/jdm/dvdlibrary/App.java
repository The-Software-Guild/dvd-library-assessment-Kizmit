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
        UserIO io = new UserIOConsoleImpl();                                    //Input/output object
        DvdLibraryView view = new DvdLibraryView(io);                           //View injected with input/output object
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();                        //Data access object
        DvdLibraryController controller = new DvdLibraryController(dao, view);  //Controller object injected with dao and view
        controller.run();                                                       //Run main program logic
    }
}
