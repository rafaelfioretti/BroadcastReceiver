package br.com.rafaelfioretti.broadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelfioretti.broadcastreceiver.receiver.AlarmeReceiver;

public class AlarmeActivity extends AppCompatActivity {

    private EditText etTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarme);
        etTempo = (EditText) findViewById(R.id.etTempoSegundos);
    }

    public void configurar (View v){
        String tempo = etTempo.getText().toString();
        if (!tempo.equals("")){
            Intent i = new Intent(this, AlarmeReceiver.class);
            int t = Integer.parseInt(tempo);
            PendingIntent pi = PendingIntent.getBroadcast(this.getApplicationContext(), 1234, i, 0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (t *1000), pi);

            Toast.makeText(this, "Configurado para daqui: " +t +  " segundos", Toast.LENGTH_SHORT).show();

        }



    }
}
