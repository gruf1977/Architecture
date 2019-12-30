package com.example.myarchitecture.data.photo.model;

import com.example.myarchitecture.domain.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoResultMapper {
    public List<Photo> map(ApiResult apiResult) {
        ApiPhotoPage photoPage = apiResult.getPhotos();

        ArrayList<Photo> photos = new ArrayList<>(photoPage.getPhotos().size());
        for (ApiPhoto apiPhoto : photoPage.getPhotos()) {
            photos.add(new Photo(apiPhoto.getUrl()));
        }

        return photos;
    }
}
