package com.iaijian.tina.cameralearning;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by heyukun on 2018/5/8.
 */

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final String path = getIntent().getStringExtra("picPath");
        final ImageView imageView = findViewById(R.id.pic);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapUtil.ratio(path, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                Matrix matrix = new Matrix();
                matrix.setRotate(90);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                imageView.setImageBitmap(bitmap);
            }
        });


    }
}
