import java.util.Comparator;
import java.util.*;


public class PixelPriorityQueue {
    private Pixel[] heap;
    private int heapSize, capacity;
    private Comparator<Pixel> cmp;
    private boolean isLockOpen;

    public void lock(){
        isLockOpen=false;
    }
    public void openLock(){
        isLockOpen=true;
    }
    public boolean isLockOpen(){
        return isLockOpen;
    }

    /** Constructor **/
    public PixelPriorityQueue(int capacity,Comparator<Pixel> _cmp)
    {
        this.capacity = capacity + 1;
        heap = new Pixel[this.capacity];
        heapSize = 0;
        cmp=_cmp;
        isLockOpen=true;
    }
    public PixelPriorityQueue(Comparator<Pixel> _cmp)
    {
        this.capacity = 100 + 1;
        heap = new Pixel[this.capacity];
        heapSize = 0;
        cmp=_cmp;
        isLockOpen=true;
    }
    /** function to clear **/
    public void clear()
    {
        heap = new Pixel[capacity];
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void add(Pixel newJob)
    {

        if(heapSize==capacity-1){
            resize();
        }


        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && cmp.compare(newJob,heap[pos/2])>0)//
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;
    }
    /** function to remove task **/
    public Pixel poll()
    {
        int parent, child;
        Pixel item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[1];
        temp = heap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && cmp.compare(heap[child],heap[child+1])<0)//
                child++;
            if (cmp.compare(temp,heap[child])>=0)//
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }
    public Pixel peek(){
        return heap[1];
    }
    private void resize(){
        Pixel temp[]=new Pixel[capacity*2];
        capacity=capacity*2;
        int i=0;
        for(i=0;i<heap.length;++i){
            temp[i]=heap[i];
        }
        heap=temp;
    }

    public void PixelPriorityQueue_test(){
    Pixel p1=new Pixel(456);
        Pixel p2=new Pixel(789);
        Pixel p3=new Pixel(1545);
        Pixel p4=new Pixel(215);
        Pixel p5=new Pixel(555);
        Pixel p6=new Pixel(748);

        PixelPriorityQueue pq=new PixelPriorityQueue(2,new BitMixComparator());
        pq.add(p1);
        pq.add(p2);
        pq.add(p3);
        pq.add(p4);
        pq.add(p5);
        pq.add(p6);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }

}
