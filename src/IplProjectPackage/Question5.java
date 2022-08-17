package IplProjectPackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Question5
{
    void moreMatchesWinner(ArrayList<MatchesModel> al_match)
    {
        HashMap<String,Integer>hm= new HashMap<>();
        for(MatchesModel mm:al_match)
        {
            if(hm.containsKey(mm.getWinner()))
            {
                int c=hm.get(mm.getWinner());
                hm.put(mm.getWinner(),c+1);
            }
            else
            {
                hm.put(mm.getWinner(),1);

            }
        }


        int total=0;
        HashMap<String,Integer>hm1= new HashMap<>();
        for(MatchesModel mm:al_match)
        {
            if(mm.getTeam1().equals("Mumbai Indians")|| mm.getTeam2().equals("Mumbai Indians"))
            {
                total++;
            }
        }


        int Most=Integer.MIN_VALUE;
        String ms="";
        int less=Integer.MAX_VALUE;
        String ls="";
        for(String s:hm.keySet())
        {
            if(hm.get(s)>Most)
            {
                Most=hm.get(s);
                ms=s;
            }

        }
        System.out.println("-------------question 5-----------------------------------------------");
        System.out.println("Most successful Team Of IPL is "+ms+ " won " +Most+"  matches of "+ total+" total matches played");
    }
}
