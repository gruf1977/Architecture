package com.example.myarchitecture.data.photo;

import com.example.myarchitecture.domain.Photo;
import com.example.myarchitecture.repository.PhotosRepository;
import java.util.List;
import io.reactivex.Single;

public class PhotosRepositoryImpl implements PhotosRepository {

    private final PhotoDataSource photoDataSource;

    public PhotosRepositoryImpl(PhotoDataSource photoDataSource) {
        this.photoDataSource = photoDataSource;
    }

    @Override
    public Single<List<Photo>> getRecent(int pageNumber, int pageSize) {
        return photoDataSource.getRecent(pageNumber, pageSize);
    }

    @Override
    public Single<List<Photo>> getRecentSource(int pageNumber, int pageSize, String text) {
        return photoDataSource.getRecentByText(pageNumber, pageSize, text);
    }
}
