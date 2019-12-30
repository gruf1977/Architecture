package com.example.myarchitecture.data.photo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPhotoPage {

    @SerializedName("page")
    private int page;

    @SerializedName("pages")
    private int pages;

    @SerializedName("perpage")
    private int perPage;

    @SerializedName("total")
    private int total;

    @SerializedName("photo")
    private List<ApiPhoto> photos;

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    List<ApiPhoto> getPhotos() {
        return photos;
    }
}
