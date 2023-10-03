package Brick;

import java.io.IOException;

public class Bricks {

    public static void main(String[] args) throws IOException {

        int height = 6;
        int total = height + 1;
        brick(height, total);
    }

    private static void brick(int height, int total){
        if(height == 0 ) return ;
        for (int i = 0; i < total - height; i++) {
            System.out.print("#");
        }
        System.out.println("");
        height--;
        brick(height, total);
    }
}
