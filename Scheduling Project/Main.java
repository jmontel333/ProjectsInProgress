// Author Jesse Montel
// January 2021
// Scheduling application

//currently adding manager generation onto the grid off the button press once I get that to work should look to do everything off of lists
//look up how to make it scroll once too large instead of just being off screen


package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
       //main scene elements
       Parent root = FXMLLoader.load(getClass().getResource("../DunkinGui.fxml"));
       Button scheduleButton = (Button) root.lookup("#scheduleButton");
       scheduleButton.setStyle("-fx-background-color: #E11383");
       Button editButton = (Button) root.lookup("#editButton");
       editButton.setStyle("-fx-background-color: #F5821F");
       primaryStage.setTitle("Dunkin schedule app");

       //weekGrid elements
       Parent weekGrid = FXMLLoader.load(getClass().getResource("WeekScheduleDisplay.fxml"));
       Button returnHomeButton = (Button) weekGrid.lookup("#homeButton");
       // implement eventually--Label DateLabel
       // use an array of jobs to fill all the days eventually once allowing for job and shift creation
       Label ManagerSun = (Label) weekGrid.lookup("#ManagerSun");
       Label ManagerMon = (Label) weekGrid.lookup("#ManagerMon");
       Label ManagerTue = (Label) weekGrid.lookup("#ManagerTue");
       Label ManagerWed = (Label) weekGrid.lookup("#ManagerWed");
       Label ManagerThur = (Label) weekGrid.lookup("#ManagerThur");
       Label ManagerFri = (Label) weekGrid.lookup("#ManagerFri");
       Label ManagerSat = (Label) weekGrid.lookup("#ManagerSat");

       //creating scenes
       Scene primary = new Scene(root,700,400);
       Scene weekGridScene = new Scene(weekGrid, 900, 400);

       primaryStage.setScene(primary);
       primaryStage.show();

       //setting up fake employees for testing
       int numberOfEmployees = 500;
       int numberOfManagers = 500;
       int managerSize;
       Random rand = new Random();
       int employeeSize;
       //add auto population of the lists
       //make copy of list for each day and remove from list once assigned a singular time
       Employee[] employees = new Employee[numberOfEmployees];
       Manager[] managers = new Manager[numberOfManagers];
       //testing section
       Manager morning1 = new Manager(true, false, false, "morning 1");
       Manager morning2 = new Manager(true, false, false, "morning 2");
       Manager mid1 = new Manager(false, true, false, "mid 1");
       Manager mid2 = new Manager(false, true, false, "mid 2");
       Manager night1 = new Manager(false, false, true, "night 1");
       Manager night2 = new Manager(false, false, true, "night 2");
       managers[0] = morning1;
       managers[1] = morning2;
       managers[2] = mid1;
       managers[3] = mid2;
       managers[4] = night1;
       managers[5] = night2;
       managerSize = 6;
       Employee morningSandwhich = new Employee(true, false, false, true, false, false, false, false, false, "MorningSandwhich");
       Employee morningInitiator = new Employee(true, false, false, false, true, false, false, false, false, "Morninginitiator");
       Employee morningFrontCount = new Employee(true, false, false, false, false, true, false, false, false, "Morningfrontcount");
       Employee morningDriveThru = new Employee(true, false, false, false, false, false, true, false, false, "Morningdrivethru");
       Employee morningDrinks = new Employee(true, false, false, false, false, false, false, true, false, "Morningdrinks");
       Employee morningThruTaker = new Employee(true, false, false, false, false, false, false, false, true, "MorningThruTaker");
       Employee midSandwhiches = new Employee(false, true, false, true, false, false, false, false, false, "MidSandwhich");
       Employee midDrinks = new Employee(false, true, false, false, false, false, false, true, false, "MidSandwhich");
       Employee midDriveThruCash = new Employee(false, true, false, false, false, false, true, false, false, "MidDriveThruCash");
       Employee midFrontCount = new Employee(false, true, false, false, false, true, false, false, false, "Midfront");
       Employee midInnit = new Employee(false, true, false, false, true, false, false, false, false, "Midinnit");
       Employee midDriveThruTaker = new Employee(false, true, false, false, false, false, false, false, true, "MidDrivethruOrder");
       Employee nightInnt = new Employee(false, false, true, false, true, false, false, false, false, "NightInnit");
       Employee nightDriveThrutaker = new Employee(false, false, true, false, false, false, false, false, true, "NightDriveThru");
       employees[0] = morningSandwhich;
       employees[1] = morningInitiator;
       employees[2] = morningFrontCount;
       employees[3] = morningDriveThru;
       employees[4] = morningDrinks;
       employees[5] = morningThruTaker;
       employees[6] = midSandwhiches;
       employees[7] = midDriveThruCash;
       employees[8] = midFrontCount;
       employees[9] = midInnit;
       employees[10] = midDrinks;
       employees[11] = midDriveThruTaker;
       employees[12] = nightInnt;
       employees[13] = nightDriveThrutaker;
       employeeSize = 14;

       //will generate schedule just swaps scenes for now
       scheduleButton.setOnAction(actionEvent -> {
           int dayOfWeek = 0;
           //morning
           int randInt;
           do {
               randInt = rand.nextInt(managerSize);

           } while (!(managers[randInt].morning));//end while
           System.out.println("morning manager (4am-12noon) = " + managers[randInt].name);

           //sandwich
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].sandwiches);
           System.out.println("morning sandwich (5am-1pm) = " + employees[randInt].name);

           //initiator
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].initiator);
           System.out.println("morning initiator (5am-1pm) = " + employees[randInt].name);

           //front counter
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].frontCounter);
           System.out.println("morning front counter = " + employees[randInt].name);

           //drive thru
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].driveThru);
           System.out.println("morning drive thru cashier (7am-3pm) = " + employees[randInt].name);

           //drinks
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].drinks);
           System.out.println("morning drinks (8am-4pm) = " + employees[randInt].name);

           //drive thru order taker
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].morning) || !employees[randInt].driveThruOrderTaker);
           System.out.println("morning drive thru order taker (6am-2pm) = " + employees[randInt].name);

//-----------------------------------------------------------------------------------------------------------

           //midday
           do {
               randInt = rand.nextInt(managerSize);

           } while (!(managers[randInt].mid));//end while
           System.out.println("mid-Shift manager (9am-5pm) = " + managers[randInt].name);

           //drinks
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].drinks);
           System.out.println("mid drinks (1pm-8pm) = " + employees[randInt].name);

           //sandwiches
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].sandwiches);
           System.out.println("mid sandwich (1pm-8pm) = " + employees[randInt].name);

           //drive thru
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].driveThru);
           System.out.println("mid drive thru cash (3pm-10pm) = " + employees[randInt].name);

           //drive thru order taker
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].driveThruOrderTaker);
           System.out.println("mid drive thru order taker (10am-4pm) = " + employees[randInt].name);

           //front counter
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].frontCounter);
           System.out.println("mid front counter = " + employees[randInt].name);

           //initiator
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].initiator);
           System.out.println("mid initiator (11am-5pm) = " + employees[randInt].name);

           //front counter
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].mid) || !employees[randInt].frontCounter);
           System.out.println("mid initiator (11am-5pm) = " + employees[randInt].name);

//-----------------------------------------------------------------------------------------------------------------------
           //night
           do {
               randInt = rand.nextInt(managerSize);

           } while (!(managers[randInt].night));//end while
           System.out.println("night manager (3pm-close) = " + managers[randInt].name);

           //initiator
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].night) || !employees[randInt].initiator);
           System.out.println("night initiator (4pm-11pm) = " + employees[randInt].name);

           //drive thru order taker
           do {
               randInt = rand.nextInt(employeeSize);

           } while (!(employees[randInt].night) || !employees[randInt].driveThruOrderTaker);
           System.out.println("night drive thru order taker (4pm-11pm) = " + employees[randInt].name);


           //end testing
        primaryStage.setScene(weekGridScene);
       });

       //returns to home from weekGrid scene
       returnHomeButton.setOnAction(actionEvent -> {
           primaryStage.setScene(primary);
       });





   }
    public static void main(String[] args) {
            launch(args);
        }
}
