/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pradeep
 */
public class ques5_algo {
    public ArrayList<couple> create_couples(ArrayList<boy> boys,ArrayList<girl> girls) throws IOException{
       ArrayList<couple> couples =new ArrayList<couple>();
       int flag=0;
       int i=0;
       int j=0;
       while(flag==0){
           girl g=girls.get(i);
           i++;
           for(boy b:boys){
               if(b.get_budget()>g.get_main_budget() && b.get_att()<g.get_att() && g.get_status()==0 && b.get_status()==0){
                   couple c=new couple();
                   c.set_name(b.get_name(), g.get_name());
                   b.set_status(1);
                   g.set_status(1);
                   couples.add(c);
                   write_file3.write_to_file(g.get_name()+" gets commited to "+b.get_name());
               }
           }
           boy b=boys.get(j);
           j++;
           for(girl gi:girls){
               if(b.get_budget()>g.get_main_budget() && b.get_att()<g.get_att() && g.get_status()==0 && b.get_status()==0){
                   couple c=new couple();
                   c.set_name(b.get_name(), g.get_name());
                   b.set_status(1);
                   g.set_status(1);
                   couples.add(c);
                   write_file3.write_to_file(g.get_name()+" gets commited to "+b.get_name());
               }
           }
           if(i==girls.size() || j==boys.size())
               flag=1;
       }
       return couples; 
    }
}
