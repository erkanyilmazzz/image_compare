import java.util.Comparator;

public class SynchronizedPrimarioryQueue {
    private PixelPriorityQueue queue ;
    private int  limit = 10;
    private Comparator<Pixel> cmp;

    public SynchronizedPrimarioryQueue(Comparator<Pixel> _cmp){
        cmp=_cmp;
        queue=new PixelPriorityQueue(cmp);
    }


    public synchronized void add(Pixel item)
            throws InterruptedException  {
        /*
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
        */

        synchronized (queue){
            if(this.queue.size() == 0) {
                notifyAll();
            }
            queue.add(item);

        }



    }


    public synchronized Pixel poll()
            throws InterruptedException{
       /* while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        return this.queue.poll();
        */
        while(queue.size()==0){
            wait();
        }
        return queue.poll();


    }


    public int size(){
        return queue.size();
    }


}
