/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Pradeep
 */
public class write_boys3 {
    public static void write_to_boys(String str) throws IOException{
        try(FileWriter fw = new FileWriter("boys3.csv", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
        {
            out.println(str);
        }
   }
}
