package IplProjectPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main
{
    //static MatchesModel matchesModel= new MatchesModel();

    //static DeliveriesModel deliveryModel= new DeliveriesModel();
    public static void main(String[] args)
    {

        ArrayList<MatchesModel> match_al= enterTheDatafromMatch();
        Question1 q1= new Question1();
        q1.totalMatchPalyed(match_al);


        Question2 q2= new Question2();
        q2.totalMatchWon(match_al);



        ArrayList<DeliveriesModel> deliver_al=enterTheDatafromDeliveries();
        Question3 q3= new Question3();
        q3.ExtraRuns(match_al, deliver_al);

        Question4 q4=new Question4();
        q4.topEconicalBower(match_al,deliver_al);

        Question5 q5= new Question5();
        q5.moreMatchesWinner(match_al);


    }
    public static ArrayList<MatchesModel> enterTheDatafromMatch()
    {
        String path ="/home/shashi/IdeaProjects/IplProject2/src/IplProjectPackage/matches.csv";
        String line="";

        ArrayList<MatchesModel> al_match= new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            while((line=br.readLine())!=null)
            {
                MatchesModel mm= new MatchesModel();
                String[] values=line.split(",");
                mm.setMatch_id(values[0]);
                mm.setSeason(values[1]);
                mm.setCity(values[2]);
                mm.setDate(values[3]);
                mm.setTeam1(values[4]);
                mm.setTeam2(values[5]);
                mm.setToss_winner(values[6]);
                mm.setToss_decision(values[7]);
                mm.setResult(values[8]);
                mm.setDl_applied(values[9]);
                mm.setWinner(values[10]);
                mm.setWin_by_runs(values[11]);
                mm.setWin_by_wickets(values[12]);
                mm.setPlayer_of_match(values[13]);
                mm.setVenue(values[14]);

                al_match.add(mm);



            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return al_match;

    }
    public static ArrayList<DeliveriesModel> enterTheDatafromDeliveries()
    {
        String path1 ="/home/shashi/IdeaProjects/IplProject2/src/IplProjectPackage/deliveries.csv";
        String line="";

         ArrayList<DeliveriesModel> delivery_al = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            br.readLine();
            while((line=br.readLine())!=null)
            {

               DeliveriesModel dm= new DeliveriesModel();
                String[] values=line.split(",");
                dm.setDel_match_idMatch_id(values[0]);
                dm.setInnings(values[1]);
                dm.setBatting_teams(values[2]);
                dm.setBatting_teams(values[3]);
                dm.setOver(values[4]);
                dm.setBall(values[5]);
                dm.setBatsman(values[6]);
                dm.setNon_striker(values[7]);
                dm.setBowler(values[8]);
                dm.setExtra_runs(values[16]);
                dm.setTotal_runs(values[17]);
                delivery_al.add(dm);


            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        return delivery_al;
    }
}
