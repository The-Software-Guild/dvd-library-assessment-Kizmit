/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.DVD;
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
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    public static final String DVD_LIBRARY_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvdLibrary = new HashMap<>();
    
    @Override
    public void addDVD(DVD dvd){
        dvdLibrary.put(dvd.getTitle(), dvd);
    }

    @Override
    public void loadDVDMap() throws DVDLibraryDaoException{
        Scanner scanner = null;
        
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY_FILE)));
        }
        catch(FileNotFoundException e){
            throw new DVDLibraryDaoException("Couldn't read DVD information.");
        }
        
        String currentLine;
        DVD dvd;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            dvd = unmarshallDVD(currentLine);
            
            dvdLibrary.put(dvd.getTitle(), dvd);
        }
        
        scanner.close();
    }

    @Override
    public void saveDVDMapToFile() throws DVDLibraryDaoException{
        PrintWriter out = null;
        
        try{
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        }
        catch (IOException e){
            throw new DVDLibraryDaoException("Couldn't save DVD information.");
        }
        
        String dvdText;
        List<DVD> dvdList = this.getDVDList();
        
        for(DVD dvd : dvdList){
            dvdText = marshallDVD(dvd);
            out.println(dvdText);
            out.flush();
        }
        
        out.close();
    }

    @Override
    public DVD removeDVD(String dvdTitle){
        return dvdLibrary.remove(dvdTitle);
    }

    @Override
    public boolean editDVD(String dvdName, int field, String updatedInfo){
        DVD dvd = dvdLibrary.get(dvdName);
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
    public List<DVD> getDVDList() {
        List<DVD> dvdList = new ArrayList<DVD>(dvdLibrary.values());
        return dvdList;
    }

    @Override
    public DVD getDVDInfo(String dvdName){
        return dvdLibrary.get(dvdName);
    }

    @Override
    public boolean searchForDVD(String dvdName) {
        boolean found = dvdLibrary.containsKey(dvdName);
        return found;
    }

    public DVD unmarshallDVD(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        DVD dvdFromFile = new DVD(dvdTokens[0], dvdTokens[1], dvdTokens[2], 
            dvdTokens[3], dvdTokens[4], dvdTokens[5]);
        return dvdFromFile;
    }
    
    /*ORDER OF ELEMENTS FOR TEXTFILE/CONSTRUCTOR:
    title::director::studio::note::mpaaRating::releaseDate
    */
    public String marshallDVD(DVD dvd)
    {
        String dvdText = dvd.getTitle() + DELIMITER + dvd.getDirector() + DELIMITER + dvd.getStudio()
                + DELIMITER + dvd.getNote() + DELIMITER + dvd.getMpaaRating() + DELIMITER + dvd.getReleaseDate();
        
        return dvdText;
    }

}
