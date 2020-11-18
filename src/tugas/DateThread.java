/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arga
 */
public class DateThread extends Thread{
    private final TimeUI view;
    private boolean isPaused = false;
    
    //object for pause syncronization
    private Object objLock = new Object();

    public DateThread(TimeUI view) {
        this.view = view;
    }
    
    
    @Override
    public void run(){
        try {
            while (true) {
                if(isPaused){
                    synchronized(objLock){
                        objLock.wait();
                    }
                }
                SimpleDateFormat dateformat = new SimpleDateFormat("E, dd MMMM yyyy");
                SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");
                view.getTxtDate().setText(dateformat.format(new Date()));
                view.getTxtTime().setText(timeformat.format(new Date()));
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DateThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void pauseThread(){
        isPaused = true;
    }
    public void resumeThread(){
        synchronized(objLock){
            isPaused = false;
            objLock.notifyAll();
        }
    }
    
}
