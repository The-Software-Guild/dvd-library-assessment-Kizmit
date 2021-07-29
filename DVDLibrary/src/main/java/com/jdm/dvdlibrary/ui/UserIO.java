package com.jdm.dvdlibrary.ui;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public interface UserIO {
    void print(String msg);
    
    int readInt(String prompt, int min, int max);
    
    String readString(String prompt);
}
