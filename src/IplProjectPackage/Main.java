package IplProjectPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main
{
    public static final int MATCH_ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKET = 12;
    public static final int PLAYER_OF_THE_MATCH = 13;
    public static final int VENUE = 14;
    public static final int DEL_MATCH_ID = 0;
    public static final int INNINGS = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALLS = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    //static MatchesModel matchesModel= new MatchesModel();

    //static DeliveriesModel deliveryModel= new DeliveriesModel();
    public static void main(String[] args)
    {

        ArrayList<MatchesModel> match_al= enterTheDatafromMatch();
        ArrayList<DeliveriesModel> deliver_al=enterTheDatafromDeliveries();

        Question1 q1= new Question1();
        q1.totalMatchPalyed(match_al);
        
        Question2 q2= new Question2();
        q2.totalMatchWon(match_al);
        
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
                MatchesModel matchesModel= new MatchesModel();
                String[] values=line.split(",");
                matchesModel.setMatch_id(values[MATCH_ID]);
                matchesModel.setSeason(values[SEASON]);
                matchesModel.setCity(values[Main.CITY]);
                matchesModel.setDate(values[DATE]);
                matchesModel.setTeam1(values[TEAM1]);
                matchesModel.setTeam2(values[TEAM2]);
                matchesModel.setToss_winner(values[TOSS_WINNER]);
                matchesModel.setToss_decision(values[TOSS_DECISION]);
                matchesModel.setResult(values[RESULT]);
                matchesModel.setDl_applied(values[DL_APPLIED]);
                matchesModel.setWinner(values[WINNER]);
                matchesModel.setWin_by_runs(values[WIN_BY_RUNS]);
                matchesModel.setWin_by_wickets(values[WIN_BY_WICKET]);
                matchesModel.setPlayer_of_match(values[PLAYER_OF_THE_MATCH]);
                matchesModel.setVenue(values[VENUE]);

                al_match.add(matchesModel);



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

               DeliveriesModel deliveryModel= new DeliveriesModel();
                String[] values=line.split(",");
                deliveryModel.setDel_match_idMatch_id(values[DEL_MATCH_ID]);
                deliveryModel.setInnings(values[INNINGS]);
                deliveryModel.setBatting_teams(values[BATTING_TEAM]);
                deliveryModel.setBowling_teams(values[BOWLING_TEAM]);
                deliveryModel.setOver(values[OVER]);
                deliveryModel.setBall(values[BALLS]);
                deliveryModel.setBatsman(values[BATSMAN]);
                deliveryModel.setNon_striker(values[NON_STRIKER]);
                deliveryModel.setBowler(values[BOWLER]);
                deliveryModel.setExtra_runs(values[EXTRA_RUNS]);
                deliveryModel.setTotal_runs(values[TOTAL_RUNS]);
                delivery_al.add(deliveryModel);


            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        return delivery_al;
    }
}
