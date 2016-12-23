/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Debugger {
    
    
    public static void consolePrint(String error){
        System.out.print(error);
    }
    public static void consolePrintln(String error){
        System.out.println(error);
    }
    
    public static void logException(String className, Exception ex){
        System.out.println("Exception from CLASS : " + className);
        System.out.println(ex.toString());
        Logger.getLogger(className).log(Level.SEVERE, null, ex);
    }
    
    public static void printQuery(String className, String function, String query){
        System.out.println("\n\n--------------------------Query To Be Fired-----------------------------");
        System.out.println("Class : " + className + ", Function : " +function);
        System.out.println("Query : " + query);
        System.out.println("------------------------------------------------------------------------\n\n");
    }
}
