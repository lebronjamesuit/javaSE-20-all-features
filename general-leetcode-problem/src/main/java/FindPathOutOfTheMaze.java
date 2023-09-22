import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindPathOutOfTheMaze {


    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] grid = readInputGrid(br, rows, cols);

        int path = shortestPath(rows, cols, grid);
        System.out.println(path);
    }

    static int[][] readInputGrid(BufferedReader br, int rows, int cols) throws Exception {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
        return grid;
    }


    static int shortestPath(int rowsSize, int colsSize, int[][] grid) {
        int  [][] drawThePath = new int [rowsSize][colsSize];
        // first element
        drawThePath[0][0] = 0; //  0 go;  -1 block

        // draw the first column
        for (int col = 1; col < colsSize; col++) {
            drawThePath[0][col] = (grid[0][col] == 0 ?  drawThePath[0][col-1] + 1 : -1 ) ;
        }

        // draw the first row
        for (int row = 1; row < rowsSize; row++) {
            drawThePath[row][0] = ( grid[row][0] == 0 ?  drawThePath[row - 1][0] + 1 : -1) ;
        }

        // draw the rest of the row
        for (int row = 1; row < rowsSize; row++) {
            for (int col = 1; col < colsSize; col++) {
                if(grid[row][col] == 0){
                    // Min(top,left)
                    int top = (drawThePath[row-1][col] == -1 ? Integer.MAX_VALUE : drawThePath[row-1][col] ) ; // get  element above
                    int left = (drawThePath[row][col-1] == -1 ? Integer.MAX_VALUE : drawThePath[row][col-1]); // get  prev element
                    drawThePath[row][col] = Math.min(top,left) + 1;
               }else {
                    drawThePath[row][col] = -1; // end path
                }
            }
        }

        // Print test
        for (int i = 0; i < rowsSize; i++) {
            for (int j = 0; j < colsSize; j++) {
                System.out.print(drawThePath[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
        // Print test

        return drawThePath[rowsSize-1][colsSize-1];

    }


}


/*
 TEST CASES
 -> 8 steps
3 6
0 0 0 0 1 1
0 0 1 1 0 0
0 0 0 0 0 0

-> 7 steps
3 6
0 0 0 0 0 0
0 0 1 1 0 0
0 0 0 0 0 0

--> -1 step
3 6
0 0 0 0 0 0
0 0 1 1 0 0
0 0 0 0 0 1

--> 8 step
4 6
0 0 0 0 0 1
0 0 0 0 0 1
0 1 1 1 1 1
0 0 0 0 0 0


-------------------> 14 steps
6 10
0 0 0 0 0 0 0 0 1 1
0 1 1 1 0 0 1 1 1 1
0 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 0 0


--------------------> 14 steps
6 10
0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0
1 1 1 1 0 0 0 0 0 0


Run code by hands
   /*


 --> array
        4 6
        0  0  0  0  0  1
        0  0  0  0  0  1
        0  1  1  1  1  1
        0  0  0  0  0  0

Draw the path
 step 1
        0  1  2  3  4  -1
        1
        2
        3
 step 2    m = -1,
        0  1  2  3  4  m
        1  2  3  4  5  m
        2  m  m  m  m  m
        3  4  5  6  7   8

 */