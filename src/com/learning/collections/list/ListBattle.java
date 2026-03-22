package com.learning.collections.list;

/* Compare ArrayList and LinkedList in deletion speed */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListBattle {
    static final int MAX_AMOUNT = 100_000_0;

    public static void removeEven(List<Integer> list) {
//        list.removeIf(n -> n % 2 == 0); // Optimized for ArrayList. Same realization for LinkedList

        //O(n^2) (delete elem and move tail)
        if (list.getClass() == ArrayList.class) {
            for (int i = MAX_AMOUNT - 1; i >= 0; i--) {
                if (i % 2 == 0) {
                    list.remove(i);
                }
            }
        }
        //O(n)
        else if (list.getClass() == LinkedList.class) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() % 2 == 0) {
                    iterator.remove();
                }
            }
        }
    }

    public static void initializeList(List<Integer> list) {
        for (int i = 0; i < MAX_AMOUNT; i++) {
            list.addLast(i);
        }
    }

    public static void checkTime(List<Integer> list) {
        initializeList(list);
        long startTime = System.currentTimeMillis();
        removeEven(list);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
//        for (var el : list) {
//            System.out.print(el + " ");
//        }
    }

    public static void main(String[] args) {
        System.out.println("ArrayList");
        checkTime(new ArrayList<>(MAX_AMOUNT));

        System.out.println("LinkedList");
        checkTime(new LinkedList<>());
    }
}
