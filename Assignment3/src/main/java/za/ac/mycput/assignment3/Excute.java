/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.mycput.assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author jodia
 */
public class Excute {
    

   
    public static void main(String[] args) {
        Storage obj = new Storage();
         obj.readSer();
         obj.CreateFile();
    }
    
}
