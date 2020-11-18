/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Praktikum2 {
    public static void main(String[] args) {
        GeneratorThread th0 = new GeneratorThread("Thread-0", 10, 100);
        GeneratorThread th1 = new GeneratorThread("Thread-1", 10, 100);
        th0.run();
        th1.run();
    }
}

class Generator {

     private int low, high;

     public Generator(int low, int high) {
         this.low = low;
         this.high = high;
     }

     public synchronized void generateRandomNumber(String name) {
         Random r = new Random();
         for (int i = 0; i < 10; i++) {
             int result = r.nextInt(high - low) + low;
             System.out.println(name + ": " + result);
             try {
                 Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

}
class GeneratorThread implements Runnable{
    private String name;
    private int low, high;

    public GeneratorThread(String name, int low, int high) {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        Generator gen = new Generator(low, high);
        gen.generateRandomNumber(name);
    }
    
}
