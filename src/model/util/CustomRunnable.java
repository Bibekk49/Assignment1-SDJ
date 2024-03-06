package model.util;

public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        // Code to be executed in the separate thread
        System.out.println("Thread is running!");
    }
}