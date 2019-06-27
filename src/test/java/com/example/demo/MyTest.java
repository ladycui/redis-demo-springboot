package com.example.demo;

//import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyTest {

    int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;

//    @Test
    public void printCircles() {
        printArray(array);
        int step = 3;
//        printCircle(step, 0, 0);
        int start_i = 0;
        int start_j = 0;
        while (step > 0) {
            printCircle(step, start_i, start_j);
            System.out.println();
            start_i++;
            start_j++;
            step -= 2;
        }

    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printCircle(int step, int start_i, int start_j) {
        int i = start_i;
        int j = start_j;
        d = 0;
        while (!(i - 1 == start_i && j == start_j)) {
            System.out.print(array[i][j] + "\t");
            if ((i == start_i && j == start_j + step)
                    || (j == start_j + step && i == start_i + step)
                    || (i == start_i + step && j == start_j)) {
                d = (d + 1) % 4;
            }
            i = i + directions[d][0];
            j = j + directions[d][1];
        }
        System.out.print(array[i][j]);
    }

}
