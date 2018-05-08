package com.iaijian.tina.cameralearning;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by heyukun on 2018/5/8.
 */

public class BitmapUtil {


    public static Bitmap ratio(String filePath, int pixelW, int pixelH) {

        BitmapFactory.Options newOptions = new BitmapFactory.Options();

        //只加载宽高
        newOptions.inJustDecodeBounds = true;
        //位深度
        newOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(filePath, newOptions);

        int originalW = newOptions.outWidth;
        int originalH = newOptions.outHeight;

        //采样(压缩)
        newOptions.inSampleSize = getSimpleSize(originalW, originalH, pixelW, pixelH);

        //解除只加载宽高 使也能加载bm内部内容
        newOptions.inJustDecodeBounds = false;


        return BitmapFactory.decodeFile(filePath, newOptions);

    }

    //计算采样率
    private static int getSimpleSize(int originalW, int originalH, int pixelW, int pixelH) {
        int simpleSize = 1;

        if (originalW > originalH && originalW > pixelW) {
            simpleSize = originalW / pixelH;

        } else if (originalW < originalH && originalH > pixelH) {
            simpleSize = originalH / pixelH;
        }

        if (simpleSize <= 0) {
            simpleSize = 1;
        }

        return simpleSize;
    }
}
