package com.example.myarchitecture.repository;

import com.example.myarchitecture.domain.Photo;
import java.util.List;
import io.reactivex.Single;

public interface PhotosRepository {
    Single<List<Photo>> getRecent(int pageNumber, int pageSize);
    Single<List<Photo>> getRecentSource(int pageNumber, int pageSize, String text);
}
