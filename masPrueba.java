/**
 * Created by calamarte on 05/12/2016.
 */
public class masPrueba {
    public static void main(String[] args) {
        double c = 3.5;
        if (c != (int) c) {
            c++;
            System.out.println("lo son "+c+" = "+(int) c);
        }else{
            System.out.println("no funciona "+c+" = "+(int) c);
        }
    }
}
