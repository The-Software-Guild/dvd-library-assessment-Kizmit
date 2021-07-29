package com.jdm.dvdlibrarydao;

/**
 *
 * @author Joe McAdams
 * @email  joedmcadams@gmail.com
 */
public interface DVDLibraryDao {
    
    public void populateDVDMap();
    
    public void saveDVDMapToFile();
    
    public void addDVD();
    
    public void removeDVD();
    
    public void editDVD(String dvdName);
    
    public void listDVDMap();
    
    public void displayDVDInfo(String dvdName);
    
    public void searchForDVD(String dvdName);

}
