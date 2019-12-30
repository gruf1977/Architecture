package com.example.myarchitecture.data.photo.model;

import com.google.gson.annotations.SerializedName;

public final class ApiResult {

    @SerializedName("photos")
    private ApiPhotoPage photos;
    ApiPhotoPage getPhotos() {
        return photos;
    }
}
