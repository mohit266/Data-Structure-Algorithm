package com.dsa.Heap;

import java.util.ArrayList;
import java.util.List;

public class ImplementMaxHeap {

    List<Integer> heap;
    int counter;

    public static void main(String[] args) {
        ImplementMaxHeap maxHeap = new ImplementMaxHeap();

    }


    public void initializeHeap() {
        heap = new ArrayList<>();
        counter = 0;
    }

    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap, counter);
        counter += 1;
    }


    public void changeKey(int index, int newVal) {

        if (heap.get(index) < newVal){
            heap.set(index, newVal);
            heapifyUp(heap, index);
        } else {
            heap.set(index, newVal);
            heapifyDown(heap, index);
        }
    }



    public void extractMax() {
        int topEle = heap.get(0);
        int lastEle = heap.get(counter - 1);

        heap.set(0, lastEle);
        heap.set(counter - 1, topEle);

        heap.remove(heap.size() - 1);
        counter -= 1;

        if (counter > 0){
            heapifyDown(heap, 0);
        }

    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getMax() {
        return heap.get(0);
    }

    public int heapSize() {
        return counter;
    }


    public void heapifyUp(List<Integer> ls, int index){
        int rootIndex = (index - 1)/2;

        if (index > 0 && ls.get(index) > ls.get(rootIndex)){
            swap(ls, index, rootIndex);
            heapifyUp(ls, rootIndex);
        }
    }

    public void heapifyDown(List<Integer> ls, int index){
        int n = ls.size();
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && ls.get(largest) < ls.get(left)){
            largest = left;
        }

        if (right < n && ls.get(largest) < ls.get(right)){
            largest = right;
        }

        if (largest != index){
            swap(ls, index, largest);
            heapifyDown(ls, largest);
        }
    }

    public void swap(List<Integer> ls, int i, int j){
        int temp = ls.get(j);
        ls.set(j, ls.get(i));
        ls.set(i, temp);
    }
}
