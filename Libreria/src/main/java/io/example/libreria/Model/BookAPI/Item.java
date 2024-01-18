package io.example.libreria.Model.BookAPI;

import io.example.libreria.Model.BookAPI.AccessInfo;
import io.example.libreria.Model.BookAPI.SaleInfo;
import io.example.libreria.Model.BookAPI.SearchInfo;
import io.example.libreria.Model.BookAPI.VolumeInfo;

public class Item{
    public String kind;
    public String id;
    public String etag;
    public String selfLink;
    public VolumeInfo volumeInfo;
    public SaleInfo saleInfo;
    public AccessInfo accessInfo;
    public SearchInfo searchInfo;

    @Override
    public String toString() {
        return "Item{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selfLink='" + selfLink + '\'' +
                ", volumeInfo=" + volumeInfo +
                ", saleInfo=" + saleInfo +
                ", accessInfo=" + accessInfo +
                ", searchInfo=" + searchInfo +
                '}';
    }
}
