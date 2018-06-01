package com.company;

public class IntArrayList implements IntList {

    private int[] array;

    public IntArrayList() {
        array = new int[0];
    }

    @Override
    public void add(int element) {
        int[] tmp = array;
        array = new int[tmp.length + 1];
        System.arraycopy(tmp, 0, array, 0, tmp.length);
        array[array.length - 1] = element;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            int[] tmp = array;
            array = new int[tmp.length + 1];
            System.arraycopy(tmp, 0, array, 0, index);
            array[index] = element;
            System.arraycopy(tmp, index, array, index + 1, tmp.length - index);
        }
    }

    @Override
    public void clear() {
        array = new int[0];
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int[] tmp = array;
        array = new int[tmp.length - 1];
        System.arraycopy(tmp, 0, array, 0, index);
        System.arraycopy(tmp, index + 1, array, index, tmp.length - index - 1);
        return true;
    }

    @Override
    public boolean removeElement(int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public int[] makeArrayFromIntList(IntList list) {
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    @Override
    public IntList makeIntListFromArray(int[] array) {
        IntList resultIntList = new IntArrayList();
        for (int i = 0; i < array.length; i++) {
            resultIntList.add(array[i]);
        }
        return resultIntList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append("Element ").append(i).append(" : ").append(array[i]).append("\n");
        }
        return result.toString();
    }
}