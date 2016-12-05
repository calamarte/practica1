import java.util.Scanner;

public class Transposition {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce frase");
        String z = s.nextLine();
        System.out.println("Introduce dimension");
        int dim = s.nextInt();
        System.out.println(cypher(z,dim));
    }
    static String cypher(String s, int dim) {
        int y = filas(s,dim);
        char [][] a = new char[y][dim];
        StringBuilder ss = new StringBuilder();
        int total = y * dim;
        y = 0;
        dim = 0;
        for (int i = 0; i < total; i++) {
            if (i < s.length() ) {
                a[y][dim] = s.charAt(i);
            }else{
                a[y][dim] = '*';
            }
            if (dim == a[0].length - 1){
                y++;
                dim = 0;
            }else{
                dim++;
            }
        }
        y = 0;
        dim = 0;
        for (int i = 0; i < total ; i++) {
            if (a[y][dim] != '*') {
                ss.append(a[y][dim]);
            }
            if (y == a.length - 1) {
                dim++;
                y = 0;
            }else{
                y++;
            }
        }
        return ss.toString();
    }
    static int  filas (String s, int dim){
        double S = s.length();//Duda aquí!
        double y;
        y = S / dim;
        if ((int) y != y) {
            y++;
        }
        return (int) y;
    }

    static String decypher(String s, int dim) {
        int y = filas(s,dim);
        char[][] a = new char [y][dim];
        StringBuilder ss = new StringBuilder();
        int total = y * dim;
        y = 0;
        dim = 0;
        for (int i = 0; i < total ; i++) {
            if (i < s.length()) {
                a[y][dim] = s.charAt(i);
            }else{
                a[y][dim] = '*';
            }
            if (y == a.length - 1) {
                dim++;
                y = 0;
            }else{
                y++;
            }
        }
        y = 0;
        dim = 0;
        for (int i = 0; i < total ; i++) {
            if (a[y][dim] != '*') {
                ss.append(a[y][dim]);
            }
            if (dim == a[0].length - 1) {
                y++;
                dim = 0;
            }else{
                dim++;
            }
        }
        return ss.toString();
    }


    static String cypher(String s, String key) {
        return null;
    }

    static String decypher(String s, String key) {
        return null;
    }
}
