package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max((a, b) -> a - b).get();
    }

    public double getMinimum() {
        return arrayList.stream().min((a, b) -> a - b).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public double getOrderedMedian() {
        int index = arrayList.size() / 2;
        return arrayList.size() % 2 == 0 ? (arrayList.get(index) + arrayList.get(index - 1)) / 2.0 : arrayList.get(index);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(x -> x % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return IntStream.rangeClosed(0, arrayList.size() - 1).filter(x -> arrayList.get(x) % 2 == 0).findFirst().getAsInt();
    }

    public boolean isEqual(List<Integer> arrayList) {
        long count = arrayList.stream().filter(x -> this.arrayList.contains(x)).count();
        return count == this.arrayList.size() && count == arrayList.size();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        arrayList.forEach(singleLink::addTailPointer);
        return ((int) singleLink.getNode(6) + (int) singleLink.getNode(7)) / 2.0;
    }

    public int getLastOdd() {
        return arrayList.stream().filter(x -> x % 2 == 1).reduce((a, b) -> b).get();
    }

    public int getIndexOfLastOdd() {
        return IntStream.rangeClosed(0, arrayList.size() - 1).filter(x -> arrayList.get(x) % 2 == 1).reduce((a, b) -> b).getAsInt();
    }

    static class SingleLinkImplementation implements SingleLink<Integer> {
        Node<Integer> head;
        Node<Integer> tail;

        @Override
        public Integer getHeaderData() {
            if (head == null) return null;
            return head.value;
        }

        @Override
        public Integer getTailData() {
            if (tail == null) {
                return null;
            }
            return tail.value;
        }

        @Override
        public int size() {
            Node node = head;
            int l = 0;
            while (node != null) {
                l++;
                node = node.next;
            }
            return l;
        }

        @Override
        public boolean isEmpty() {
            if (head == null) return true;
            return false;
        }

        @Override
        public boolean deleteFirst() {
            if (head == null) return false;
            if (head == tail) tail = head = null;
            else {
                head = head.next;
            }
            return true;
        }

        @Override
        public boolean deleteLast() {
            if (tail == null) return false;
            if (head == tail) tail = head = null;
            else {
                Node node = head;
                while (node.next != tail) {
                    node = node.next;
                }
                tail = node;
                node.next = null;
            }
            return true;
        }

        @Override
        public void addHeadPointer(Integer item) {
            Node<Integer> node = new Node<>(item);
            node.next = head;
            head = node;
            if (tail == null) tail = head;
        }

        @Override
        public void addTailPointer(Integer item) {
            Node<Integer> node = new Node<>(item);
            if (head == null) head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        @Override
        public Integer getNode(int index) {
            Node<Integer> node = head;
            for (int i = -1; i < index; i++) {
                if (node == null) throw new RuntimeException("Out of SingleLink size");
                node = node.next;
            }
            return node.value;
        }

        private class Node<T> {
            public Node next;
            protected T value;

            public Node(T value) {
                this.value = value;
            }
        }
    }
}
