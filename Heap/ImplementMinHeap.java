package com.dsa.Heap;

import java.util.ArrayList;
import java.util.List;

public class ImplementMinHeap {

    public List<Integer> heap;
    public int count;

    public static void main(String[] args) {
        ImplementMinHeap minHeap = new ImplementMinHeap();
        minHeap.initializeHeap();

        minHeap.insert(4);
        minHeap.insert(1);
        minHeap.insert(10);
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.heapSize());
        System.out.println(minHeap.isEmpty());
        minHeap.extractMin();
        minHeap.changeKey(0, 16);
        System.out.println(minHeap.getMin());

    }

    public void initializeHeap() {
        heap = new ArrayList<>();
        count = 0;
    }

    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap, count);
        count += 1;
    }

    public void changeKey(int index, int newVal) {
        if (heap.get(index) < newVal){
            heap.set(index, newVal);
            heapifyDown(heap, index);
        } else {
            heap.set(index, newVal);
            heapifyUp(heap, index);
        }
    }

    public void extractMin() {
        int firstEle = heap.get(0);

        int temp = heap.get(count - 1);
        heap.set(count-1, firstEle);
        heap.set(0, temp);

        heap.remove(count-1);
        count = count - 1;

        if (count > 0){
            heapifyDown(heap, 0);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMin() {
        return heap.get(0);
    }

    public int heapSize() {
        return count;
    }


    public void heapifyUp(List<Integer> ls, int index){
        int rootIndex = (index - 1)/2;

        if (index > 0 && ls.get(rootIndex) > ls.get(index)){
            swap(ls, rootIndex, index);
            heapifyUp(ls, rootIndex);
        }
    }

    public void heapifyDown(List<Integer> ls, int index){
        int n = heap.size();
        int smallest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && heap.get(left) < heap.get(smallest)){
            smallest = left;
        }
        if (right < n && heap.get(right) < heap.get(smallest)){
            smallest = right;
        }

        if (smallest != index){
            swap(heap, smallest, index);
            heapifyDown(heap, smallest);
        }
    }

    public void swap(List<Integer> ls, int i, int j){
        int temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }
}
