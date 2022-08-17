package IplProjectPackage;



import java.util.HashMap;
import java.util.*;

public class Question2
{
    public static void totalMatchWon(ArrayList<MatchesModel> al)
    {

        Map<String,Integer> hm= new HashMap<>();

        for(MatchesModel mm:al)
        {
            if(hm.containsKey(mm.getWinner()))
            {
                int count=hm.get(mm.getWinner());
                hm.put(mm.getWinner(),count+1);
            }
            else
            {
                hm.put(mm.getWinner(),1);
            }
        }
        System.out.println("total number of matches won by each team over all the year");
        for(String s:hm.keySet())
        {
            if(!s.isEmpty())
                System.out.println(s+"---"+hm.get(s)+" ");

        }


    }

}

