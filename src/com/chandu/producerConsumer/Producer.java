package com.chandu.producerConsumer;

import java.util.Random;

import static java.lang.System.exit;

public class Producer implements  Runnable{
    private final CustomQueue queue;


    Producer(CustomQueue  queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        this.produce();
    }

    private void produce() {
        Random random = new Random();
      while(true)
      {
          int num = random.nextInt();
              try{
                  queue.enQueue(num);
              }
              catch(Exception exception)
              {
                  exception.printStackTrace();
                  exit(1);
              }

      }
    }
}
