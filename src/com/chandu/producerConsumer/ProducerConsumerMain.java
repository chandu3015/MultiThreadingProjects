package com.chandu.producerConsumer;

public class ProducerConsumerMain {
    private static final CustomQueue queue = new CustomQueue(10);
    private static final int producersCount = 10;
    private static final int consumersCount = 1;
    private static final Thread[] producer = new Thread[producersCount];
    private static final  Thread[] consumer = new Thread[consumersCount];

    static {
        for(int i=0;i<=producersCount-1;i++)
             producer[i] =  new Thread(new Producer(queue),"producer "+i);
        for(int i=0;i<=consumersCount-1;i++)
            consumer[i] =  new Thread(new Consumer(queue),"comsumer "+i);

    }

    public  static void main(String[] args){

        for(int i=0;i<=producersCount-1;i++)
            producer[i].start();
        for(int i=0;i<=consumersCount-1;i++)
            consumer[i].start();
    }

}
