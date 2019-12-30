package com.example.myarchitecture.data.photo;


import com.example.myarchitecture.domain.Photo;
import java.util.List;
import io.reactivex.Single;

public interface PhotoDataSource {
    Single<List<Photo>> getRecent(int pageNumber, int perPage);
    Single<List<Photo>> getRecentByText(int pageNumber, int perPage, String text);
}
