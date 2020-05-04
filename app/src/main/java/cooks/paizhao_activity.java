package cooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;
//导入Baidu的识别API库
import com.baidu.aip.imageclassify.*;
import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import my.whole_container_my;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class paizhao_activity extends AppCompatActivity {
    private  Button Compressed_the_image;
    public  String compressed_image_path;
    private ImageView yuyinshuru;
    private EditText buchong_neirong;
    private  ImageView toRecommend;
    public  static  final int UPDATE_TEXT_OF_SHIBIE =1;
    private Bitmap taked_photo;
    private Button kashishibie;
    private Button take_photo;
    private EditText editText;
    private ImageView pics;
    private Uri imageUri;
    private  AipImageClassifyBeta aipImageClassifyBeta;
    private String shibie_contents="";
    Bitmap bitmap;
    private JSONArray jsonArray;
    private String TAG = "Result";
    public static final String APP_ID = "19241100";
    public static final String API_KEY = "rpfV2770fSCzPFDYA5mDmphP";
    public static final String SECRET_KEY = "Pe7Hn0v0IKqb5VsOrSphIYLIe3wSqK6k";
    public  String finalresult;
    List<String> reco_outcome = new ArrayList<String>();
    List<String> reco_scores = new ArrayList<String>();
//    private String path = getExternalCacheDir()+"/output_image.jpg";
//    private String path= getExternalCacheDir().getPath()+"/output_image.jpg";
    private String paths ="/sdcard/Android/data/com.example.pic2cook_develop/cache/1587182450383844.jpeg";

    public static final int TAKE_PHOTO=1;
    public static  final int Show_shibiejieguo =2;

    private  ProgressDialog pg1;
    private  String buchong_words="";
    private Button generated_dishes;

    //新建消息处理机制
    private Handler handler = new Handler(){

        public void handleMessage(Message msg)
        {
        switch (msg.what){
            //更新识别内容的EditText
            case UPDATE_TEXT_OF_SHIBIE:
                editText.setText(shibie_contents);
                pg1.dismiss();

                break;
            case Show_shibiejieguo:
                buchong_neirong.setText(buchong_words);
                finalresult = shibie_contents +","+ buchong_words;
            default:
                break;

        }


        }

    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paizhao_activity);
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5e96f9b3");
        Log.d(TAG,"载入没有什么问题");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题


        generated_dishes =findViewById(R.id.generated_dishes);

       final String datas ="From";

        generated_dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(paizhao_activity.this, MainActivity.class);
                it.putExtra("extra_data",finalresult);
                startActivity(it);

            }
        });










        // 这一部分为语音识别的部分
        yuyinshuru = findViewById(R.id.sppec);
        yuyinshuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              initSpeech(paizhao_activity.this);


            }
        });

        buchong_neirong = findViewById(R.id.complement_dishes);


        //这一部分为拍照的部分
//        take_photo = findViewById(R.id.opencamera);
        editText =findViewById(R.id.shibie_outcome);
        pics =findViewById(R.id.show_the_image);
        kashishibie = findViewById(R.id.shibie_outcom_lanuch);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //创建File对象，用于存储拍照后的照片
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                try{
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT>=24){
                    imageUri= FileProvider.getUriForFile(paizhao_activity.this,"cooks.paizhao_activity.fileprovider",outputImage);
                }else {
                    imageUri= Uri.fromFile(outputImage);
                }
                ActivityCompat.requestPermissions(paizhao_activity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


                //启动相机程序
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                //以下两行代码适配Android 7.0 解决了无法加载图片的问题
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                startActivityForResult(intent,TAKE_PHOTO);

            }
        }).start();

//        take_photo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //创建File对象，用于存储拍照后的照片
//                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
//                try{
//                    if (outputImage.exists()){
//                        outputImage.delete();
//                    }
//                    outputImage.createNewFile();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//                if (Build.VERSION.SDK_INT>=24){
//                    imageUri= FileProvider.getUriForFile(paizhao_activity.this,"cooks.paizhao_activity.fileprovider",outputImage);
//                }else {
//                    imageUri= Uri.fromFile(outputImage);
//                }
//                ActivityCompat.requestPermissions(paizhao_activity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//
//
//                //启动相机程序
//                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
//                //以下两行代码适配Android 7.0 解决了无法加载图片的问题
//                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//                startActivityForResult(intent,TAKE_PHOTO);
//
//
//            }
//        });

        //这一部分是图片识别的部分
        kashishibie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg1 = new ProgressDialog(paizhao_activity.this);
                pg1.setTitle("Pic2Cook正在识别拍到的图片");
                pg1.setMessage("Image Processing.....");
                pg1.setCancelable(true);
                pg1.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {



//                        try {
//                            if(Imagepath!=null) {
////在这里提取缓冲流赋值为bitmap
//                                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(Imagepath)));
//
//                            }
//                        }catch(FileNotFoundException e){
//                            e.printStackTrace();
//                        }

                       Bitmap bitmap=BitmapFactory.decodeFile(compressed_image_path);

//                       bitmap =BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kobe);
//                        bitmap = taked_photo;
                        byte[] content = getBitmapByte(bitmap);
//
//                        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                                + getResources().getResourcePackageName(R.drawable.plant) + "/"
//                                + getResources().getResourceTypeName(R.drawable.veg) + "/"
//                                + getResources().getResourceEntryName(R.drawable.veg));
//                        Log.d(TAG,imageUri.toString());


                        aipImageClassifyBeta= new AipImageClassifyBeta(APP_ID,API_KEY,SECRET_KEY);
                        aipImageClassifyBeta.setConnectionTimeoutInMillis(2000);
                        aipImageClassifyBeta.setSocketTimeoutInMillis(6000);

//                        aipImageClassify =new AipImageClassify(APP_ID,API_KEY,SECRET_KEY);
//                        aipImageClassify.setConnectionTimeoutInMillis(2000);
//                        aipImageClassify.setSocketTimeoutInMillis(6000);

                        HashMap<String, String> options = new HashMap<String, String>();
                        options.put("top_num", "1");

//                        options.put("baike_num", "5");

                        JSONObject res = aipImageClassifyBeta.ingredientDetect(content,options);
                        Log.d(TAG,"Start Recos");

                        try {

                            jsonArray= res.getJSONArray("result");
                            for(int i =0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonItem = jsonArray.getJSONObject(i);
                                String name = jsonItem.getString("name");
                                double scores =jsonItem.getDouble("score");
                                scores=(double)(Math.round(scores*100))/100;

                                reco_scores.add(String.valueOf(scores));
                                reco_outcome.add(name);
                            }
                            Log.d(TAG,"NOw the result is OK");

                            for(int j=0;j<reco_outcome.size();j++){

                                Log.d(TAG,"Recognition result :"+reco_outcome.get(j)+" confidence is:"+reco_scores.get(j));
                                if(j==reco_outcome.size()-1)
                                {  if(reco_outcome.get(j).equals("非果蔬食材"))
                                {       shibie_contents = shibie_contents+"肉";  }

                                else {       shibie_contents = shibie_contents + reco_outcome.get(j);                             }

                                }
                                else {
                                    if(reco_outcome.get(j).equals("非果蔬食材")){

                                        shibie_contents = shibie_contents +"肉" +",";
                                    }
                                    else {

                                        shibie_contents = shibie_contents + reco_outcome.get(j)+",";
                                    }

                                }

                            }
                            Log.d(TAG,shibie_contents);
                            Message message = new Message();
                            message.what =UPDATE_TEXT_OF_SHIBIE;
                            handler.sendMessage(message);




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//                        try {
//                            Log.d(TAG, res.toString(2));} catch (JSONException e) {
//
//                            e.printStackTrace();
//                        }
                    }
                }).start();


            }

            private byte[] getBitmapByte(Bitmap bitmap) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                try {
                    out.flush();
                    out.close();
                    Log.d(TAG,"Trans is OK");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return out.toByteArray(); }


        });



    }

    //这是图片压缩的部分
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        //将拍摄的照片显示出来
                        Bitmap bitmap2 = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        File outputImage=new File("/sdcard/Android/data/com.example.pic2cook_develop/cache/output_image.jpg");
                        Luban.with(getApplicationContext())
                                .load(outputImage)
                                .ignoreBy(100)
                                .setTargetDir("/sdcard/Android/data/com.example.pic2cook_develop/cache")
                                .filter(new CompressionPredicate() {
                                    @Override
                                    public boolean apply(String path) {
                                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                                    }
                                })
                                .setCompressListener(new OnCompressListener() {
                                    @Override
                                    public void onStart() {
                                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                                    }

                                    @Override
                                    public void onSuccess(File file) {
                                        // TODO 压缩成功后调用，返回压缩后的图片文件

                                        long size = file.length();
                                        size = size/1024;
                                        int bb = (int)size;
                                        String aa = String.valueOf(bb);
                                        Toast.makeText(getApplicationContext(),"压缩图片成功，压缩后的图片大小为"+ aa +"KB",Toast.LENGTH_LONG).show();
                                        compressed_image_path =file.getPath();

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        // TODO 当压缩过程出现问题时调用
                                    }
                                }).launch();

                        pics.setImageBitmap(bitmap2);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }


    //语音识别部分的封装类
    /**
     * 初始化语音识别
     */
    public void initSpeech(final Context context) {
        //1.创建RecognizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(context, null);
        //2.设置accent、language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                if (!isLast) {
                    //解析语音
                    //返回的result为识别后的汉字,直接赋值到TextView上即可
                    String result = parseVoice(recognizerResult.getResultString());
                    buchong_words = result;
                    finalresult =result+",";
                    Message message = new Message();
                    message.what =Show_shibiejieguo;
                    handler.sendMessage(message);

                }
            }

            @Override
            public void onError(SpeechError speechError) {

            }
        });
        //4.显示dialog，接收语音输入
        mDialog.show();
    }

    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }
    /**
     * 语音对象封装
     */
    public class Voice {

        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }





}
