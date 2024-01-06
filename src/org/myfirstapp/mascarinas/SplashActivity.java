package org.myfirstapp.mascarinas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        Thread splashThread = new Thread(){
        	public void run() {
        		try {
					sleep(5000);
					Intent splashIntent = new Intent(SplashActivity.this, MymainActivity.class);
					startActivity(splashIntent);
					SplashActivity.this.finish();
				} catch (Exception e) {
					// TODO: handle exception
				}
        	}
        };
        splashThread.start();
    }
}
