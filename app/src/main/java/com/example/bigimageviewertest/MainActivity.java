package com.example.bigimageviewertest;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.github.piasy.biv.view.BigImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BigImageViewer.initialize(GlideImageLoader.with(getApplicationContext()));

        setContentView(R.layout.activity_main);

        BigImageView bigImageView = (BigImageView) findViewById(R.id.mBigImage);
        bigImageView.showImage(Uri.parse("file:///android_asset/tall_image.jpeg"));
    }
}