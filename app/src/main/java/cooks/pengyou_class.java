package cooks;

public class pengyou_class {

    private String no;
    private String name;
    private String scores;
    private int imageID;
    private int dianan;

    public pengyou_class(String No,String Name,String Score,int ImageId,int Dianzan)
    {
        this.no =No;
        this.name =Name;
        this.scores =Score;
        this.imageID =ImageId;
        this.dianan =Dianzan;
    }

    public String getno(){return no;}
    public String getName(){return name;}
    public String getScore(){return scores;}
    public  int getImageID(){return imageID;}
    public int getDianan(){return dianan;}
}
