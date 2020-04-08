package behavioral.b3_chain_of_responsibility.sample_ATM;

/**
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}
