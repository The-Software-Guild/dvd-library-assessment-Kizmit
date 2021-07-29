package com.jdm.dvdlibrarydao;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com 
 */

public class DvdLibraryDaoException extends Exception{
    public DvdLibraryDaoException(String message){
        super(message);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause){
        super(message, cause);
    }
}
