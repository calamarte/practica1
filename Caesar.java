
public class Caesar {
    static String cypher(String s, int delta) {
        StringBuilder ss = new StringBuilder(s.length());
        String S = s.toUpperCase();
        int ch;
        for (int i = 0; i < s.length(); i++) {
            ch = (int) S.charAt(i);
            if ((ch >= 65) && (ch <= 90)) {//cypher [65,90]
                    ch += delta;
                    while (ch > 90) {
                        ch -= 90;
                        ch += 64;
                    }
                    while (ch < 65) {
                     ch = 65 - ch;
                     ch = 91 - ch;
                    }
            }
            ss.append((char) ch);
        }
        return ss.toString();
    }

    static String decypher(String s, int delta) {
        StringBuilder ss = new StringBuilder(s.length());
        int ch;
        for (int i = 0; i < s.length(); i++) {
            ch = (int) s.charAt(i);
            if ((ch >= 65) && (ch <= 90)) {//decypher [65,90]
                ch -= delta;
                while (ch < 65) {
                    ch = 65 - ch;
                    ch = 91 - ch;
                }
                while (ch > 90) {
                    ch -= 90;
                    ch += 64;
                }
            }
                ss.append((char) ch);
        }
        return ss.toString();
    }



    static String magic(String s) {
        StringBuilder ss = new StringBuilder();
        int[] abc = new int [26];
        int ch;
        int max = 0;
        int delta = 0;
        for (int i = 0; i < s.length() ; i++) {//cuento la cantidad de caracteres iguales del abcedario y los guardo en un array
            ch = s.toUpperCase().charAt(i);
            if((ch >= 65) && (ch <= 90)){
                abc[ch - 65]++;
            }
        }
        for (int i = 0; i < 26 ; i++) {//localizo en el array la posición que tiene la maxima cantidad por consiguiente el caracter
            if(abc[i] > max){
                max = abc[i];
                delta = i;
            }
        }
        delta += 65;
        delta -= 69;//averiguo la distancia que hay entre el caracter y la e
        return decypher(s,delta);
    }
}
