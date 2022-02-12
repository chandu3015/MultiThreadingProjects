package com.chandu.producerConsumer;

import static java.lang.System.exit;

public class Consumer implements  Runnable {
    private final CustomQueue queue;

    public Consumer(CustomQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.consume();
    }

    private void consume() {
       while(true){

              try{
                  queue.deQueue();
              }
              catch (Exception ex)
              {
                  ex.printStackTrace();
                  exit(1);
              }

       }
    }
}
