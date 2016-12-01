import org.junit.Test;

import static org.junit.Assert.*;

public class TestTotal {
    @Test
    public void testTotal() {
        String m = "L'amic ha de ser com els diners, que abans de necessitar-lo, se sap el valor que te.";
        String c1 = Caesar.cypher(m, 66);
        String c2 = Vigenere.encode(c1, "ordinador");
        String c3 = Transposition.cypher(c2, 5);
        String c4 = Transposition.cypher(c3, "LICEU");
        assertEquals("GK 'OP Z  SIR. KGJKC ,-WOKDVH FTSWEHU WQB DWEBIJBWOOGKO UEW RKYFRKSP   K YGFKSQSW X,", c4);

        String c5 = Transposition.decypher(c4, "LICEU");
        String c6 = Transposition.decypher(c5, 5);
        String c7 = Vigenere.decode(c6, "ordinador");
        String c8 = Caesar.decypher(c7, 66);
        assertEquals("L'AMIC HA DE SER COM ELS DINERS, QUE ABANS DE NECESSITAR-LO, SE SAP EL VALOR QUE TE.", c8);
    }
}