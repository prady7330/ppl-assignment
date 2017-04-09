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
public class main9 {

    public static void main(String args[]) throws IOException {
        PrintWriter writer = new PrintWriter("event3.txt");//to write into the event file registering the events happening through out the program
        writer.print("");
        writer.close();
        PrintWriter writer1 = new PrintWriter("boys3.csv");//to write the record of all the boys
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls3.csv");//to write the record of all the girls
        writer2.print("");
        writer2.close();
        ArrayList<boy> boys = new ArrayList<boy>();//creating boys
        ArrayList<girl> girls = new ArrayList<girl>();//creating girls
        ArrayList<gift> gifts = new ArrayList<gift>();//creating gifts
        ArrayList<couple> couples = new ArrayList<couple>();//creating couples
        ques3_algo q3 = new ques3_algo();//creating objects of the other class to deploy the algo
        boys = q3.generate_boys();//generating boys
        girls = q3.generate_girls();//generationg girls
        ques9_algo q9 = new ques9_algo();//creating objects of other class to deploy the algo
        couples = q9.create_couple(boys, girls);//creating couples on the new technique
        gifts = q3.generate_gifts();//generating gifts
        couples = q9.dist_gift(couples, boys, girls, gifts);//distributing gifts
        couples = q9.happi(couples, boys, girls);//calculating happiness of the couples
        ArrayList<couple> best_couple = q9.give_best(5, couples);//taking out best 5 couples on the basis of happiness
        System.out.println("best couples:-");
        for (couple c : best_couple)//printing the besr 5 couples from the list.
        {
            System.out.println(c.get_b_name() + "--" + c.get_g_name());
        }
    }
}
