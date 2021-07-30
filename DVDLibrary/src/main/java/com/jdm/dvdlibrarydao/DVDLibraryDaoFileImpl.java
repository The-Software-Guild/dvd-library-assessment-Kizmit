package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    public static final String DVD_LIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
    private final Map<String, Dvd> dvdLibrary = new HashMap<>();
    
    @Override
    public void addDvd(Dvd dvd){
        dvdLibrary.put(dvd.getTitle(), dvd);
    }

    @Override
    public void loadDvdLibrary() throws DvdLibraryDaoException{
        Scanner scanner = null;
        
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY_FILE)));
        }
        catch(FileNotFoundException e){
            throw new DvdLibraryDaoException("Couldn't read DVD information.");
        }
        
        String currentLine;
        Dvd dvd;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            dvd = unmarshallDvd(currentLine);
            
            dvdLibrary.put(dvd.getTitle(), dvd);
        }
        
        scanner.close();
    }

    @Override
    public void saveDvdLibrary() throws DvdLibraryDaoException{
        PrintWriter out = null;
        
        try{
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        }
        catch (IOException e){
            throw new DvdLibraryDaoException("Couldn't save DVD information.");
        }
        
        String dvdText;
        List<Dvd> dvdList = this.getDvdList();
        
        for(Dvd dvd : dvdList){
            dvdText = marshallDvd(dvd);
            out.println(dvdText);
            out.flush();
        }
        
        out.close();
    }

    @Override
    public Dvd removeDvd(String dvdTitle){
        return dvdLibrary.remove(dvdTitle);
    }

    @Override
    public boolean editDvd(String dvdTitle, int field, String updatedInfo){
        Dvd dvd = dvdLibrary.get(dvdTitle);
        
        switch (field){
            case 1:
                dvd.setTitle(updatedInfo);
                break;
            case 2:
                dvd.setDirector(updatedInfo);
                break;
            case 3:
                dvd.setStudio(updatedInfo);
                break;
            case 4:
                dvd.setNote(updatedInfo);
                break;
            case 5:
                dvd.setMpaaRating(updatedInfo);
                break;
            case 6:
                dvd.setReleaseDate(updatedInfo);
                break;
            default:
                break;
        }
        
        return true;
    }

    @Override
    public List<Dvd> getDvdList() {
        List<Dvd> dvdList = new ArrayList<>(dvdLibrary.values());
        return dvdList;
    }

    @Override
    public Dvd getDvdInfo(String dvdTitle){
        return dvdLibrary.get(dvdTitle);
    }

    @Override
    public Dvd searchForDvd(String dvdTitle) {
         return dvdLibrary.get(dvdTitle);
    }
    
    /*ORDER OF ELEMENTS FOR TEXTFILE:
    * title::director::studio::note::mpaaRating::releaseDate
    */
    public Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        Dvd dvdFromFile = new Dvd(dvdTokens[0], dvdTokens[1], dvdTokens[2], 
            dvdTokens[3], dvdTokens[4], dvdTokens[5]);
        return dvdFromFile;
    }
    /*ORDER OF ELEMENTS FOR TEXTFILE:
    * title::director::studio::note::mpaaRating::releaseDate
    */
    public String marshallDvd(Dvd dvd)
    {
        String dvdText = dvd.getTitle() + DELIMITER + dvd.getDirector() + DELIMITER + dvd.getStudio()
                + DELIMITER + dvd.getNote() + DELIMITER + dvd.getMpaaRating() + DELIMITER + dvd.getReleaseDate();
        
        return dvdText;
    }

}
