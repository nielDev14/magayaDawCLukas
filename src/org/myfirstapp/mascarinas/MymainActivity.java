package org.myfirstapp.mascarinas;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MymainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mymain);
		
		//Button next functionality
		Button openAct;
		openAct = (Button) findViewById(R.id.btnBack);
		openAct.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View click) {
				// TODO Auto-generated method stub
				Intent activityIntent =new Intent(getApplicationContext(),
						AboutActivity.class);
				startActivity(activityIntent);
				MymainActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymain, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
	        Drawable drawable = getResources().getDrawable(R.drawable.warning);
	        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
	        Drawable newDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 100, 100, true));
	        AlertDialog dialog = new AlertDialog.Builder(this)
	                .setTitle("Really Exit?")
	                .setMessage("Are you sure you want to exit?")
	                .setCancelable(false)
	                .setNegativeButton(android.R.string.no, null)
	                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface arg0, int arg1) {
	                                MymainActivity.super.onBackPressed();
	                        }
	                }).create();
	        dialog.setIcon(newDrawable);
	        dialog.show();
	}

}
