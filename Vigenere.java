

public class Vigenere {

    static String encode(String s, String password) {
        StringBuilder ss = new StringBuilder();
        int[] a = new int [s.length()];
        int conts = 0;
        int contp = 0;
        while(conts < s.length()){
            if(((int)clear(s).charAt(conts) >= 65) && ((int)clear(s).charAt(conts) <= 90)){
                a[conts] = arrayS(s)[conts] + arrayP(s,password)[contp];
                while(a[conts] > 26)
                    a[conts] -= 26;
                contp++;
                ss.append((char)( a[conts] + 64));
            }else{
                ss.append(' ');
            }
            conts++;
        }
        return ss.toString();
    }
    static int[] arrayS(String s) {//crea un array con String s
        int[] a = new int [s.length()];
        for (int i = 0; i < s.length() ; i++) {
            a[i] = (int) clear(s).charAt(i) - 64;
            while(a[i] > 26) {
                a[i] -= 26;
            }
        }
       return a;
    }
    static int[] arrayP(String s, String password){//crea un array con String password
        int[] a = new int[noSpace(s).length()];
        for (int i = 0,j = 0; i < a.length; i++) {
            a[i] = (int) clear(password).charAt(j) - 64;
                while (a[i] > 26) {
                    a[i] -= 26;
                }
            if(j+1 == password.length()){
                j = 0;
            }else{
                j++;
            }
        }
        return a;
    }
    static String noSpace(String s){// genera String s sin espacios
        StringBuilder sc = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length() ; i++) {
            ch = s.charAt(i);
            if(((int)ch >= 65) && ((int)ch <= 122)){sc.append(ch);}
        }
        return sc.toString();
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
        return null;
    }
}


