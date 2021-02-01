package sample;

public class Manager {
    boolean morning;
    boolean mid;
    boolean night;
    int hours = 0;
    String name;


    Manager(boolean morning,boolean mid,boolean night,String name){
       this.morning = morning;
       this.mid = mid;
       this.night = night;
        this.name = name;
    }
}
