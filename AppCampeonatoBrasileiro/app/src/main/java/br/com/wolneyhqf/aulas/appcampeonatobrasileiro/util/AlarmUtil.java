package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmUtil {
    private static final String TAG = "livroandroid";

    // Agenda o alarme para executar um broadcast
    public static void scheduleBroadcast(Context context, Intent intent, long triggerAtMillis) {
        PendingIntent p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, p);
    }

    // Agenda o alarme com repeat para executar um broadcast
    public static void scheduleRepeatBroadcast(Context context, Intent intent, long triggerAtMillis, long intervalMillis) {
        PendingIntent p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, p);
    }

    // Agenda o alarme para executar uma activity
    public static void scheduleActivity(Context context, Intent intent, long triggerAtMillis) {
        PendingIntent p = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, p);
    }

    // Agenda o alarme com repeat para executar uma activity
    public static void scheduleRepeatActivity(Context context, Intent intent, long triggerAtMillis, long intervalMillis) {
        PendingIntent p = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, p);
    }

    // Agenda o alarme para executar um service
    public static void scheduleService(Context context, Intent intent, long triggerAtMillis) {
        PendingIntent p = PendingIntent.getService(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, p);
    }

    // Agenda o alarme com repeat para executar um service
    public static void scheduleRepeatService(Context context, Intent intent, long triggerAtMillis, long intervalMillis) {
        PendingIntent p = PendingIntent.getService(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, p);
    }

    public static void cancel(Context context, Intent intent) {
        AlarmManager alarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarme.cancel(p);
    }
}
