package edu.agh.jtplab.zad0;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



public class MeanFilter implements iImageFilter {
    private String path;
    public MeanFilter(String path)
    {
    	this.path = path;
    }
    private double lum(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return .299*r + .587*g + .114*b;
    }
    private Color toGray(Color color) {
        int y = (int) (Math.round(lum(color)));   // round to nearest int
        Color gray = new Color(y, y, y);
        return gray;
    }
	@Override
    public  void process()  throws Throwable{
        File f=new File(path);                               //Input Photo File
        Color[] pixel=new Color[9];
        int R;
        int B;
        int G;
        String result_path = "Mean_"+f.getName();
        File output=new File(result_path);
        BufferedImage img=ImageIO.read(f);
        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
               R=0;
               G=0;
               B=0;
               pixel[0]=new Color(img.getRGB(i-1,j-1));
               pixel[1]=new Color(img.getRGB(i-1,j));
               pixel[2]=new Color(img.getRGB(i-1,j+1));
               pixel[3]=new Color(img.getRGB(i,j+1));
               pixel[4]=new Color(img.getRGB(i+1,j+1));
               pixel[5]=new Color(img.getRGB(i+1,j));
               pixel[6]=new Color(img.getRGB(i+1,j-1));
               pixel[7]=new Color(img.getRGB(i,j-1));
               pixel[8]=new Color(img.getRGB(i,j));
               for(int k=0;k<9;k++){
                   R+=pixel[k].getRed();
                   B+=pixel[k].getBlue();
                   G+=pixel[k].getGreen();
               }
               R=R/9;
               B=B/9;
               G=G/9;
               img.setRGB(i,j,toGray(new Color(R,B,G) ).getRGB()   );
            }
        ImageIO.write(img,"jpg",output);
    }
	
}
