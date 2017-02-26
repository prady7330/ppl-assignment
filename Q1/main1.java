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
public class main1 {
    public static void main(String args[]) throws IOException{
        PrintWriter writer = new PrintWriter("event.txt");
        writer.print("");
        writer.close();
        PrintWriter writer1 = new PrintWriter("boys.csv");
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter("girls.csv");
        writer2.print("");
        writer2.close();
        ArrayList<boy> boys=new ArrayList<boy>();
        ArrayList<girl> girls=new ArrayList<girl>();
        ques_1_algo obj=new ques_1_algo();
        ArrayList<couple> couples=obj.simple_algo(boys, girls);
        obj.printC(couples);
    }
}
