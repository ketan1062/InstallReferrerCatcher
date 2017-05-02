package com.plugin.InstallReferrerCatcher;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * This class echoes a string called from JavaScript.
 */
public class InstallReferrerCatcher extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("referrer")) {
            //String message = args.getString(0);
            this.getReferrer(callbackContext);
            return true;
        }
        return false;
    }

    private void getReferrer(CallbackContext callbackContext) {
		try {
			String referrer = retrieveStringPreference(this.cordova.getActivity().getApplicationContext(), "uni_referrer", "referrer");
			if(referrer != null && !referrer.isEmpty()) {
				callbackContext.success(referrer);
			} else {
				callbackContext.error("No referrer found");
			}
		} catch (Exception e) {
			callbackContext.error(""+e);
		}
    }
	
	public static String retrieveStringPreference(Context context, String preferenceName, String key) {
        if (context != null) {
            SharedPreferences settings = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
            return settings.getString(key, "");
        } else {
            return "";
        }
    }
}
