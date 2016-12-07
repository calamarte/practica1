import java.util.Arrays;
import java.util.Scanner;

public class Transposition {
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
                a[y][dim] = 0;
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
            if (a[y][dim] != 0) {
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
        int ast = total -s.length();
        for (int i = 0; i < ast ; i++) {
            a[y-1][dim-1] = 0;
            dim--;
        }
        y = 0;
        dim = 0;
        for (int i = 0,z = 0; i < total ; i++) {
            if (a[y][dim] != 0) {
                a[y][dim] = s.charAt(z);
                z++;
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
            if (a[y][dim] != 0) {
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
        int y = filas(s,key.length()) + 1;
        int total = (y -1) * key.length();
        StringBuilder ss = new StringBuilder();
        char[][] a = new char[y][key.length()];
        for (int i = 0; i < key.length() ; i++) {
            a[0][i] = key.charAt(i);
        }
        int x = 0;
        y = 1;
        for (int i = 0; i < total; i++) {
            if (i < s.length() ) {
                a[y][x] = s.charAt(i);
            }else{
                a[y][x] = 0;
            }
            if (x == a[0].length - 1){
                y++;
                x = 0;
            }else{
                x++;
            }
        }
        char[][] aOrder = alphabeticalOrder(a);
        x = 0;
        y = 1;
        for (int i = 0; i < total ; i++) {
            if (aOrder[y][x] != 0) {
                ss.append(a[y][x]);
            }
            if (y == aOrder.length - 1) {
                x++;
                y = 1;
            }else{
                y++;
            }
        }
        return ss.toString();
    }

    static char[][] alphabeticalOrder(char a[][]) {
        char[] save = new char[a.length];
        for (int i = 0,j; i < a[0].length ; i++) {//Este bucle determina las veces que tendra que hacer el proceso de ordenación.
            j = 0;
            while(j != a[0].length -1) {//Este bucle va avanzando los caracteres dentro de la primera fila del array bidimensional que es donde esta la key.
                if (a[0][j] > a[0][j+1]){//Este if compara los caracteres.
                    for (int k = 0; k < a.length ; k++) {//Este bucle se encarga de mover en columnas para ordenarlo alfabeticamente.
                        save[k] = a[k][j];
                        a[k][j] = a[k][j+1];
                        a[k][j+1] = save[k];
                    }
                }
                j++;
            }
        }
        return a;
    }

    static String decypher(String s, String key) {
        return null;
    }
}
