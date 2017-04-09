/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Pradeep
 */
public class main10 {
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
        ArrayList<boy> boys=new ArrayList<boy>();//creating boys list
        ArrayList<girl> girls=new ArrayList<girl>();//creating girls list
        ArrayList<couple> couples=new ArrayList<couple>();//creating couples list to store couples form
        ArrayList<gift> gifts=new ArrayList<gift>();//creating gifts list to store gifts in a basket
        ques3_algo q3=new ques3_algo();//creating object to deploy algo
        boys=q3.generate_boys();//generating boys
        girls=q3.generate_girls();//generating girls
        gifts=q3.generate_gifts();//generating girls
        ques10_algo q10=new ques10_algo();//creating object of annother class to deploy the algo residing in the other class
        couples=q10.create_couple(boys, girls);//creating couples on the basis of random selection from the boys
        couples=q10.dist_gift(couples, boys, girls, gifts);//distributing gfts among the girls from random selection of giffts
        int i=0;
        for(couple c:couples)
            System.out.println("total gift in this couple"+(++i)+"- "+c.get_gift().size());
    }
}
