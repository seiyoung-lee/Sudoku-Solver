package TESTS;

import org.junit.Test;
import SUDOKU.sudoku;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class test_sudoku {


    @Test
    public void testduplicatestrue() {
        sudoku s = new sudoku();
        int[] arr =  {1,2,3,4,5,6,7,8,9};
        assertTrue(s.noduplicates(arr));
    }

    @Test
    public void testduplicatesfalse() {
        sudoku s = new sudoku();
        int[] arr =  {1,2,3,4,5,6,7,8,8};
        assertFalse(s.noduplicates(arr));
    }

    @Test
    public void testduplicatestrue0() {
        sudoku s = new sudoku();
        int[] arr =  {0,2,3,4,5,6,7,8,0};
        assertTrue(s.noduplicates(arr));
    }

    @Test
    public void testduplicatesfalse0() {
        sudoku s = new sudoku();
        int[] arr =  {0,2,3,4,5,6,8,8,0};
        assertFalse(s.noduplicates(arr));
    }

    @Test
    public void testtablealltrue() {
        int[][] arr = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };

        sudoku s = new sudoku(arr);
        boolean[][] tab = s.returntable();
        for(int y = 0; y < 9; y++) {
            for(int x =0; x < 9; x++) {
                assertTrue(tab[y][x]);
            }
        }
    }
    @Test
    public void testtableallfalse() {
        int[][] arr = {
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9}
        };

        sudoku s = new sudoku(arr);
        boolean[][] tab = s.returntable();
        for(int y = 0; y < 9; y++) {
            for(int x =0; x < 9; x++) {
                assertFalse(tab[y][x]);
            }
        }
    }
}
