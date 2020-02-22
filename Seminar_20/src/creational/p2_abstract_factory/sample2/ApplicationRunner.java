package creational.p2_abstract_factory.sample2;

interface GUIFactory {
    public Button createButton();
}

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
}

class OSXFactory implements GUIFactory {
    public Button createButton() {
        return new OSXButton();
    }
}

interface Button {
    public void paint();
}

class WinButton implements Button {
    public void paint() {
        System.out.println("I'm a WinButton");
    }
}

class OSXButton implements Button {
    public void paint() {
        System.out.println("I'm an OSXButton");
    }
}

class Application {
    public Application(GUIFactory factory) {
        Button button = factory.createButton();
        button.paint();
    }
}

public class ApplicationRunner {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: args[0] - OS-name (e.g. OSX or Windows)");
            System.exit(0);
        }

        new Application(createOsSpecificFactory(args[0]));
    }
    public static GUIFactory createOsSpecificFactory(String s) {
//        int sys = readFromConfigFile("OS_TYPE");
        int sys = (s.equalsIgnoreCase("OSX"))? 1 : 0;
        if (sys == 0)
            return new WinFactory();
        else
            return new OSXFactory();
    }
}