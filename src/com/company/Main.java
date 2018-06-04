package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    private static IntList intArrayList = new IntArrayList();
    private static IntList intLinkedList = new IntLinkedList();

    static {
        intArrayList.add(6);
        intArrayList.add(7);
        intArrayList.add(2);
        intArrayList.add(12);
        intArrayList.add(5);
        intArrayList.add(9);
        intArrayList.add(1);
        intArrayList.add(13);
        intArrayList.add(4);
        intArrayList.add(8);
        intArrayList.add(0);
        intArrayList.add(3);
        intArrayList.add(10);
        intArrayList.add(11);

        intLinkedList.add(70);
        intLinkedList.add(110);
        intLinkedList.add(40);
        intLinkedList.add(100);
        intLinkedList.add(170);
        intLinkedList.add(20);
        intLinkedList.add(50);
        intLinkedList.add(160);
        intLinkedList.add(60);
        intLinkedList.add(140);
        intLinkedList.add(120);
        intLinkedList.add(10);
        intLinkedList.add(90);
        intLinkedList.add(130);
        intLinkedList.add(80);
        intLinkedList.add(150);
        intLinkedList.add(30);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("IntArrayList before sorting:");
        System.out.println(intArrayList);
        printSpaces();
        System.out.println("IntArrayList after sorting:");
        sort(intArrayList);
        printSpaces();
        System.out.println("IntLinkedList before sorting:");
        System.out.println(intLinkedList);
        printSpaces();
        System.out.println("IntLinkedList after sorting:");
        sort(intLinkedList);
        printSpaces();
        printResizeCounter(1000);
        printResizeCounter(1000000);
        //printResizeCounter(1000000000);
        System.out.println();
        System.out.println("The results of the list speed test for classes 'ArrayList<Integer>', 'IntArrayList', 'LinkedList<Integer>' and 'IntLinkedList'.");
        printComputerConfiguration();
        speedTest();
    }

    private static void sort(IntList list) {
        int[] array = list.makeArrayFromIntList(list);
        int temp, j;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        System.out.println(list.makeIntListFromArray(array));
    }

    private static void printSpaces() {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println();
    }

    private static void printResizeCounter(int size) {
        IntArrayList intArrayList = new IntArrayList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            intArrayList.add(random.nextInt(10));
        }
        System.out.printf("The method 'resize()' is called %d times when %d elements are added to the list.\n", intArrayList.getResizeCounter(), size);
    }

    private static void printComputerConfiguration() {
        System.out.println();
        System.out.println("Computer configuration: ");
        System.out.println("Processor: Intel(R) Core(TM) i7-7500U CPU @ 2.70GHz 2.90 GHz");
        System.out.println("Installed memory (RAM): 8,00 GB");
        System.out.println("System type: 64-bit Operating System");
        System.out.println("Windows edition: Windows 10 Home edition");
        System.out.println();
    }

    private static void speedTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntArrayList intArrayList = new IntArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntLinkedList intLinkedList = new IntLinkedList();

        final int COUNT = 100000;
        long timeBefore;
        long timeAfter;
        double currentTime;

        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(random.nextInt(100));
            intArrayList.add(random.nextInt(100));
            linkedList.add(random.nextInt(100));
            intLinkedList.add(random.nextInt(100));
        }

        System.out.println("Method 'get(int index)' from the middle of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int element)' to the end of the list (2'000'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            arrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            intArrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            linkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            intLinkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the top of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the middle of the list (5'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(arrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intArrayList.add(intArrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.add(linkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intLinkedList.add(intLinkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the top of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the middle of the list (5'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intArrayList.remove(intArrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intLinkedList.remove(intLinkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();
    }
}