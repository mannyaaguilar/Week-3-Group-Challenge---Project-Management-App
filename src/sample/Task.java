package sample;

import java.util.Random;

public class Task {

    public int desPoints;
    public int devPoints;


    public Task(){

        Random randomTask = new Random();
        this.desPoints = randomTask.nextInt(25) + 25;
        this.devPoints = randomTask.nextInt(25) + 25;

    }

    @Override
    public String toString() {
        return "Dev: " + this.devPoints + " Des: " + this.desPoints;
    }
}
