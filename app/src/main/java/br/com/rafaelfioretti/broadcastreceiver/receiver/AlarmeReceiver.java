package br.com.rafaelfioretti.broadcastreceiver.receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import br.com.rafaelfioretti.broadcastreceiver.AlarmeActivity;
import br.com.rafaelfioretti.broadcastreceiver.R;

/**
 * Created by rafaelfioretti on 11/21/16.
 */

public class AlarmeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarme Disparado", Toast.LENGTH_SHORT).show();
        enviarNotificacao(context);
    }

    public void enviarNotificacao(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(
                PendingIntent.getActivity(context,
                        0, new Intent(context, AlarmeActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT));

        builder.setContentTitle("Alarm Disparado");
        builder.setContentText("Seu alarme foi disparado com sucesso");
        builder.setTicker("Nova Mensagem");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(100, builder.build());

    }

}
