/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arga
 */

class ThreadOne implements Runnable {

     private final String name;

     public ThreadOne(String name) {
         this.name = name;
     }

     @Override
     public void run() {
         for (int i = 0; i < 10; i++) {
             System.out.println(name + ": " + i);
             try {
                 Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

 }

 class ThreadTwo extends Thread {

     @Override
     public void run() {
         for (int i = 0; i < 10; i++) {
             System.out.println(getName() + ": " + i);
             try {
                 sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(ThreadTwo.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

 }

 public class Praktikum1 {
     public static void main(String[] args) {
         Thread t = new Thread(new ThreadOne("Thread Satu"));
         t.start();
         ThreadTwo t2 = new ThreadTwo();
         t2.setName("Thread Dua");
         t2.start();
     }
 }

