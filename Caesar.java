
public class Caesar {
    static String cypher(String s, int delta) {
        StringBuilder ss = new StringBuilder(s.length());
        int ch;
        for (int i = 0; i < s.length(); i++) {
            ch = (int) s.charAt(i);
            if ((ch >= 65) && (ch <= 122)) {//[65,122]
                if ((ch >= 97) && (ch <= 122)) {//mas converter [97,122]
                    ch -= 32;
                }
                if ((ch >= 65) && (ch <= 90)) {//cypher [65,90]
                    ch += delta;
                    while (ch > 90) {
                        ch = ch - 90;
                        ch = ch + 64;
                    }
                }
            }
            ss.append((char) ch);
        }
        s = ss.toString();
        return s.toUpperCase();
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
            }
                ss.append((char) ch);
        }
        s = ss.toString();
        return s;
    }



    static String magic(String s) {
        String ss = s;
        for (int i = 0; i < 26 ; i++) {
            ss = decypher(s,i);
            if(ss.contains(" EL ") || ss.contains(" LA ") || ss.contains(" DEL ")) {
                break;
            }
        }
        return ss;
    }
}
