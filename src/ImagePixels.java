import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePixels {
    private BufferedImage img;

    private Pixel arr[][];


    /**
     * @param s path of image :
     * */
    public ImagePixels(String s){
        try{
            File f=new File(s);
            img=ImageIO.read(f);
            arr=new Pixel[img.getWidth()][img.getHeight()];

            int i,j;
            int rgb=0;
            for(i=0;i<img.getWidth();++i){
                for(j=0;j<img.getHeight();++j){
                    rgb=img.getRGB(i,j);
                    arr[i][j] =new Pixel(rgb,(rgb>>16) & 0xff,(rgb>>8) & 0xff,rgb & 0xff);
                }
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**@param x  heigh index of image
     * @param y witdh index of image
     * @throws IndexOutOfBoundsException if x,y is not bound of image
     * */
    public int getBlue(int x,int y)throws IndexOutOfBoundsException{
        if(x<0||y<0|| x>img.getWidth()||y>img.getHeight()){
            throw new IndexOutOfBoundsException();
        }
        return arr[x][y].getBlue();
    }
    /**@param x  heigh index of image
     * @param y witdh index of image
     * @throws IndexOutOfBoundsException if x,y is not bound of image
     * */
    public int getRed(int x,int y)throws IndexOutOfBoundsException{
        if(x>img.getWidth()||y>img.getHeight()){
            throw new IndexOutOfBoundsException();
        }
        return arr[x][y].getRed();
    }
    /**@param x  heigh index of image
     * @param y witdh index of image
     * @throws IndexOutOfBoundsException if x,y is not bound of image
     * */
    public int getGreen(int x,int y)throws IndexOutOfBoundsException{
        if(x>img.getWidth()||y>img.getHeight()){
            throw new IndexOutOfBoundsException();
        }
        return arr[x][y].getGreen();
    }
    public int getHeigh(){
        return img.getHeight();
    }
    public int getWidth(){
        return img.getWidth();
    }

}
