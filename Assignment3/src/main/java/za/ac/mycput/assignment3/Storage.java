/*
 * Jodi Abrahams(217154646)
 * Date: 2021.06.09
 * Assignment 3
 */
package za.ac.mycput.assignment3;



import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Storage extends Excute{
    int temp = 0;
Customer cust = new Customer();

//creating ArrayLists
ArrayList<Customer> custList = new ArrayList<Customer>();
   ArrayList<Supplier> suppList = new ArrayList<Supplier>();
   
  //Reading the .ser file
    public void readSer() {
        System.out.println("Reading Customer...");
       
try{
    String fileName = "stakeholder.ser";
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
    
    Customer cust1 = (Customer)in.readObject();
    Supplier supp1 =(Supplier)in.readObject();
    Customer cust2 = (Customer)in.readObject();
    Supplier supp2 =(Supplier)in.readObject();
    Supplier supp3 =(Supplier)in.readObject();
    Customer cust3 = (Customer)in.readObject();
    Customer cust4 = (Customer)in.readObject();
    Supplier supp4 =(Supplier)in.readObject();
    Supplier supp5 =(Supplier)in.readObject();
    Customer cust5 = (Customer)in.readObject();
    Customer cust6 = (Customer)in.readObject();
    
    custList.add(cust1);
    custList.add(cust2);
    custList.add(cust3);
    custList.add(cust4);
    custList.add(cust5);
    custList.add(cust6);
    
    suppList.add(supp1);
    suppList.add(supp2);
    suppList.add(supp3);
    suppList.add(supp4);
    suppList.add(supp5);
    
  
    //Using for loop to print out the customer list
     System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=Customer List+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("");
        System.out.println("ID      First Name     Surname     Address     Date of Birth       Credit can Rent");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
    for (int i = 0; i < custList.size(); i++) {
       
        System.out.println(custList.get(i));
        
    }
     System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=Supplier List+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("");
        System.out.println("ID     Name         Product Type      Description");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
    for (int i = 0; i < suppList.size(); i++) {
       
        System.out.println("");
        System.out.println(suppList.get(i));
        
    }
    
    
  
   
    System.out.println();
    
    in.close();
}catch(IOException ioe){
    System.out.println("error opening" + ioe.getMessage());;
}catch (ClassNotFoundException ex){
    ex.printStackTrace();}
    
    

        System.out.println("Successful");
        
        }
    
    //sorting the Array Ascending order
    public void SortArray() {
         
        String [] sortCust = new String [custList.size()];
        ArrayList<Customer> Array = new ArrayList<Customer>();
        int length = custList.size();
        for (int i = 0; i < length; i++) {
            sortCust[i] = custList.get(i).getStHolderId();
            
        }
        Arrays.sort(sortCust);
        for (int j = 0; j < length; j++) {
            for (int a = 0; a < length; a++) {
                if (sortCust[a].equals(custList.get(a).getStHolderId())) {
                    Array.add(custList.get(a));
                    
                }
                
            }
            
        }
        custList.clear();
        custList  = Array;
    }
 /*   public void Count(){
        for (int i = 0; i < custList.size(); i++) {
            if(Customer(canRent) =! false)
                System.out.println("Customers that can rent: " + i);
            
        }
    }*/
    
    //Creating a txt file for Customer List
    public void CreateFile() {
 File file = new File("CustomerOutFile.txt");
 
 try{
     FileWriter fw = new FileWriter(file);
     PrintWriter pw = new PrintWriter(fw);
     pw.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=Customer List+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
     pw.println("First Name     Surname     Address     Date of Birth       Credit can Rent");
     pw.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
             FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             Writer out1 = new BufferedWriter(fw);
     
 
 oos.writeObject(custList);
 
 out1.close();
    pw.close();
    
     System.out.println("Customer Printed successfully");
    }
 catch (IOException e){
 e.printStackTrace();
 }
 }
     public String formatDoB(Customer dob){
       LocalDate dateOfBirthToFormat = LocalDate.parse(dob.getDateOfBirth());
       DateTimeFormatter changeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
       return dateOfBirthToFormat.format(changeFormat);
   }
    
     //Creating txt file for Supplier List
    public void CreateFileSupp() {
 File file = new File("SupplierOutFile.txt");
 
 try{
     FileWriter fw = new FileWriter(file);
     PrintWriter pw = new PrintWriter(fw);
     pw.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=Supplier List+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
     pw.println("ID        Name                     Product Type            Description");
     pw.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
             FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             BufferedWriter out1 = new BufferedWriter(fw);
     
 
 oos.writeObject(suppList);
 
 out1.close();
    pw.close();
    
     System.out.println("Supplier Printed successfully");
    }
 catch (IOException e){
 e.printStackTrace();
 }
 }
}
   

  
    
    

