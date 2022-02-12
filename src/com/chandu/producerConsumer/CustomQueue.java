package com.chandu.producerConsumer;

import java.util.Arrays;

public class CustomQueue {
    private final int[] queue ;
    private static final Object queueLock = new Object();
    private int currentLength =0;
    private final int  MAX_SIZE;

    public CustomQueue(int MAX_SIZE)
    {
        queue=new int[MAX_SIZE];
        this.MAX_SIZE = MAX_SIZE;
    }

    public  void enQueue(int num) throws InterruptedException {
        synchronized (queueLock){
                if(currentLength <MAX_SIZE){
                    queue[currentLength]=num;
                    currentLength++;
                    System.out.println("added "+ num + " to Queue" + Arrays.toString(queue)+" current size is "+ currentLength +" by current Thread "+Thread.currentThread().getName());
                    queueLock.notify();//proper flow
                   // queueLock.wait();//deadlock  flow
                }
                else {
                    queueLock.wait();//proper flow
                    //queueLock.notify();//deadlock flow
                }
            Thread.sleep(3000);//Just for holding display in console
        }
    }

    public  void deQueue() throws InterruptedException {
        synchronized (queueLock){
                if(currentLength >0){
                    int num =queue[currentLength -1];
                    queue[currentLength -1]=0;
                    currentLength--;
                    System.out.println("removed "+ num + " from Queue" + Arrays.toString(queue)+" current size is "+ currentLength +" by current Thread "+Thread.currentThread().getName());
                    queueLock.notify();//proper flow
                   // queueLock.wait();//deadlock flow
                }
                else {
                    queueLock.wait();//proper flow
                   // queueLock.notify();//deadlock flow

                }
            Thread.sleep(3000);//Just for holding display in console
        }
    }




}
