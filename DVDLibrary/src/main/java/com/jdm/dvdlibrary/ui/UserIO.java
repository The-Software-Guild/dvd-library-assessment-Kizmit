package com.jdm.dvdlibrary.ui;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public interface UserIO {
    /**
     * 
     * @param msg 
     */
    void print(String msg);
    
    /**
     * 
     * @param prompt
     * @param min
     * @param max
     * @return 
     */
    int readInt(String prompt, int min, int max);
    
    /**
     * 
     * @param prompt
     * @return 
     */
    String readString(String prompt);
}
