import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public  class BitMixComparator implements Comparator<Pixel>{

    @Override
    public int compare(Pixel p1, Pixel p2) {

        if(Double.parseDouble(p1.getBitMix())>Double.parseDouble(p2.getBitMix()))
            return 1;
        else if(Double.parseDouble(p1.getBitMix())==Double.parseDouble(p2.getBitMix()))
            return 0;
        else return -1;
    }

    public void compare_test(){
        Pixel p1=new Pixel(545464658,25,8,0);
        Pixel p2=new Pixel(0,0,0,0);

        System.out.println(compare(p1,p2));
    }
}