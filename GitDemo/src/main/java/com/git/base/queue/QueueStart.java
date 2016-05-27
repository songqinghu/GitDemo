package com.git.base.queue;

import java.util.concurrent.ArrayBlockingQueue;

public interface QueueStart<T> {

    void threadStart(ArrayBlockingQueue<T> queue,Integer threadNum);
}
