package structural.p4_flyweight.demo3_coffeeflavor;


public class CoffeeOrderContext {

    private int tableNumber;

    public CoffeeOrderContext(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTable() {
        return this.tableNumber;
    }
}
