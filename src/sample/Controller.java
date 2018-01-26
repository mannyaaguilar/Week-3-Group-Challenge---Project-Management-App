package sample;


import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable{


    //Creates a task, from the "Task" class in the "model" folder
    Task task = new Task();

    //Creates a list to store all the employees we create
    ArrayList<Worker> employeeList = new ArrayList<>();

    //Override because we are implementing the Initializable class
    //This 'fires off' when the application loads.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Task Hours: " + task);

        boolean ask = true;

        //Keep asking if we want another employee
        while(ask){
            //Go create a worker
            createWorker();

            //---OLD CODE---
            //Go check the total points of ALL the workers.
            //int totalAbility = compareWork();
            //int compare = (int)Math.ceil(task.points/totalAbility);
            //System.out.println("Here is how many weeks: " + compare);
            //---------------

            //The checkForPoints method will return true or false,
            //This checks to see if we only have developers or designers.
            //If we have al of one type, we need to keep creating workers
            //until we have at least one of each type of worker
            if(checkForPoints()){

                System.out.println("Number of people " + employeeList.size());

                //Total up the points of each WorkerType
                //so that we can 'math' on it
                int devPoints = totalPointsPerTaskType(WorkerType.DEVELOPER);
                int desPoints = totalPointsPerTaskType(WorkerType.DESIGNER);

                //See how ong it takes to complete the tasks
                int compareProjectDev = task.devPoints/devPoints;
                int compareProjectDes = task.desPoints/desPoints;


                int whichIsHigher = 0;

                //Of the two, find the task that will take longer to complete
                //That will be how long it takes to complete the project
                if(compareProjectDev > compareProjectDes){
                whichIsHigher = compareProjectDev;
                }else {
                    whichIsHigher = compareProjectDes;
                }

                System.out.println("Your project will take this long: " + whichIsHigher + " week(s)");

                //Ask the user if they want to go again
                Scanner sc = new Scanner(System.in);
                System.out.println("Do you want another worker? 'Y' to confirm:");
                String userResponse = sc.nextLine();

                if(userResponse.equalsIgnoreCase("Y")){
                    ask=true;
                    }else{
                    ask=false;}

            }

        }
    }

        //Returns an int that is the total number of points that can be completed
        //by Task type (Designer, Developer, etc.)
        public int totalPointsPerTaskType(WorkerType workerType){
        int totalPoints = 0;

        for(Worker worker : employeeList){
            if(worker.workerType.equals(workerType)){
                totalPoints += worker.ability;
            }
        }
        return totalPoints;
        }
        //Check to make sure that we have an employee of each type (Designer, Developer)
        public boolean checkForPoints(){
        boolean haveEnoughPoints = false;

        int desPoints = 0;
        int devPoints = 0;

        for(Worker worker : employeeList){
            if(worker.workerType.equals((WorkerType.DESIGNER))){
                desPoints += worker.ability;
            }
            if(worker.workerType.equals((WorkerType.DEVELOPER))){
                devPoints += worker.ability;
            }
        }

        if(desPoints > 0 && devPoints > 0){
            haveEnoughPoints = true;
        }
        return haveEnoughPoints;
        }




        //Adds up all the worker ability points. Probably should rename this method.
        //Poorly named.
    // public int compareWork(){
    //
    //Start the counter at zero.
    // int abilityTotal = 0;
    //
    //For each loop that 'goes each time' one time for each employee.
    //Each pass through, we have access to the object 'worker'.
    // for(Worker worker : employeeList){
        //abiityTotal += worker.ability;

    // }
    //Send back the int.
    //return abilityTotal;
    //}

    //Makes a worker

    public void createWorker(){
        Worker newWorker = new Worker();
        employeeList.add(newWorker);
        System.out.println("New worker ability: " + newWorker.ability + " - " + newWorker.workerType);
    }
}

