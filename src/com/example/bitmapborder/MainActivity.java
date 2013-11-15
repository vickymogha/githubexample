package com.example.bitmapborder;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	
	 Bitmap btp;
	 Bitmap newBtp;
	 Paint paint;
	 ImageView imageview;
	 Canvas canvas;
	 int borderSize = 5;
	 int MaxBorderSize = 100;
	 SeekBar seekbar;
	 BitmapFactory.Options option;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageview = (ImageView)findViewById(R.id.imagev);
		
		
		
		
		option = new BitmapFactory.Options();
		option.inBitmap = btp;
		btp = BitmapFactory.decodeResource(getResources(), R.drawable.mataji,option);
		newBtp = Bitmap.createBitmap(btp.getWidth()+MaxBorderSize, btp.getHeight()+MaxBorderSize, Config.ARGB_8888);
		canvas = new Canvas(newBtp);
		
		paint  = new Paint();
		paint.setStrokeWidth(30.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
		
		seekbar  = (SeekBar)findViewById(R.id.seekBar1);
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				System.out.println("onRemove touch");
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				setBorderSize(arg1);
				createBorderAtBitMap(btp);
			}
		});
		
/*		newBtp = Bitmap.createBitmap(btp.getWidth()+borderSize, btp.getHeight()+borderSize, Config.ARGB_8888);
		paint  = new Paint();
		paint.setStrokeWidth(30.0f);
        paint.setStyle(Paint.Style.FILL);
       // sStrokePaint.measureText("hello");
        paint.setColor(Color.RED);
        Rect rect = new Rect(0,0, btp.getWidth()+borderSize, btp.getHeight()+borderSize);
        canvas = new Canvas(newBtp);
        canvas.drawRect(rect, paint);
        canvas.drawBitmap(btp, borderSize/2, borderSize/2, paint);*/
        
        //canvas.drawBitmap(newBtp,new Matrix(), null);
        
        
        
        
       // Btp = Bitmap.createBitmap(btp);
		
		
		
	}
	
	public void setBorderSize(int size)
	{
		borderSize = size;
	}
	
	private void createBorderAtBitMap(Bitmap btp)
	{
		
		
       // sStrokePaint.measureText("hello");
	
        Rect rect = new Rect(0,0, btp.getWidth()+borderSize, btp.getHeight()+borderSize);
       // canvas.drawColor(Color.YELLOW);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.drawRect(rect, paint);
        canvas.drawBitmap(btp, borderSize/2, borderSize/2, null);
        imageview.setImageBitmap(newBtp);
        
        
        //newBtp.recycle();
        //btp.recycle();
      
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}
