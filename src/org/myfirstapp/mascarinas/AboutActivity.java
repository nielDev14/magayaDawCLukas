package org.myfirstapp.mascarinas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		Button btnBack;
		btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent backIntent =new Intent(getApplicationContext(),
						MymainActivity.class);
				startActivity(backIntent);
				AboutActivity.this.finish();
			}
		});
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
	                                AboutActivity.super.onBackPressed();
	                        }
	                }).create();
	        dialog.setIcon(newDrawable);
	        dialog.show();
	}

}
