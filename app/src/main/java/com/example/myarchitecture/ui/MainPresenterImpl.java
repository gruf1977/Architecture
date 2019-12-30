package com.example.myarchitecture.ui;

import android.content.Context;
import android.util.Log;
import com.example.myarchitecture.data.photo.PhotoDataSource;
import com.example.myarchitecture.data.photo.PhotoDataSourceImpl;
import com.example.myarchitecture.data.photo.PhotosRepositoryImpl;
import com.example.myarchitecture.data.photo.model.PhotoResultMapper;
import com.example.myarchitecture.domain.Photo;
import com.example.myarchitecture.interactor.MainInteractor;
import com.example.myarchitecture.network.ApiKeyProvider;
import com.example.myarchitecture.network.HostProvider;
import com.example.myarchitecture.network.flickr.FlickrApi;
import com.example.myarchitecture.network.flickr.FlickrApiKeyProvider;
import com.example.myarchitecture.network.flickr.FlickrHostProvider;
import com.example.myarchitecture.repository.PhotosRepository;
import com.example.myarchitecture.resources.ResourceManagerImpl;
import java.util.List;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {

    private final MainInteractor mainInteractor;
    private final View view;
    private final Context context;
    private static final String TAG = "MainImpl";
    private PhotosRepository photosRepository;

    MainPresenterImpl(View view, MainInteractor mainInteractor, Context context) {
        this.view = view;
        this.context = context;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onStart() {
        int numberStart = mainInteractor.getNumberStart();
        view.recyclerViewVisible(false, null);
        view.progressVisible(true);
        view.btnFindIsActive(true);
        testGettingPhotos();
        if (mainInteractor.showDialog(numberStart)){
            view.showRateProposal();
        }
    }

    private void testGettingPhotos() {
        ResourceManagerImpl resourceManager = new ResourceManagerImpl(context);
        ApiKeyProvider apiKeyProvider = new FlickrApiKeyProvider(resourceManager);
        HostProvider hostProvider = new FlickrHostProvider(resourceManager);
        FlickrApi flickrApi = new FlickrApi(hostProvider);
        PhotoResultMapper photoResultMapper = new PhotoResultMapper();
        PhotoDataSource photoDataSource = new PhotoDataSourceImpl(flickrApi.getService(), apiKeyProvider, photoResultMapper);
        photosRepository = new PhotosRepositoryImpl(photoDataSource);
        loadPhotos();
    }

    private void loadPhotos() {
        photosRepository.getRecent(0, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Photo>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Photo> photos) {
                        Log.i(TAG, "Got photos: " + photos.size() + " " + photos);
                        view.progressVisible(false);
                        view.recyclerViewVisible(true, photos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "Error getting photos", e);
                    }
                });
    }

    @Override
    public void onRatePositive() {
        // TODO: process user positive reaction
    }

    @Override
    public void onRateNegative() {
        // TODO: process user negative reaction
    }

    @Override
    public void findImageByText(String text) {
        if (text.equals("")){
            loadPhotos();
        } else {
            loadPhotosByText(text);
        }
    }

    private void loadPhotosByText(String text) {
        photosRepository.getRecentSource(0, 100, text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Photo>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Photo> photos) {
                        Log.i(TAG, "Got photos: " + photos.size() + " " + photos);
                        view.progressVisible(false);
                        view.recyclerViewVisible(true, photos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "Error getting photos", e);
                    }
                });
    }
}
