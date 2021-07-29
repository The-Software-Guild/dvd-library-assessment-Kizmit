package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Joe McAdams
 * @email  joedmcadams@gmail.com
 */
public interface DVDLibraryDao {
    
    public void loadDVDMap();
    
    public void saveDVDMapToFile();
    
    public void addDVD(DVD dvd);
    
    public DVD removeDVD(String dvdTitle);
    
    public void editDVD(String dvdName);
    
    public List<DVD> getDVDList();
    
    public void displayDVDInfo(String dvdName);
    
    public void searchForDVD(String dvdName);

}
