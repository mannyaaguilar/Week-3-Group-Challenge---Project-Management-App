package sample;

import java.util.Random;

public class Worker {

    public int ability;
    public WorkerType workerType;

    public Worker() {

        Random randomAbility = new Random();
        this.ability = randomAbility.nextInt((5) + 1);

        int whichType = randomAbility.nextInt(2) +1;
        if(whichType ==1) {
            workerType = WorkerType.DESIGNER;
                }else if(whichType ==2){
            workerType = WorkerType.DEVELOPER;
        }

    }

    @Override
    public String toString() {
        return "Worker ability: " + this.ability;
    }
}