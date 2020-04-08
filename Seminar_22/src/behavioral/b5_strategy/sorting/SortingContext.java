package behavioral.b5_strategy.sorting;

public class SortingContext {

    private SortInterface sorter = null;

    public SortInterface getSorter() {
        return sorter;
    }
    public void setSorter(SortInterface sorter) {
        this.sorter = sorter;
    }

    public void sort(double[] list) {
        sorter.sort(list);
    }

}
