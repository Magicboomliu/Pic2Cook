package cooks;

import android.widget.Button;
import android.widget.EditText;

public class follow_dongtai_class {

    private int uploader_image;
    private int share;
    private String uploader_name;
    private int dish_image;
    private int dianzan;
    private String dianzanshumu;
    private int heart;
    private String discription;
    private String dish_name;
    private String pinglun1;
    private String pinglun2;


    public follow_dongtai_class(int uploader_Image, String uploader_Name,int Share, int dish_Image,
                                int Dianzan, String Dianzanshu, int Heart, String Disri,String Dish_name,
                                String Pinglun1,String Pinglun2)
    {
        this.uploader_image =uploader_Image;
        this.share =Share;
        this.uploader_name =uploader_Name;
        this.dish_image =dish_Image;
        this.dianzan =Dianzan;
        this.dianzanshumu =Dianzanshu;
        this.heart =Heart;
        this.discription=Disri;
        this.dish_name =Dish_name;
        this.pinglun1 =Pinglun1;
        this.pinglun2 =Pinglun2;
    }


    public  int getUploader_image(){return  uploader_image;}
    public  String getUploader_name(){return  uploader_name;}
    public int getShare(){return  share;}
    public int getDish_image(){return dish_image;}
    public String getDianzanshumu(){return  dianzanshumu;}
    public int getHeart(){return heart;}
    public int getDianzan(){return dianzan;}
    public String getDiscription(){return  discription;}
    public String getDish_name(){return dish_name;}
    public String getPinglun1(){return pinglun1;}
    public String getPinglun2(){return pinglun2;}
}
