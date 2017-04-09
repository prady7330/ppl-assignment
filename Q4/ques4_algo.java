/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pradeep
 */
public class ques4_algo {//method to remove the least k happiest couple
    public ArrayList<couple> brk_couples(int k, ArrayList<couple> couples, ArrayList<boy> boys,ArrayList<girl> girls) throws IOException{
        List l=new ArrayList<couple>();
        String bname="";
        String gname="";
        int i;
        for(i=0;i<k;++i){
            for(boy b:boys){
                if(b.get_name().equals(couples.get(i).get_b_name())){
                    //b.set_status(0);
                    bname=b.get_name();
                    break;
                }
            }
            for(girl g:girls){
                if(g.get_name().equals(couples.get(i).get_g_name())){
                    g.set_status(0);
                    gname=g.get_name();
                    break;
                }   
            }
            write_file3.write_to_file(gname+" breaks up with "+bname);
        }
        for(i=0;i<couples.size();++i)
            l.add(couples.get(i));
        l.subList(0, k).clear();
        return (ArrayList<couple>) l;
    }
 public ArrayList<couple> create_new_couples(ArrayList<couple> couples,ArrayList<boy> boys,ArrayList<girl> girls) throws IOException{
     for(girl g:girls){
         for(boy  b:boys){
             if(b.get_budget()>g.get_main_budget() && b.get_min_att_req()<g.get_att() && b.get_status()==0 && g.get_status()==0){
                 couple c =new couple();
                 c.set_name(b.get_name(), g.get_name());
                 b.set_status(1);
                 g.set_status(1);
                 couples.add(c);
                 write_file3.write_to_file(g.get_name()+"gets committed to "+b.get_name());
             }
         }
     }
     return couples;
 }
}
