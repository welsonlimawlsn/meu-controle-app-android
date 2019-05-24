package br.com.welson.meucontrole.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

import br.com.welson.meucontrole.modelos.Token;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Settings.Secure.ANDROID_ID;
import static br.com.welson.meucontrole.util.Constantes.ACCESS_TO_API;
import static br.com.welson.meucontrole.util.Constantes.TOKEN;

public class Util {

    public static String getDeviceId(ContentResolver contentResolver) {
        return Settings.Secure.getString(contentResolver, ANDROID_ID);
    }

    public static void setTokenSharedPreferences(Context context, Token token) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ACCESS_TO_API, MODE_PRIVATE).edit();
        edit.putString(TOKEN, token.getToken());
        edit.apply();
    }

    public static String getTokenSharedPreferences(Context context) {
        return context.getSharedPreferences(ACCESS_TO_API, MODE_PRIVATE).getString(TOKEN, null);
    }
}
