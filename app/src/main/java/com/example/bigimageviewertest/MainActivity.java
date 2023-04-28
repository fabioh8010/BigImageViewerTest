package com.example.bigimageviewertest;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.ImageLoader;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BigImageViewer.initialize(GlideImageLoader.with(getApplicationContext()));

        setContentView(R.layout.activity_main);

        BigImageView bigImageView = (BigImageView) findViewById(R.id.mBigImage);

        ImageLoader.Callback myImageLoaderCallback = new ImageLoader.Callback() {
            @Override
            public void onCacheHit(int imageType, File image) {
                // Image was found in the cache
            }

            @Override
            public void onCacheMiss(int imageType, File image) {
                // Image was downloaded from the network
            }

            @Override
            public void onStart() {
                // Image download has started
            }

            @Override
            public void onProgress(int progress) {
                // Image download progress has changed
            }

            @Override
            public void onFinish() {
                // Image download has finished
            }

            @Override
            public void onSuccess(File image) {
                bigImageView.getSSIV().setMinScale(1);
                bigImageView.getSSIV().setMaxScale(10);
            }

            @Override
            public void onFail(Exception error) {
                // Image download failed
            }
        };

        bigImageView.setImageLoaderCallback(myImageLoaderCallback);

        bigImageView.showImage(Uri.parse("file:///android_asset/tall_image.jpeg"));
    }
}