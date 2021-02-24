//written by Ethan Baird, (ecb3ac), collaborated with Christian Boxley (clb7cy), Eleanor Ozer, (eo5fj)
import java.util.*;
import java.io.*;
import java.time.*;

public class DrainageTester{

    public static String[] tests = {"sample.txt","small.txt", "medium.txt", "flat.txt", "big.txt"};
    //"small.txt", "medium.txt", "flat.txt", "long.txt", "big.txt"
    public static int[][] read_test(String filename){
        File test_file = new File(filename);
        int[][] grid = new int[0][0];
        try{
            Scanner filereader = new Scanner(test_file);
            String line = filereader.nextLine();
            int size = Integer.parseInt(line);
            grid = new int[size][size];
            int i = 0;
            while (filereader.hasNextLine()) {
                line = filereader.nextLine();
                String[] st_row = line.split(" ");
                int[] row = new int[size];
                for(int j = 0; j < size; j++){
                    row[j] = Integer.parseInt(st_row[j]);
                }
                grid[i++] = row;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return grid;
    }
    
    public static void main(String[] args){
        //backtracking disabled, timing enabled
        for(int i = 0; i < tests.length; i++){
            String test_file = tests[i];
            int[][] grid = read_test(test_file);
            System.out.println(test_file);
            Instant before = Instant.now();
            int longest = Drainage.longest_drain(grid);
            System.out.println(test_file + " " + longest);
            Instant after = Instant.now();
            System.out.println("Answer: " + longest);
            System.out.println("Time: " + Duration.between(before, after).toMillis());
            System.out.println();
        }
        //backtracking enabled, short cases only
        for(int i = 0; i < 4; i++){
            String test_file = tests[i];
            int[][] grid = read_test(test_file);
            System.out.println(test_file);
            int longest = Drainage.longest_drain(grid, true);
            System.out.println(test_file + " " + longest);
            System.out.println("Answer: " + longest);
            System.out.println();
        }
    }










}
