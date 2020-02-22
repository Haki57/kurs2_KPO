package creational.p3_builder;

//TODO: note that the term 'builder' may be used with the different sense; e.g. StringBuilder, any immutable object builder, etc...

public abstract class HouseBuilder {
    protected House house;
    protected Floor floor;
    protected Walls walls;
    protected Roof roof;

    public abstract House createHouse();
    public abstract Floor createFloor();
    public abstract Walls createWalls();
    public abstract Roof createRoof();
}

class WoodBuilder extends HouseBuilder {

    public Floor createFloor() {
        floor = new WoodFloor();
        return floor;
    }
    public House createHouse() {
        house = new WoodHouse();
        return house;
    }
    public Roof createRoof() {
        roof = new WoodRoof();
        return roof;
    }
    public Walls createWalls() {
        walls = new WoodWalls();
        return walls;
    }
}

class BrickBuilder extends HouseBuilder {
    @Override
    public House createHouse() {
        return new BrickHouse();
    }

    @Override
    public Floor createFloor() {
        return new BrickFloor();
    }

    @Override
    public Walls createWalls() {
        return new BrickWalls();
    }

    @Override
    public Roof createRoof() {
        return new BrickRoof();
    }
//similar to WoodBuilder
}

class HouseDirector {

    public House construcHouse(HouseBuilder builder) {
        House house = builder.createHouse();
        System.out.println(house.getRepresentation());
        house.setFloor(builder.createFloor());
        System.out.println(house.getFloor().getRepresentation());
        house.setWalls(builder.createWalls());
        System.out.println(house.getWalls().getRepresentation());
        house.setRoof(builder.createRoof());
        System.out.println(house.getRoof().getRepresentation());
        return house;
    }
}

abstract class House {

    protected Floor floor;
    protected Walls walls;
    protected Roof roof;

    public Floor getFloor() {
        return floor;
    }
    public void setFloor(Floor floor) {
        this.floor = floor;
    }
    public Walls getWalls() {
        return walls;
    }
    public void setWalls(Walls walls) {
        this.walls = walls;
    }
    public Roof getRoof() {
        return roof;
    }
    public void setRoof(Roof roof) {
        this.roof = roof;
    }
    public abstract String getRepresentation();
}

interface Floor {
    public String getRepresentation();
}

interface Walls {
    public String getRepresentation();
}

interface Roof {
    public String getRepresentation();
}

class WoodHouse extends House {
    public String getRepresentation() {
        return "Building a wood house";
    }
}

class WoodFloor implements Floor {
    public String getRepresentation() {
        return "Finished building wood floor";
    }
}

class WoodWalls implements Walls {
//similar to WoodFloor
    public String getRepresentation() {
        return "Finished building wood walls";
    }
}

class WoodRoof implements Roof {
//similar to WoodFloor
    public String getRepresentation() {
        return "Finished building wood roof";
    }
}

// Similar structure for Brick family
class BrickHouse extends House {
    public String getRepresentation() {
        return "brick_house";
    }

}

class BrickFloor implements Floor {
    public String getRepresentation() {
        return "brick_floor";
    }

}

class BrickWalls implements Walls {
    public String getRepresentation() {
        return "brick_walls";
    }

}

class BrickRoof implements Roof {
    public String getRepresentation() {
        return "brick_roof";
    }

}

class HouseClient {

    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();
        HouseBuilder woodBuilder = new WoodBuilder();
        BrickBuilder brickBuilder = new BrickBuilder();
// Build a wooden house
        House woodHouse = director.construcHouse(woodBuilder);
        System.out.println();
// Build a brick house
        House brickHouse = director.construcHouse(brickBuilder);
    }
}