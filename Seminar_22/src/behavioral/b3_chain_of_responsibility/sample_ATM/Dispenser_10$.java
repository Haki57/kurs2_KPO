package behavioral.b3_chain_of_responsibility.sample_ATM;

/**
 */
public class Dispenser_10$ implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            if(remainder !=0)
                this.chain.dispense(new Currency(remainder));
        }else{
            if (chain != null)
                chain.dispense(cur);
        }
    }
}
