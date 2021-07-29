package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 * @author Joe McAdams
 * @email  joedmcadams@gmail.com
 */

public interface DvdLibraryDao {
    /**
     * 
     * @throws DvdLibraryDaoException 
     */
    public void loadDvdMap() throws DvdLibraryDaoException;
    
    /**
     * 
     * @throws DvdLibraryDaoException 
     */
    public void saveDvdMapToFile() throws DvdLibraryDaoException;
    
    /**
     * 
     * @param dvd 
     */
    public void addDvd(Dvd dvd);
    
    /**
     * 
     * @param dvdName
     * @return 
     */
    public Dvd removeDvd(String dvdName);
    
    /**
     * 
     * @param dvdName
     * @param field
     * @param updatedInfo
     * @return 
     */
    public boolean editDvd(String dvdName, int field, String updatedInfo);
    
    /**
     * 
     * @return 
     */
    public List<Dvd> getDvdList();
    
    /**
     * 
     * @param dvdName
     * @return 
     */
    public Dvd getDvdInfo(String dvdName);
    
    /**
     * 
     * @param dvdName
     * @return 
     */
    public boolean searchForDvd(String dvdName);
}
