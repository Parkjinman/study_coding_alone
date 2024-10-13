package inflearn.DataStructure.List;

import java.util.Vector;

public class VectorMain {

    public static void main(String args[]) {
        Vector vector = new Vector();
        vector.add(2);
        vector.add(1);
        vector.add(3);
        vector.add(5);
        vector.add(4);
        vector.remove(0);

        System.out.println(vector);
        System.out.println(vector.get(0));
        System.out.println(vector.get(1));
        System.out.println(vector.get(6));
    }

}
