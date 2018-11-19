package com.example.jarek.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // zareaguj na podstawie ID itemu
        switch (item.getItemId()) {

            case R.id.action_settings:
                setContentView(R.layout.setting);
                TextView t =findViewById(R.id.version);
                t.setText(BuildConfig.VERSION_NAME+"");
                break;

            default:
                break;
        }

        return true;
    }
    public int scoreteama=0;
    public void points3A(View view){
        scoreteama+=3;
        his(3,0);
        dysplayTeamA(scoreteama);
    }
    public void points2A(View view){
        scoreteama+=2;
        his(2,0);
        dysplayTeamA(scoreteama);
    }
    public void points1A(View view){
        scoreteama+=1;
        his(1,0);
        dysplayTeamA(scoreteama);
    }
    private void  dysplayTeamA(int score){
        TextView t = findViewById(R.id.score_team_a);
        t.setText(score + "");
    }
    public int scoreteamb=0;
    public void points3B(View view){
        scoreteamb+=3;
        his(3,1);
        dysplayTeamB(scoreteamb);
    }
    public void points2B(View view){
        scoreteamb+=2;
        his(2,1);
        dysplayTeamB(scoreteamb);
    }
    public void points1B(View view){
        scoreteamb+=1;
        his(1,1);
        dysplayTeamB(scoreteamb);
    }
    private void  dysplayTeamB(int score){
        TextView t = findViewById(R.id.score_team_b);
        t.setText(score + "");
    }

    public void reset(View view){
        scoreteama=0;
        scoreteamb=0;
        hismind=0;
        dysplayTeamB(0);
        dysplayTeamA(0);
    }

    private int memorysize=50;
    public int[][] his=new int[memorysize][2];
    public int hismind=0;
    private void his(int number,int who){
        if(hismind==(memorysize-1)){
             for(int i=0;i<memorysize-1;i++){
                 his[i][0]=his[i+1][0];
                 his[i][1]=his[i+1][1];
             }
        }
        else hismind++;
        his[hismind][0]=number;
        his[hismind][1]=who;
    }
    public void hisback(View view){
        if(hismind>=0) {
            if (his[hismind][1] == 0) {
                scoreteama -= his[hismind][0];
                dysplayTeamA(scoreteama);
            } else {
                scoreteamb -= his[hismind][0];
                dysplayTeamB(scoreteamb);
            }
            hismind--;
        }
    }
    void back(View view){
        setContentView(R.layout.activity_main);
        dysplayTeamB(scoreteamb);
        dysplayTeamA(scoreteama);
    }
}
