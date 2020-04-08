package behavioral.b5_strategy.sorting;

public class BubbleSort implements SortInterface {

    public void sort(double[] list) {
        System.out.println("BubbleSort...");
        //Bubble sort algorithm here

        int j;
        boolean flag = true;   // set flag to true to begin first pass
        double temp;   //holding variable

        while ( flag ) {
            flag = false;    //set flag to false awaiting a possible swap
            for( j = 0;  j < list.length - 1;  j++ ){
                if ( list[ j ] > list[j+1] ){   // change to < for descending sort
                    temp = list[ j ];                //swap elements
                    list[ j ] = list[ j+1 ];
                    list[ j+1 ] = temp;
                    flag = true;              //shows a swap occurred
                }
            }
        }
    }
}
