import java.util.Comparator;

public class LexComparator implements Comparator<Pixel> {


    @Override
    public int compare(Pixel p1, Pixel p2) {
        if(Double.parseDouble(p1.getLex())>Double.parseDouble(p2.getLex()))
            return 1;
        else if(Double.parseDouble(p1.getLex())==Double.parseDouble(p2.getLex()))
            return 0;
        else return -1;

    }
}
