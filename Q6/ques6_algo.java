/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Pradeep
 */
public class ques6_algo {
    public ArrayList<couple> new_gifting(ArrayList<couple> couples, ArrayList<boy> boys, ArrayList<girl> girls,ArrayList<gift> gifts, int k) throws IOException{
        ques9_algo q9=new ques9_algo();
        ques8_algo q8=new ques8_algo();
        couples=q8.dist_gift2(couples, gifts, boys, girls);
        couples=q9.happi(couples, boys, girls);
        ArrayList<couple> couples2=new ArrayList<couple>();
        int n=couples.size();
        int i;
        for(i=0;i<n;++i){
            couples2.add(couples.get(i));
        }
        for(i=0;i<n;++i){
            couple c=couples.get(i);
            if(c.get_happiness()<=k){
                for(boy b:boys){
                    if(b.get_name().equals(c.get_b_name()))
                        b.set_status(0);
                }
                for(girl g:girls){
                    if(g.get_name().equals(c.get_g_name()))
                        g.set_status(0);
                }
                couples2.remove(c);
            }
        }
        for(girl g:girls){
            for(boy b:boys){
                if(g.get_att()>b.get_min_att_req() && b.get_budget()>g.get_main_budget() && b.get_status()==0 && g.get_status()==0){
                    couple c=new couple();
                    c.set_name(b.get_name(), g.get_name());
                    b.set_status(1);
                    g.set_status(1);
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH_mm_ss").format(Calendar.getInstance().getTime());
                    write_file3.write_to_file(b.get_name()+" gets committed to"+g.get_name()+" at"+timeStamp);
                    couples2.add(c);
                }
            }
        }
        return couples2;
    }
}
