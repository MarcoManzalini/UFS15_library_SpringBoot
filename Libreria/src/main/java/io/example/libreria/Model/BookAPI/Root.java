package io.example.libreria.Model.BookAPI;

import java.io.Serializable;
import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class AccessInfo{
    public String country;
    public String viewability;
    public boolean embeddable;
    public boolean publicDomain;
    public String textToSpeechPermission;
    public Epub epub;
    public Pdf pdf;
    public String webReaderLink;
    public String accessViewStatus;
    public boolean quoteSharingAllowed;
}

 class Epub{
    public boolean isAvailable;
    public String acsTokenLink;
}

 class ImageLinks{
    public String smallThumbnail;
    public String thumbnail;
}

 class IndustryIdentifier{
    public String type;
    public String identifier;
}

class Offer{
    public int finskyOfferType;
    public ListPrice listPrice;
    public RetailPrice retailPrice;
}

 class PanelizationSummary{
    public boolean containsEpubBubbles;
    public boolean containsImageBubbles;
}

 class Pdf{
    public boolean isAvailable;
    public String acsTokenLink;
}

 class ReadingModes{
    public boolean text;
    public boolean image;
}

 class RetailPrice{
    public double amount;
    public String currencyCode;
    public int amountInMicros;
}


class SearchInfo{
    public String textSnippet;
}

public class Root implements Serializable {
    public String kind;
    public int totalItems;
    public ArrayList<Item> items;

    @Override
    public String toString() {
        return "Root{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }
}


