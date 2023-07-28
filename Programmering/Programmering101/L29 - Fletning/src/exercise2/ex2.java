package exercise2;

public class ex2 {
    /**
     * Return a sorted array containing all elements
     * shared by l1 and l2.
     * The returned array must have no empty entries.
     * Pre: l1 and l2 are sorted and have no empty entries.
     */
    public static int[] sharedNumbers(int[] l1, int[] l2) {
        int[] result = new int[l1.length + l2.length];
        // flet sålænge der er noget i begge lister
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < l1.length && i2 < l2.length) {
            // Hvis l1 = l2, tilføj l1 i nyt array
            if (l1[i1] == l2[i2]) {
                result[j] = l1[i1];
                i1++;
                j++;
            } else {
                if (l1[i1] < l2[i2]) {
                    i1++;
                } else {
                    i2++;
                }
            }
        }
        return result;
    }
}



