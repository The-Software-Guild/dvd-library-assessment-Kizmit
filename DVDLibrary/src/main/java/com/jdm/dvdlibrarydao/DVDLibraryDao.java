package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.DVD;
import java.util.List;

/**
 * @author Joe McAdams
 * @email  joedmcadams@gmail.com
 */

public interface DVDLibraryDao {
    
    public void loadDVDMap() throws DVDLibraryDaoException;
    
    public void saveDVDMapToFile() throws DVDLibraryDaoException;
    
    public void addDVD(DVD dvd);
    
    public DVD removeDVD(String dvdTitle);
    
    public boolean editDVD(String dvdName, int field, String updatedInfo);
    
    public List<DVD> getDVDList();
    
    public DVD getDVDInfo(String dvdName);
    
    public boolean searchForDVD(String dvdName);
}
