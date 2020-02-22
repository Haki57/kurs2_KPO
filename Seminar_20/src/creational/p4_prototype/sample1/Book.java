package creational.p4_prototype.sample1;

/**
 * Concrete product
 */
public class Book extends Product {

    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int i) {
        numberOfPages = i;
    }
}
