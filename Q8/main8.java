/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pradeep
 */
public class main8 {
    public static void main(String args[]) throws IOException{
        PrintWriter writer = new PrintWriter("event3.txt");//to write into the event file registering the events happening through out the program
        writer.print("");
        writer.close();
        PrintWriter writer1 = new PrintWriter("boys3.csv");//to write the record of all the boys
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls3.csv");//to write the record of all the girls
        writer2.print("");
        writer2.close();
        ArrayList<boy> boys=new ArrayList<boy>();//creating boys
        ArrayList<girl> girls=new ArrayList<girl>();//creating girls
        ArrayList<couple> couples=new ArrayList<couple>();//creating couples on the basis of given condition
        ArrayList<gift> gifts=new ArrayList<gift>();//creating gifts
        ques3_algo q3=new ques3_algo();//creating object to apply algo
        boys=q3.generate_boys();//generating random boys
        girls=q3.generate_girls();//generating random girls
        couples=q3.create_couples(boys, girls);//generating couples
        gifts=q3.generate_gifts();//generating gifts of all types
        ques8_algo q8=new ques8_algo();//creating object to apply the distribution algorithm
        System.out.println("1.gifting strategy 1?");//asking user to select the 1st gifting algo
        System.out.println("2.gifting strategy 2?");//asking user to select the 2nd gifting algo
        System.out.println("choose the option");//asking user to provide input for gifting algo
        int a;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        if(a==1){
            couples=q8.dist_gift(couples, gifts, boys);//gifting algo accroding to 1st condtion
        }
        if(a==2){
            couples=q8.dist_gift2(couples, gifts, boys, girls);//gifting algo according to 2nd condition
        }
        int i=0;
        for(couple c:couples)
            System.out.println("total gifts of a couple "+(++i)+" -"+c.get_gift().size());
        
    }
}
