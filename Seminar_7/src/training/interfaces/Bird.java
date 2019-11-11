package training.interfaces;

// мусорщик (падальщик?)
interface Scavenger{}

class Bird{}

// попугай
class Parrot extends Bird{}

// стервятник
class Vulture extends Bird implements Scavenger{}

class BirdSanctuary {
    public static void main(String args[]) {
        Bird bird = new Bird();
        Parrot parrot = new Parrot();
        Vulture vulture = new Vulture();

//         Vulture vulture2 = (Vulture)parrot;
         Parrot parrot2 = (Parrot)bird;
         Scavenger sc = (Scavenger)vulture;
         Scavenger sc2 = (Scavenger)bird;
    }
}
