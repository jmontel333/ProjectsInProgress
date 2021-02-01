package sample;

public class Employee {
    boolean morning;
    boolean mid;
    boolean night;
    boolean sandwiches;
    boolean initiator;
    boolean frontCounter;
    boolean driveThru;
    boolean drinks;
    boolean driveThruOrderTaker;
    int hours = 0;
    String name;


    Employee(boolean morning, boolean mid, boolean night, boolean sandwiches, boolean initiator, boolean frontCounter, boolean driveThru, boolean drinks, boolean driveThruOrderTaker,String name){
        this.sandwiches = sandwiches;
        this.initiator = initiator;
        this.frontCounter = frontCounter;
        this.driveThru = driveThru;
        this.drinks = drinks;
        this.driveThruOrderTaker = driveThruOrderTaker;
        this.name = name;
        this.morning = morning;
        this.night = night;
        this.mid = mid;
    }
}
