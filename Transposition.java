import java.util.Arrays;
import java.util.Scanner;

public class Transposition {
    static String cypher(String s, int dim) {
        int y = filas(s, dim);
        char[][] a = new char[y][dim];
        StringBuilder ss = new StringBuilder();
        int total = y * dim;
        y = 0;
        dim = 0;
        for (int i = 0; i < total; i++) {//leo el String por filas y doy valor 0 aquellos que no necesito
            if (i < s.length()) {
                a[y][dim] = s.charAt(i);
            } else {
                a[y][dim] = 0;
            }
            if (dim == a[0].length - 1) {
                y++;
                dim = 0;
            } else {
                dim++;
            }
        }
        y = 0;
        dim = 0;
        for (int i = 0; i < total; i++) {//creo un string por columnas y omito aquellos que tienen valor 0
            if (a[y][dim] != 0) {
                ss.append(a[y][dim]);
            }
            if (y == a.length - 1) {
                dim++;
                y = 0;
            } else {
                y++;
            }
        }
        return ss.toString();
    }

    static int filas(String s, int dim) {//define el número de filas en función de dim
        double S = s.length();
        double y;
        y = S / dim;
        if ((int) y != y) {
            y++;
        }
        return (int) y;
    }

    static String decypher(String s, int dim) {
        int y = filas(s, dim);
        char[][] a = new char[y][dim];
        StringBuilder ss = new StringBuilder();
        int total = y * dim;
        int ast = total - s.length();
        for (int i = 0; i < ast; i++) {// da valor 1 a aquellas que no necesitamos (es 1 y no 0 porque por defecto es 0 y no podía darle valores)
            a[y - 1][dim - 1] = 1;
            dim--;
        }
        y = 0;
        dim = 0;
        for (int i = 0, z = 0; i < total; i++) {// leo el string por columnas omitiendo aquellas con valor 1
            if (a[y][dim] != 1) {
                a[y][dim] = s.charAt(z);
                z++;
            }
            if (y == a.length - 1) {
                dim++;
                y = 0;
            } else {
                y++;
            }
        }
        y = 0;
        dim = 0;
        for (int i = 0; i < total; i++) {//creo un string por filas omitiendo aquellas con valor 1
            if (a[y][dim] != 1) {
                ss.append(a[y][dim]);
            }
            if (dim == a[0].length - 1) {
                y++;
                dim = 0;
            } else {
                dim++;
            }
        }
        return ss.toString();
    }


    static String cypher(String s, String key) {
        int y = filas(s, key.length()) + 1;
        int total = (y - 1) * key.length();
        StringBuilder ss = new StringBuilder();
        char[][] a = new char[y][key.length()];
        for (int i = 0; i < key.length(); i++) {
            a[0][i] = key.charAt(i);
        }
        int x = 0;
        y = 1;
        for (int i = 0; i < total; i++) {
            if (i < s.length()) {
                a[y][x] = s.charAt(i);
            } else {
                a[y][x] = 0;
            }
            if (x == a[0].length - 1) {
                y++;
                x = 0;
            } else {
                x++;
            }
        }
        char[][] aOrder = alphabeticalOrder(a);
        x = 0;
        y = 1;
        for (int i = 0; i < total; i++) {
            if (aOrder[y][x] != 0) {
                ss.append(a[y][x]);
            }
            if (y == aOrder.length - 1) {
                x++;
                y = 1;
            } else {
                y++;
            }
        }
        return ss.toString();
    }

    static char[][] alphabeticalOrder(char a[][]) {
        char[] save = new char[a.length];
        for (int i = 0, j; i < a[0].length; i++) {//Este bucle determina las veces que tendra que hacer el proceso de ordenación.
            j = 0;
            while (j != a[0].length - 1) {//Este bucle va avanzando los caracteres dentro de la primera fila del array bidimensional que es donde esta la key.
                if (a[0][j] > a[0][j + 1]) {//Este if compara los caracteres.
                    for (int k = 0; k < a.length; k++) {//Este bucle se encarga de mover en columnas para ordenarlo alfabeticamente.
                        save[k] = a[k][j];
                        a[k][j] = a[k][j + 1];
                        a[k][j + 1] = save[k];
                    }
                }
                j++;
            }
        }
        return a;
    }

    static String decypher(String s, String key) {
        int x = key.length();
        int y = filas(s, x);
        char[] KEY = new char[key.length()];
        char[][] a = new char[y +2][x];
        for (int i = 0; i < key.length(); i++) {
            a[0][i] = key.charAt(i);
            a[1][i] = (char) (i+2);
            KEY[i] = (char) (i+2);
        }
        StringBuilder ss = new StringBuilder();
        int total = y * x;
        int ast = total - s.length();
        for (int i = 0; i < ast; i++) {// da valor 1 a aquellas que no necesitamos (es 1 y no 0 porque por defecto es 0 y no podía darle valores)
            a[y +1][x - 1] = 1;
            x--;
        }
        System.out.println(Arrays.deepToString(a));
        char[][] aOrder = alphabeticalOrderLite(a);
        System.out.println(Arrays.deepToString(aOrder));
        y = 2;
        x = 0;
        for (int i = 0, z = 0; i < total; i++) {// leo el string por columnas omitiendo aquellas con valor 1
            if (aOrder[y][x] != 1) {
                aOrder[y][x] = s.charAt(z);
                z++;
            }
            if (y == aOrder.length - 1) {
                x++;
                y = 2;
            } else {
                y++;
            }
        }
        System.out.println(Arrays.deepToString(aOrder));
        for (int k = 2; k < aOrder.length ; k++) {
            for (int i = 0; i < key.length(); i++) {
                for (int j = 0; j < aOrder[0].length; j++) {
                    if (KEY[i] == aOrder[1][j]) {
                        if(aOrder[k][j] != 1) {
                            ss.append(aOrder[k][j]);
                        }
                    }
                }
            }
        }
        return ss.toString();
    }

    static char[][] alphabeticalOrderLite(char[][] a){
        char save;
        for (int i = 0,j; i < a[0].length ; i++) {
            j = 0;
            while (j != a[0].length-1){
                if(a[0][j] > a[0][j +1]){
                  save =  a[0][j];
                  a[0][j] = a[0][j +1];
                  a[0][j+1] = save;
                  save = a[1][j];
                  a[1][j] = a[1][j +1];
                  a[1][j+1] = save;
                  save = a[a.length-1][j];
                  a[a.length-1][j] = a[a.length-1][j+1];
                  a[a.length-1][j+1] = save;
                }
                j++;
            }
        }
        return a;
    }
}
