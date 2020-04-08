package behavioral.b3_chain_of_responsibility.sample_ATM;

import java.util.Scanner;

/**
 * TODO: note- how could we refactor our Dispensers implementation to avoid some code duplications?
 * Just do that! What design pattern could be used for the refactoring?
 */

public class ATMDispenserChain {

    private DispenseChain c1;

    public ATMDispenserChain() {
// initialize the chain TODO: note - why we do the chain in that given order?
        this.c1 = new Dispenser_50$();
        DispenseChain c2 = new Dispenser_20$();
        DispenseChain c3 = new Dispenser_10$();
// set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenserChain atmDispenser = new ATMDispenserChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            try {
                amount = input.nextInt();
                if (amount % 10 != 0) {
                    System.out.println("Amount should be in multiple of 10s.");
                    continue;
                }
                // process the request:
                atmDispenser.c1.dispense(new Currency(amount));
            } catch (Exception ex){
                System.out.println("finish of the demo...");
                return;
            }
        }
    }
}
