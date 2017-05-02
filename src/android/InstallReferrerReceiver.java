package com.plugin.InstallReferrerCatcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class InstallReferrerReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String referrer = intent.getStringExtra("referrer");
		if (("" + intent.getAction()).equalsIgnoreCase("com.android.vending.INSTALL_REFERRER")) {
			System.out.println("aa -------------------referrer=" + referrer);
			storeStringPreference(context, "uni_referrer", "referrer", referrer);
		}
	}

	public void storeStringPreference(Context context, String preferenceName, String key, String value) {
		if (context != null) {
			SharedPreferences settings = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(key, value);
			editor.apply();
		}
	}

}
