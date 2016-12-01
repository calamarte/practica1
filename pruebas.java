import java.util.Scanner;

/**
 * Created by calamarte on 30/11/2016.
 */
public class pruebas {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        String s = z.nextLine();
        String password = z.nextLine();
        int a[] = new int [s.length()];
        for (int i = 0; i < s.length() ; i++) {
            a[i] = (int) s.toUpperCase().charAt(i) - 64;
        }
        System.out.println(a[0]);
        System.out.println(a[2]);

    }
}
