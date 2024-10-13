package inflearn.DataStructure.Map;

import java.util.Hashtable;

public class HashtableMain {
    public static void main(String args[]) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(1, 2);
        hashtable.put(2, 1);
        hashtable.put(3, 3);
        hashtable.put(5, 5);
        hashtable.put(4, 4);

        System.out.println(hashtable);
        System.out.println(hashtable.remove(5));
        System.out.println(hashtable.get(1));
        System.out.println(hashtable.get(6));
    }
}
