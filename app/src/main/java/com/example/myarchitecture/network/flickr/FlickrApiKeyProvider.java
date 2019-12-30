package com.example.myarchitecture.network.flickr;

import com.example.myarchitecture.R;
import com.example.myarchitecture.network.ApiKeyProvider;
import com.example.myarchitecture.resources.ResourceManager;

public class FlickrApiKeyProvider implements ApiKeyProvider {
    private final ResourceManager resourceManager;

    public FlickrApiKeyProvider(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public String getApiKey() {
        return resourceManager.getString(R.string.flick_api_key);
    }
}
