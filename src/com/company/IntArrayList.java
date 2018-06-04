package com.company;

public class IntArrayList implements IntList {

    private int[] array;
    private int size;

    public IntArrayList() {
        int DEFAULT_SIZE = 10;
        array = new int[DEFAULT_SIZE];
    }

    @Override
    public void add(int element) {
        if (size >= array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    @Override
    public void add(int index, int element) {
        checkIndex(index);
        if (size >= array.length) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean removeElement(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void set(int index, int element) {
        checkIndex(index);
        array[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
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
        for (int anArray : array) {
            resultIntList.add(anArray);
        }
        return resultIntList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append("Element ").append(i).append(" : ").append(array[i]).append("\n");
        }
        return result.toString();
    }

    private void resize() {
        int newSize = array.length * 3 / 2 + 1;
        int[] newArr = new int[newSize];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }
}