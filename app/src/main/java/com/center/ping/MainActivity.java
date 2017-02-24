package com.center.ping;

import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.center.ping.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PingRestClient pingRestClient;

    private TextView ipValue;
    private String currentIp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        pingRestClient = new PingRestClient();
        pingRestClient.execute();
        ipValue = (TextView) findViewById(R.id.ipValue);
        if (currentIp != null) {
            ipValue.setText(null);
            ipValue.setText(ipValue.getText().toString() + " " + currentIp);
            //ipValue.setText(currentIp);
        } else {
            ipValue.setText(null);
            ipValue.setText(ipValue.getText().toString() + " " + "Sr. Chuck Norris Please try Again :)");
        }
    }

    class PingRestClient extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                PingHttpClient ping = new PingHttpClient();
                UserIp userIp = ping.findMyIp();
                currentIp = userIp.getIp();
              //  System.out.println("User Ip is " + userIp.getIp());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }
    }


}
