/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author jeremie
 */
public class Reseau {
    
    public void sendToClient()
    {
        JSONObject obj=new JSONObject();
        obj.put("LoginID", new Integer(1234));
        
        try {
            HttpClient httpclient= new DefaultHttpClient();
            HttpResponse response;
            HttpPost httppost= new HttpPost ("http://10.0.2.2/smartphone/interventionDataManager/getPlanning.php");
            StringEntity se=new StringEntity ("myjson: "+obj.toString());
            httppost.setEntity(se);
            System.out.print(se);
            httppost.setHeader("Accept", "application/json");
            httppost.setHeader("Content-type", "application/json");

            response=httpclient.execute(httppost);

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cannot establish connection!");
        }
    }
    
    public static String webServiceResponse(ArrayList<NameValuePair> nameValuePairs, String requestPath) {
        String result = "";
        InputStream is = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(requestPath);
            if(nameValuePairs != null)
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            return null;
        }
        //convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result = sb.toString();
        } catch (Exception e) {
            return null;
        }
        return result;
    }
    
    public static ArrayList<NameValuePair> readPiecesOrders(String path) {
        FileInputStream fIn = null;
        InputStreamReader isr = null;
//        String data = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        try {
            fIn = new FileInputStream(path);
            isr = new InputStreamReader(fIn);
            BufferedReader buffreader = new BufferedReader(isr);
//            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = buffreader.readLine()) != null) {
//                sb.append(line + "\n");
                System.out.println(line);
                String[] fields = line.split(" ");
                nameValuePairs.add(new BasicNameValuePair("brand", fields[0]));
                nameValuePairs.add(new BasicNameValuePair("ref", fields[1]));
            }
//            data = sb.toString();
            isr.close();
            fIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameValuePairs;
    }
    
    public static void clearFile(String path) {
        try {
            FileOutputStream fOut = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write("");
            osw.flush();
            osw.close();
        } catch (Exception ex) {
           
        }
    }
}
