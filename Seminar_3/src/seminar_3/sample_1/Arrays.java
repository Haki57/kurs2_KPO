package seminar_3.sample_1;

//TODO: explain the array creation & initialization details...

public class Arrays {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
//         ints = {6,7,8,9,10}; // not allowed here...
        ints = new int[]{1,2,3,4,5}; // it's ok...
        ints = new int[5];
//         ints = new int[5]{1, 2, 3, 4, 5}; // not allowed here...
    }
}
