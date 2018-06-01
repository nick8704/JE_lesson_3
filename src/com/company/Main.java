package com.company;

public class Main {

    private static IntList intArrayList = new IntArrayList();
    private static IntList intLinkedList = new IntLinkedList();

    static {
        intArrayList.add(6);
        intArrayList.add(7);
        intArrayList.add(2);
        intArrayList.add(5);
        intArrayList.add(9);
        intArrayList.add(1);
        intArrayList.add(4);
        intArrayList.add(8);
        intArrayList.add(0);
        intArrayList.add(3);

        intLinkedList.add(70);
        intLinkedList.add(110);
        intLinkedList.add(40);
        intLinkedList.add(100);
        intLinkedList.add(20);
        intLinkedList.add(50);
        intLinkedList.add(60);
        intLinkedList.add(140);
        intLinkedList.add(120);
        intLinkedList.add(10);
        intLinkedList.add(90);
        intLinkedList.add(130);
        intLinkedList.add(80);
        intLinkedList.add(30);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("IntArrayList before sorting:");
        System.out.println(intArrayList.toString());
        printSpaces();
        System.out.println("IntArrayList after sorting:");
        sort(intArrayList);
        printSpaces();
        System.out.println("IntLinkedList before sorting:");
        System.out.println(intLinkedList.toString());
        printSpaces();
        System.out.println("IntLinkedList after sorting:");
        sort(intLinkedList);
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
        System.out.println(list.makeIntListFromArray(array).toString());
    }

    private static void printSpaces() {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println();
    }
}