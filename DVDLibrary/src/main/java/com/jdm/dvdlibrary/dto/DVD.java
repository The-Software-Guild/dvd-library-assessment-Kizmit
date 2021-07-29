package com.jdm.dvdlibrary.dto;



/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class DVD {
    private String title, director, studio, note, mpaaRating, releaseDate;
    
    public DVD(String title, String director, String studio, 
            String note, String mpaaRating, String releaseDate){
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.note = note;
        this.mpaaRating = mpaaRating;
        this.releaseDate = releaseDate;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public String getStudio(){
        return this.studio;
    }
    
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getNote(){
        return this.note;
    }
    
    public void setNote(String note){
        this.note = note;
    }
    
    public String getMpaaRating(){
        return this.mpaaRating;
    }
    
    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public String getReleaseDate(){
        return this.releaseDate;
    }
    
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    

}
