package group4.android.timerproject.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import group4.android.timerproject.R;
import group4.android.timerproject.common.TimerUIUpdateListener;
import group4.android.timerproject.model.ConcreteTimerFacade;
import group4.android.timerproject.model.TimerFacade;

/**
 * Created by demetribairaktaris on 3/23/16.
 */
public class TimerAdapter extends Activity implements TimerUIUpdateListener {

    TimerFacade timerFacade ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerFacade = new ConcreteTimerFacade();
        timerFacade.setUIUpdateListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //TODO be able to save the state of app
        //utilize outState.putInt(String key, int value);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);
        //TODO Restore the instance state
        // utilize int value = savedInstanceState.getInt(Stringkey);
    }

    @Override
    public void updateTime(int time) {
            // UI adapter responsibility to schedule incoming events on UI thread
            runOnUiThread(() -> {
                final TextView tvS = (TextView) findViewById(R.id.seconds);
                final int seconds = time ;
                tvS.setText(Integer.toString(seconds / 10) + Integer.toString(seconds % 10));
            });

    }

    @Override
    public void updateState(int stateId) {

    }

    /**
     * onButton() receives button events from UI and forwards to the Facade;
     * @param view
     */
    public void onButton(View view){
        this.timerFacade.onButton();
    }


}