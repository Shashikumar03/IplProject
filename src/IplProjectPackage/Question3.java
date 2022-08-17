package IplProjectPackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Question3 {

    void ExtraRuns(ArrayList<MatchesModel>match_al ,ArrayList<DeliveriesModel> delivery_al)
    {
        HashMap<String,Integer>hm= new HashMap<>();
         for(MatchesModel mm:match_al)
         {

             for(DeliveriesModel dm:delivery_al)
             {

                 if(mm.getMatch_id().equals(dm.getDel_match_idMatch_id())&& mm.getSeason().equals("2016"))
                 {
                     if(hm.containsKey(dm.getBatting_teams()))
                     {
                         int c=hm.get(dm.getBatting_teams());
                         int n=Integer.parseInt(dm.getExtra_runs());
                         hm.put(dm.getBatting_teams(),c+Integer.parseInt(dm.getExtra_runs()));
                     }
                     else
                     {
                         hm.put(dm.getBatting_teams(),Integer.parseInt(dm.getExtra_runs()));
                     }
                 }
             }

         }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("for the year 2016 total extra runs given by");
        for(String s:hm.keySet())
        {
            System.out.println(s+"  --  "+hm.get(s));
        }

    }
}
