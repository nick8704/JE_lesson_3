package com.company;

public class IntLinkedList implements IntList {

    private Node startNode;
    private Node endNode;
    private int size = 0;

    public IntLinkedList() {
    }

    private class Node {
        private int element;
        private Node next;

        public Node(Integer element) {
            this.element = element;
        }

        public Node() {
        }
    }

    @Override
    public void add(int element) {
        Node node = new Node(element);
        if (endNode == null) {
            startNode = node;
            endNode = node;
        } else {
            endNode.next = node;
            endNode = node;
        }
        size++;
    }

    @Override
    public void add(int index, int element) {
        checkIndex(index);
        Node node = new Node(element);
        if (index == 0) {
            node.next = startNode;
            startNode = node;
        } else if (index == size) {
            endNode.next = node;
            endNode = node;
        } else {
            Node tmp = findNodeBeforeByIndex(index);
            node.next = findByIndex(index);
            tmp.next = node;
        }
        size++;
    }

    @Override
    public void clear() {
        startNode = null;
        endNode = null;
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        return find(value) != null;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return findByIndex(index).element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
       checkIndex(index);
        if (index == 0) {
            startNode = startNode.next;
        } else {
            Node node = findNodeBeforeByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        return false;
    }

    @Override
    public boolean removeElement(int element) {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            startNode = null;
            endNode = null;
            size = 0;
            return true;
        }

        Node nodeBefore = findNodeBefore(element);

        if (nodeBefore.element == 0) {
            startNode = startNode.next;
            size--;
            return true;
        } else if (nodeBefore != null) {
            if (endNode.element == element) {
                nodeBefore.next = null;
                endNode = nodeBefore;
            } else {
                nodeBefore.next = nodeBefore.next.next;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void set(int index, int element) {
        findByIndex(index).element = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] makeArrayFromIntList(IntList list) {
        int[] resultArray = new int[list.size()];
        Node node = startNode;
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = node.element;
            node = node.next;
        }
        return resultArray;
    }

    @Override
    public IntList makeIntListFromArray(int[] array) {
        IntList resultIntList = new IntLinkedList();
        for (int anArray : array) {
            resultIntList.add(anArray);
        }
        return resultIntList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int index = 0;
        if (startNode != null) {
            Node node = startNode;
            result.append("Element ").append(index).append(" : ").append(startNode.element).append("\n");
            index++;
            while (node.next != null) {
                node = node.next;
                result.append("Element ").append(index).append(" : ").append(node.element).append("\n");
                index++;
            }
        }
        return result.toString();
    }

    @Override
    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node find(int value) {
        if (startNode == null) {
            return null;
        }

        if (startNode.element == value) {
            return startNode;
        }

        Node node = startNode;
        while (node.next != null) {
            node = node.next;
            if (node.element == value) {
                return node;
            }
        }
        return null;
    }

    private Node findByIndex(int index) {
        checkIndex(index);
        int tmpIndex = 0;
        if (startNode == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return startNode;
        }

        Node node = startNode;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node findNodeBefore(int value) {
        if (startNode.element == value) {
            return new Node();
        }

        Node node = startNode;
        while (node.next != null) {
            if (node.next.element == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node node = startNode;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}