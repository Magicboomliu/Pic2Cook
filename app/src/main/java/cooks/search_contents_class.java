package cooks;

public class search_contents_class {
    private String iscompleted;
    private String dish_name;
    private String uploader_name;
    private String time;
    private String Complexity;
    private String Calories;
    private String recommend_scores;
    private String Likes_amount;
    private  int dish_image;
    private int uploader_iamge;


    public  search_contents_class(String isCom, String Dish_name,String Uploader_Name,String Time,String COmplexit,String Cal,
                                  String  Recomm,String LIK,int DImage, int UP_IM)
    {
        this.iscompleted =isCom;
        this.dish_name =Dish_name;
        this.uploader_name =Uploader_Name;
        this.time =Time;
        this.Complexity =COmplexit;
        this.Calories =Cal;
        this.recommend_scores =Recomm;
        this.Likes_amount =LIK;
        this.dish_image =DImage;
        this.uploader_iamge =UP_IM;
    }
    public String getIscompleted()
    {
        return iscompleted;
    }
    public String getDish_name()
    {
        return dish_name;
    }
    public String getUploader_name()
    {
        return uploader_name;
    }
    public String getTime()
    {return time;}
    public String getComplexity()
    {return Complexity;}

    public  String getCalories()
    {
        return Calories;
    }
    public String getRecommend_scores()
    {return  recommend_scores;}
    public String getLikes_amount()
    {return Likes_amount;}
    public  int getDish_image()
    {return dish_image;}
    public int getUploader_iamge()
    {
        return uploader_iamge;
    }
}
