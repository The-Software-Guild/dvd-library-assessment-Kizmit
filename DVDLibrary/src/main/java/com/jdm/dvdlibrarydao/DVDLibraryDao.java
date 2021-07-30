package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 * @author Joe McAdams
 * @email  joedmcadams@gmail.com
 */

public interface DvdLibraryDao {
    /**
     * Loads all lines of Dvd data from an input textfile into the dvdLibrary hashmap using
     * the title of the DVD as the key. Throws an IOException wrapped as a DvdLibraryDaoException
     * if file reading cannot take place.
     * @throws DvdLibraryDaoException 
     */
    public void loadDvdLibrary() throws DvdLibraryDaoException;
    
    /**
     * Saves all delimited DVD entry lines into a text file on program close.Throws an IOException 
     * wrapped as a DvdLibraryDaoException if file writing cannot take place.
     * @throws DvdLibraryDaoException 
     */
    public void saveDvdLibrary() throws DvdLibraryDaoException;
    
    /**
     * Constructs a Dvd object and adds the object to the dvdLibrary hashmap
     * using dvd object title as key.
     * @param dvd 
     */
    public void addDvd(Dvd dvd);
    
    /**
     * Removes a Dvd object specified by the key passed through the paramater
     * from the dvdLibrary hashmap and returns the object to the caller.
     * @param dvdName
     * @return Dvd
     */
    public Dvd removeDvd(String dvdName);
    
    /**
     * Edits a Dvd object field specified by paramater dvdName and field with
     * data specified by updatedInfo paramater.
     * @param dvdName
     * @param field
     * @param updatedInfo
     * @return boolean
     */
    public boolean editDvd(String dvdName, int field, String updatedInfo);
    
    /**
     * Returns a list of all Dvd objects contained in the dvdLibrary hashmap.
     * @return 
     */
    public List<Dvd> getDvdList();
    
    /**
     * Returns a Dvd object specified by the parameter dvdName.
     * @param dvdName
     * @return Dvd
     */
    public Dvd getDvdInfo(String dvdName);
    
    /**
     * Queries dvdLibrary hashmap with key parameter dvdName and returns a
     * Dvd object if one exists, otherwise it returns a null object.
     * @param dvdName
     * @return boolean
     */
    public Dvd searchForDvd(String dvdName);
}
