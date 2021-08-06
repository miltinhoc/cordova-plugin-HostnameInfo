package com.ahold.plugin.hostnameinfo;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hostnameinfo extends CordovaPlugin {
    public static final String GET_HOSTNAME="getHostName";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            if(GET_HOSTNAME.equals(action)){
                return getHostName(callbackContext);
            }
            callbackContext.error("Error no such method '" + action + "'");
            return false;
        } catch(Exception e) {
            callbackContext.error("Error while calling ''" + action + "' '" + e.getMessage());
            return false;
        }
    }
    
    private boolean getHostName(CallbackContext callbackContext) {
        String hostname = "";

        try {
            Process process = Runtime.getRuntime().exec("getprop net.hostname");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();

            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();

            hostname = output.toString();

        }catch (Exception ex){
            callbackContext.error("Error getting the hostname from the shell. Message ->" + ex.getMessage());
        }

        callbackContext.success(hostname);
        
        return true;
    }
    
}
