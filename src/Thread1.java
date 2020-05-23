import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.PriorityQueue;

public class Thread1 implements Runnable {
    private BufferedImage img;
    private String s;
    public Thread1(String _s){
        s=_s;
    }

    @Override
    public void run() {


        SynchronizedPrimarioryQueue PQLEX=new SynchronizedPrimarioryQueue(new LexComparator());
        SynchronizedPrimarioryQueue PQBMX=new SynchronizedPrimarioryQueue(new BitMixComparator());
        SynchronizedPrimarioryQueue PQEUC=new SynchronizedPrimarioryQueue(new EucComparator());

        Thread t3=new Thread(new ConsumerThread(PQEUC));
        Thread t2=new Thread(new ConsumerThread( PQLEX));
        Thread t4=new Thread(new ConsumerThread( PQBMX));

        try{
            File f=new File(s);
            img= ImageIO.read(f);

            int i,j;
            int rgb=0;
            int counter=0;
            for(i=0;i<img.getWidth();++i){
                for(j=0;j<img.getHeight();++j){
                    rgb=img.getRGB(i,j);

                    PQLEX.add(new Pixel(rgb));
                    PQBMX.add(new Pixel(rgb));
                    PQEUC.add(new Pixel(rgb));


                    counter++;
                    if(counter==100){
                        t2.start();
                        t3.start();
                        t4.start();
                    }

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}



