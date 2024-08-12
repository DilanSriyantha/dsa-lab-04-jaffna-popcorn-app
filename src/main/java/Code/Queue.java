package Code;

public class Queue {
    private int maxSize;
    private Order[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    public int viewFront;
    
    public Queue(int maxSize){
        this.maxSize = maxSize;
        queueArray = new Order[10];
        front = 0;
        rear = -1;
        nItems = 0;
        viewFront = 0;
    }
    
    public boolean isEmpty() {
        return nItems == 0;
    }
    
    public boolean isFull() {
        return nItems == maxSize;
    }
    
    public void insert(int orderNumber, String p[], int q[]){
        if(isFull()) return;
        
        queueArray[++rear] = new Order(orderNumber, p, q);
        nItems++;
    }
    
    public Order remove() {
        if(isEmpty()) return null;
        
        nItems--;
        return queueArray[front++];
    }
    
    public Order peek() {
        return queueArray[front];
    }
    
    public int getFront() {
        return front;
    }
    
    public int getRear() {
        return rear;
    }
    
    public Order getNext() {
        return queueArray[++viewFront];
    }
    
    public void resetViewFront() {
        viewFront = front;
    }
    
    public int getMaxSize() {
        return maxSize;
    }
    
    public int getNItems() {
        return nItems;
    }
}
