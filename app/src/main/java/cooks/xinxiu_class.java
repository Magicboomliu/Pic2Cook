package cooks;

public class xinxiu_class {


    private String xno;
    private String xname;
    private String xscores;
    private int ximageID;
    private int xfollow;

    public xinxiu_class(String No,String Name,String Score,int ImageId,int xfollow)
    {
        this.xno =No;
        this.xname =Name;
        this.xscores =Score;
        this.ximageID =ImageId;
        this.xfollow =xfollow;
    }

    public String getXno(){return xno;}
    public String getXname(){return xname;}
    public String getXscores(){return xscores;}
    public  int getXimageID(){return ximageID;}
    public int getXfollow(){return xfollow;}
}
