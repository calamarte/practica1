

public class Vigenere {

    static String encode(String s, String password) {
        StringBuilder ss = new StringBuilder(s.length());
        String S = clear(s);
        String P = clear(password);
        int ch;
        int pas;
        for (int i = 0,j = 0; i < s.length(); i++) {
            ch = (int) S.charAt(i);
            if (j == password.length()) {
                j = 0;
            }
            pas = (int) P.charAt(j);
            if (( ch >= 65) && ( ch <= 90)) {
                ch -= 64;
                pas -= 64;
                ch += pas;
                while (ch > 26) {
                    ch -= 26;
                }
                ch += 64;
                j++;
            }
            ss.append((char) ch);
        }
        return ss.toString();
    }
    static String clear(String s) {//limpia los acentos
        StringBuilder sc = new StringBuilder(s.length());
        char ch;
        for (int i = 0; i < s.length() ; i++) {
            ch = s.toUpperCase().charAt(i);
            if ((ch == 'Á')  || (ch == 'À')){ch ='A';}
            if ((ch == 'É') || (ch == 'È')){ch = 'E';}
            if ((ch == 'Í') || (ch == 'Ì')){ch = 'I';}
            if ((ch == 'Ó') || (ch == 'Ò')){ch = 'O';}
            if ((ch == 'Ú') || (ch == 'Ù')){ch = 'U';}
            sc.append(ch);
        }
        return  sc.toString();//esta en mas
    }


    static String decode(String s, String password) {
        StringBuilder ss = new StringBuilder(s.length());
        String S = clear(s);
        String P = clear(password);
        int ch;
        int pas;
        for (int i = 0,j = 0; i < s.length(); i++) {
            ch = (int) S.charAt(i);
            if (j == password.length()) {
                j = 0;
            }
            pas = (int) P.charAt(j);
            if (( ch >= 65) && ( ch <= 90)) {
                ch -= 64;
                pas -= 64;
                ch -= pas;
                while (ch < 1) {
                    ch += 26;
                }
                ch += 64;
                j++;
            }
            ss.append((char) ch);
        }
        return ss.toString();
    }
}


