
public class ConsumerThread implements Runnable {
    private SynchronizedPrimarioryQueue pq;

    public ConsumerThread(SynchronizedPrimarioryQueue _pq) {
        pq = _pq;
    }


    @Override
    public void run(){
        int counter=0;
        while (counter<369116){

            try {
                System.out.println(this.toString()+" "+pq.poll());
                ++counter;
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }






}