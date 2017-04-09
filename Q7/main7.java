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
public class main7 {
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
        ArrayList<boy> boys=new ArrayList<boy>();//creating list for boys
        ArrayList<girl> girls=new ArrayList<girl>();//creating list for girls
        ArrayList<couple> couples=new ArrayList<couple>();//creating list for couple
        ques3_algo q3=new ques3_algo();//creating object to deploy algorithm to this question
        ques7_algo q7=new ques7_algo();//creating object to deploy algorithm to this question
        boys=q3.generate_boys();//generating boys
        girls=q3.generate_girls();//generating girls
        couples=q3.create_couples(boys, girls);//creating couples from the list of boys and girls
        System.out.println("do you want to make a choice for searching girlfriends?");//giving choice to the select method for this question
        char a;
        int c;
        int flag=0;
        Scanner sc=new Scanner(System.in);
        a = sc.next().charAt(0);
        if(a=='y' || a=='Y'){
            System.out.println("1.using couples?");//search using couples arraylist/array
            System.out.println("2.using sorted array?");//search usign sorted array
            System.out.println("3.using hash tables?");//search using hash tables;
            System.out.println("enter your choice");//getting the choice from the user
            c=sc.nextInt();
            if(c==1)
                flag=1;
            if(c==2)
                flag=2;
            if(c==3)
                flag=3;
        }
        if(flag==0)
            q7.use_couples(boys, couples);//search using arraylist/arrays-->default choice
        else{
            if(flag==1)
                q7.use_couples(boys, couples);//search using arraylist/arrays
            if(flag==2)
                q7.use_sorted_array(boys, couples);//search using sorted array(binary search)
            if(flag==3)
                q7.use_hash(boys, couples);//search using hash-tables
        }
    }
}
