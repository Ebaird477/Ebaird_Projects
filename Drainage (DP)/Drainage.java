
//written by Ethan Baird, (ecb3ac), collaborated with Christian Boxley (clb7cy), Eleanor Ozer, (eo5fj)

import java.lang.Math;

public class Drainage{

    private static int[][] elevation_map;  // Input grid
    private static int[][] drain_map;  // grid to keep track of subproblems' solutions
    
    public static int[] backtrack(final int start_x, final int start_y){
        /*
        After running longest_drain, Backtracking can be used to reconstruct 
        the longest path found using the DP memory (drain_map in this case).
        
        Backtracking will begin from a given location (start_x, start_y).
        We know that drain_map[start_x][start_y] contains the length of
        the longest river that ends at location (start_x, start_y), call this
        value "length". To reconstruct that longest river, we know that the 
        second-from-last location must be adjacent to (start_x, start_y) and
        contain value "length - 1". The third-from-last location must be
        adjacent to the second-from-last location and contain the value
        "length - 2", etc. 
        
        TODO: Implement the function as described above to use drain_map to 
        reconstruct the longest path ending at (start_x, start_y). The
        return value of this function should be the list of elevations in
        order from highest to lowest.
        */


        final int path_length = drain_map[start_x][start_y];
        final int[] path = new int[path_length];
        int pathIterator = 0;
        int move_y = start_y;
        int move_x = start_x;
        int maxOfArray = drain_map.length;
        
        while(pathIterator < path_length){

            if(drain_map[move_x][move_y] == 1){
                path[pathIterator] = elevation_map[move_x][move_y];
                pathIterator += 1;
            }

            if(move_x == 0){
                if(move_y == 0){

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y + 1;
                    }
                }
                
                else if(move_y + 1 > maxOfArray){

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x + 1;
                    }
    
                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y - 1;
                    }

                }

                else{

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y - 1;
                    }

                }

            }

            else if(move_y == 0){
                
                if(move_x + 1 > maxOfArray){

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x - 1;
                    }
    
                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y + 1;
                    }

                }

                else{

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x - 1;
                    }

                }

            }

            else if(move_y + 1 > maxOfArray){
                
                if(move_x + 1 > maxOfArray){

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x - 1;
                    }
    
                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y - 1;
                    }

                }

                else{

                    if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x + 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_y = move_y - 1;
                    }

                    else if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                        path[pathIterator] = elevation_map[move_x][move_y];
                        pathIterator += 1;
                        move_x = move_x - 1;
                    }

                }

            }

            else if(move_x + 1 > maxOfArray){

                if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_y = move_y + 1;
                }

                else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_y = move_y - 1;
                }

                else if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_x = move_x - 1;
                }
            
            }

            else{

                if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y + 1]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_y = move_y + 1;
                }

                else if(drain_map[move_x][move_y] - 1 == drain_map[move_x][move_y - 1]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_y = move_y - 1;
                }

                else if(drain_map[move_x][move_y] - 1 == drain_map[move_x - 1][move_y]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_x = move_x - 1;
                }

                else if(drain_map[move_x][move_y] - 1 == drain_map[move_x + 1][move_y]){
                    path[pathIterator] = elevation_map[move_x][move_y];
                    pathIterator += 1;
                    move_x = move_x + 1;
                }


            }

            

        }


        //path[path_length-1] = elevation_map[start_x][start_y];
        return path;
    }
    
    public static int find_drain(final int x, final int y){
        /*
        This function will be used to find the longest river that ends at
        location (x,y). This function is where we will be making use of
        the dynamic programming paradigm. Think about how to the value of 
        drain_map[x][y] relates to the drain_map values of its neighbors.
        
        In the opinion of the course staff, this particular function is 
        much easier to implement as "top-down".
        
        TODO: Implement, using dynamic programming, this function that
        will return the length of the longest path through the 
        elevation map that ends at location (x, y). Use drain_map to
        keep track of the solutions to your subproblems.
        */
        int maxOfArray = drain_map.length - 1;
        int[] tempArr = new int[]{1, 1, 1, 1};
        int solution = 1;

        if(x == 0 && y == 0){

            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[0] = find_drain(x + 1, y) + 1;
                
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }
            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }


        else if(x == 0 && y + 1 > maxOfArray){

            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[0] = find_drain(x + 1, y) + 1;
            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[1] = find_drain(x, y - 1) + 1;
            }
            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }
        }


        else if(y == 0 && x + 1 > maxOfArray){
            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[0] = find_drain(x - 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }

        else if(x + 1 > maxOfArray && y + 1 > maxOfArray){
            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[0] = find_drain(x - 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[1] = find_drain(x, y - 1) + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }

        else if(y + 1 > maxOfArray){

            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[0] = find_drain(x - 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[1] = find_drain(x + 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[2] = find_drain(x, y - 1) + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }

        else if(x + 1 > maxOfArray){

            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[0] = find_drain(x - 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[2] = find_drain(x, y - 1) + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }

        else if(x == 0){

            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[0] = find_drain(x + 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[2] = find_drain(x, y - 1) + 1;
            }
            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
            drain_map[x][y] = solution;
        }
        
        else if(y == 0){
            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[0] = find_drain(x + 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[2] = find_drain(x - 1, y) + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }
        }

        else{
            if(elevation_map[x][y] > elevation_map[x + 1][y]){
                tempArr[0] = find_drain(x + 1, y) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y + 1]){
                tempArr[1] = find_drain(x, y + 1) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x][y - 1]){
                tempArr[2] = find_drain(x, y - 1) + 1;
            }

            if(elevation_map[x][y] > elevation_map[x - 1][y]){
                tempArr[3] = drain_map[x - 1][y] + 1;
            }

            for(int a = 0; a < tempArr.length; a++){
                if(tempArr[a] > solution){
                    solution = tempArr[a];
                }
            }

        }

        drain_map[x][y] = solution;
    
        return drain_map[x][y];
    }
    
    public static int longest_drain(final int[][] grid){
        /*
        longest_drain overloaded to make the backtracking argument optional
        */
        return longest_drain(grid, false);
    }
    
    public static int longest_drain(final int[][] grid, final boolean backtracking){
        /*
        Invoke this function to find the longest path. The way this works
        is that it will invoke find_drain on every location in the
        elevation_map to find the longest drain ending there, saving the
        longest seen.
        
        If backtracking is enabled (i.e. the function is invoked with the
        "backtracking" parameter assigned the value True), then this 
        function will reconstruct and print the path of the flow as a
        sequence of elevations.
        
        There is nothing for you to implement here.
        */    
        elevation_map = grid;
        final int size = grid.length;
        drain_map = new int[size][size];
        int longest = -1;


        
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                longest = Math.max(longest, find_drain(x,y));
            }
        }
        if(backtracking){
            for(int x = 0; x < size; x++){
                for(int y = 0; y < size; y++){
                    if(drain_map[x][y] == longest){
                        final int[] path = backtrack(x,y);
                        System.out.print("Path: ");
                        for(final int elevation : path){
                            System.out.print(elevation + " ");
                        }
                        System.out.println();
                        return longest;
                    }
                }
            }
        }
        return longest;
    }










}
