package behavioral.b3_chain_of_responsibility.sample_ATM;

/**
 */
public class Currency {

    final private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }
    public int getAmount(){
        return this.amount;
    }
}