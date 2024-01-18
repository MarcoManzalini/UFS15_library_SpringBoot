package io.example.libreria.Model.BookAPI;

import io.example.libreria.Model.BookAPI.ImageLinks;
import io.example.libreria.Model.BookAPI.IndustryIdentifier;
import io.example.libreria.Model.BookAPI.PanelizationSummary;
import io.example.libreria.Model.BookAPI.ReadingModes;

import java.util.ArrayList;
import java.util.Date;

public class VolumeInfo{
    public String title;
    public ArrayList<String> authors;
    public Date publishedDate;
    public ArrayList<IndustryIdentifier> industryIdentifiers;
    public ReadingModes readingModes;
    public int pageCount;
    public String printType;
    public ArrayList<String> categories;
    public String maturityRating;
    public boolean allowAnonLogging;
    public String contentVersion;
    public PanelizationSummary panelizationSummary;
    public ImageLinks imageLinks;
    public String language;
    public String previewLink;
    public String infoLink;
    public String canonicalVolumeLink;
    public String publisher;
    public String description;
    public int averageRating;
    public int ratingsCount;
    public String subtitle;

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

    @Override
    public String toString() {
        return "VolumeInfo{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", publishedDate=" + publishedDate +
                ", industryIdentifiers=" + industryIdentifiers +
                ", readingModes=" + readingModes +
                ", pageCount=" + pageCount +
                ", printType='" + printType + '\'' +
                ", categories=" + categories +
                ", maturityRating='" + maturityRating + '\'' +
                ", allowAnonLogging=" + allowAnonLogging +
                ", contentVersion='" + contentVersion + '\'' +
                ", panelizationSummary=" + panelizationSummary +
                ", imageLinks=" + imageLinks +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", infoLink='" + infoLink + '\'' +
                ", canonicalVolumeLink='" + canonicalVolumeLink + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", averageRating=" + averageRating +
                ", ratingsCount=" + ratingsCount +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
