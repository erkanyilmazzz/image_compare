import java.util.Comparator;

public class EucComparator implements Comparator<Pixel> {

    @Override
    public int compare(Pixel p1, Pixel p2) {
        int p1Red=p1.getRed();
        int p1Green=p1.getGreen();
        int p1Blue=p1.getBlue();
        int p2Red=p2.getRed();
        int p2Blue=p2.getBlue();
        int p2Green=p2.getGreen();
        return (p1Red*p1Red+p1Green*p1Green+p1Blue*p1Blue)-(p2Red*p2Red+p2Green*p2Green+p2Blue*p2Blue);
    }
}
