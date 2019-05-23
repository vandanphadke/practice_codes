import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        char[][] mat = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        char[][] mat1 = {{'X','X','X'},
                {'X','O','X'},
                {'X','X','X'}};

        CaptureSurroundedRegions c = new CaptureSurroundedRegions();
        //c.solve(mat);
        //c.solve(mat1);

        for (int i = 0 ; i < mat.length; ++i)
            System.out.println(Arrays.toString(mat[i]));

        for (int i = 0 ; i < mat1.length; ++i)
            System.out.println(Arrays.toString(mat1[i]));
    }

}
