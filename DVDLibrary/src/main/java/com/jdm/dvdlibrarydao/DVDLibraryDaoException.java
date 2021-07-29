package com.jdm.dvdlibrarydao;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com 
 */

public class DVDLibraryDaoException extends Exception{
    public DVDLibraryDaoException(String message){
        super(message);
    }
    
    public DVDLibraryDaoException(String message, Throwable cause){
        super(message, cause);
    }
}
