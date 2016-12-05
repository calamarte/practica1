import java.util.Scanner;

/**
 * Created by calamarte on 30/11/2016.
 */
public class pruebas {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        String s = z.nextLine();
        int y = 3;
        int dim = 3;
        int total = y * dim;
        char [][] a = new char[y][dim];
        y = 0;
        dim = 0;
        for (int i = 0; i <= total ; i++) {
            if (i < s.length() ) {
                a[y][dim] = s.charAt(i);
                System.out.print(" "+a[y][dim]+" ");
            }else{
                a[y][dim] = ' ';
            }
            if (dim == a[1].length - 1){
                dim = 0;
                y++;
                System.out.println();
            }else{
                dim++;
            }
        }
    }
}
