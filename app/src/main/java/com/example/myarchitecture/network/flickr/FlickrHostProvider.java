package com.example.myarchitecture.network.flickr;


import com.example.myarchitecture.R;
import com.example.myarchitecture.network.HostProvider;
import com.example.myarchitecture.resources.ResourceManager;

public class FlickrHostProvider implements HostProvider {
    private final ResourceManager resourceManager;

    public FlickrHostProvider(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public String getHostUrl() {
        return resourceManager.getString(R.string.flick_host);
    }
}
