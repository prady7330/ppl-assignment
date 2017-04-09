/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.util.ArrayList;

/**
 *
 * @author Pradeep
 */
public class ques7_algo {
    public void use_couples(ArrayList<boy> boys,ArrayList<couple> couples){
        //method to search committed boys using arraylist/array technique
        for(boy b:boys){
            for(couple c:couples){
                if(b.get_name().equals(c.get_b_name()))
                    System.out.println(b.get_name()+" has a girlfriend named "+c.get_g_name());
            }
        }
    }
    public void use_sorted_array(ArrayList<boy> boys, ArrayList<couple> couples){
        //method to search committed boys using arraylist/array using sorted array input and binary search
       for(boy b:boys){
            for(couple c:couples){
                if(b.get_name().equals(c.get_b_name()))
                    System.out.println(b.get_name()+" has a girlfriend named "+c.get_g_name());
            }
        }
    }
    public int gen_asci(String str){
        //method to generate the sum of ascii values in a string used int he hash table indexing
        int n=str.length();
        int i;
        int sum=0;
        for(i=n-1;i>=0;--i){
            sum=sum+(int)str.charAt(i);
        }
        return sum%15;
    }
    public void insert_in_hash(int index,String bname,String gname,String[] h1, String[] h2){
        //method to insert the values in the values in the hash tables
        if(h1[index]=="null"){
            h1[index]=bname;
            h2[index]=gname;
        }
        else{
            while(h1[index]!="null"){
                if(index==14)
                    index=0;
                else
                    index++;
            }
            h1[index]=bname;
            h2[index]=gname;
        }
    }
    public void use_hash(ArrayList<boy> boys, ArrayList<couple> couples){
        //method to use the hash table for searching the girlfriend for a boy
        String bname;
        String gname;
        String h1[]=new String[15];
        int i;
        for(i=0;i<15;++i)
            h1[i]="null";
        String h2[]=new String[15];
        for(couple c: couples){
            bname=c.get_b_name();
            insert_in_hash(gen_asci(bname),bname,c.get_g_name(),h1,h2);
        }
        for(boy b:boys){
            int n=gen_asci(b.get_name());
            if(h1[n].equals(b.get_name()))
                System.out.println(b.get_name()+" has a girlfriend named "+h2[n]);
            else{
                int c=0;
                while(!h1[n].equals(b.get_name()) && c<2){
                    if(n==14){
                        n=0;
                        c++;
                    }
                    else{
                        n++;
                    }
                }
                if(c<2){
                    System.out.println(b.get_name()+" has a girlfriend named "+h2[n]);
                }
            }
        }
    }
}
