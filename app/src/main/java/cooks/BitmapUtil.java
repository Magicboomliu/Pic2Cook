package cooks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class BitmapUtil {
    public static File myCaptureFile;

    /**
     * 图片压缩总入口
     * 传入原图片的路径,和压缩后的名字
     * @param filePath
     */
    public static File compressImage(String filePath,String fileName){
        Log.d("SSS","压缩之前的大小"+BitmapUtil.formatFileSize(BitmapUtil.getFileSizes(new File(filePath))));
        //将图片转为bitmap
        Bitmap fileBitmap= BitmapFactory.decodeFile(filePath,getBitmapOption(2));
        //将转为bitmap的图片压缩
        Bitmap compressBitmap = compressQuality(fileBitmap);
        //将图片存入本地再转为file
        File file = bitmapToFile(compressBitmap, fileName+".png");
        Log.d("SSS","压缩之后的大小"+BitmapUtil.formatFileSize(BitmapUtil.getFileSizes(file)));
        return file;
    }

    /**
     * 质量压缩方法
     * @param image
     * @return
     */
    public static Bitmap compressQuality(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 300, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 90;
        while (baos.toByteArray().length / 1024 > 300) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            Log.d("SSS","图片循环压缩--->"+baos.toByteArray().length / 1024);
            baos.reset(); // 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    //bitmap转file
    public static File bitmapToFile(Bitmap bm, String fileName) {
        try {
            String path = getSDPath() + "/gridinfo/";
            File dirFile = new File(path);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            myCaptureFile = new File(path + fileName);
            BufferedOutputStream bos;
            bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
            bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myCaptureFile;
    }

    /**
     * 获取sd卡路径
     * @return
     */
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
        }
        return sdDir.toString();
    }

    /**
     * 解决图片太大转bitmap对象会出问题
     * @param inSampleSize
     * @return
     */
    public static BitmapFactory.Options getBitmapOption(int inSampleSize){
        System.gc();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = inSampleSize;
        return options;
    }

    /**
     * 获取文件大小
     * @param f
     * @return
     */
    public static long getFileSizes(File f)
    {
        long s = 0;
        if (f.exists())
        {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(f);
                s = fis.available();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件不存在");
        }
        return s;
    }


    /**
     * 将文件大小转换成字节
     * @param fSize
     * @return
     */
    public static String formatFileSize(long fSize) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fSize < 1024) {
            fileSizeString = df.format((double) fSize) + "B";
        } else if (fSize > 104875) {
            fileSizeString = df.format((double) fSize / 1024) + "K";
        } else if (fSize > 1073741824) {
            fileSizeString = df.format((double) fSize / 104875) + "M";
        } else {
            fileSizeString = df.format((double) fSize / 1073741824) + "G";
        }
        return fileSizeString;

    }

}
