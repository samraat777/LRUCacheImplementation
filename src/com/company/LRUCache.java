package com.company;
import java.util.*;

public class LRUCache {

    private Deque<Integer> doublyQueue;
    private HashSet<Integer> hashset;
    private final int CACHE_SIZE;

    public LRUCache(int CACHE_SIZE) {
        doublyQueue = new LinkedList<>();
        hashset = new HashSet<>();
        this.CACHE_SIZE = CACHE_SIZE;
    }

    public void refer(int page)
    {
        if(!hashset.contains(page))
        {
            if(doublyQueue.size() == CACHE_SIZE)
            {
                int last = doublyQueue.removeLast();
                hashset.remove(last);
            }
        }
        else
        {
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashset.add(page);
    }

    public void displayCache(){
        Iterator<Integer> itr = doublyQueue.iterator();
        System.out.println();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }

    public static void main(String[] args) {
	// write your code here
    LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(4);
        lruCache.refer(5);

        lruCache.displayCache();

        lruCache.refer(6);
        lruCache.refer(7);

        lruCache.displayCache();

    }
}
