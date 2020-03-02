package structural.p4_flyweight.demo2_gazillion;

public class FlyweightFactory {

    private Gazillion2[] pool;

    public FlyweightFactory( int maxRows ) {
        pool = new Gazillion2[maxRows];
    }

    public Gazillion2 getFlyweight( int theRow ) {
        if (pool[theRow] == null)
            pool[theRow] = new Gazillion2( theRow );
        return pool[theRow];
    }
}
