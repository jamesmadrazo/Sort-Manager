package com.sparta.james.engineering50.javabasic;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int size;
        Scanner enter = new Scanner(System.in);
        System.out.println("How long is array?");
        size = enter.nextInt();
        int[] list = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Enter interger "+(i+1));
            list[i] = Integer.parseInt(enter.next());
        }

        System.out.println("Select method");
        System.out.println("1 - BubbleSort");
        System.out.println("2 - Merge Array");
        System.out.println("3 - Binary Tree");

        int turns =  enter.nextInt();
        switch(turns) {
            case 1 :
                BubbleSort.sorting(list);
                break;
            case 2 :
                System.out.println(Arrays.toString(MergeSort.Merge_sort(list, size)));
                break;
            case 3 :
                BinaryImplement bt = new BinaryImplement(list);
                System.out.println(Arrays.toString(bt.getSortedTreeAsc()));
            default :
        }

    }
}