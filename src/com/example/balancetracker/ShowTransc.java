package com.example.balancetracker;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ShowTransc extends Activity {
 ListView lv;
 SQLiteDatabase db;
 public static final String EXTRA_TITLE = "com.devspark.sidenavigation.sample.extra.MTGOBJECT";
 public static final String EXTRA_RESOURCE_ID = "com.devspark.sidenavigation.sample.extra.RESOURCE_ID";
 public static final String EXTRA_MODE = "com.devspark.sidenavigation.sample.extra.MODE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_transc);
		//lv=(ListView)findViewById(R.id.lv1);					
	}	
	/*	db=openOrCreateDatabase("Database1", MODE_PRIVATE, null);
		Cursor c=db.query("Expense",null,null,null,null,null,null);
		populatelv(c);
		BaseAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.activity_show_transc,c, new String[]{"Description","Day","Month","Year","Price"},new int[]{R.id.t1,R.id.t2,R.id.t4,R.id.t5,R.id.t3},0);
        lv.setAdapter(adapter);
        
	}

	public void populatelv(Cursor c1){
		Intent i=getIntent();
		String category=i.getStringExtra(EXTRA_TITLE);
		if(category.equals(getResources().getString(R.string.title1))){
		c1=db.rawQuery("Select Description,Day,Month,Year,Price from Expense where Category=category",null);		
		}
		if(category.equals(getResources().getString(R.string.title2))){
			c1=db.rawQuery("Select Description,Day,Month,Year,Price from Expense where Category=category",null);				
			
		}
		if(category.equals(getResources().getString(R.string.title3))){
			c1=db.rawQuery("Select Description,Day,Month,Year,Price from Expense where Category=category",null);	
			
			
		} 
		if(category.equals(getResources().getString(R.string.title4))){
			c1=db.rawQuery("Select Description,Day,Month,Year,Price from Expense where Category=category",null);			
		}
		if(category.equals(getResources().getString(R.string.title5))){
			c1=db.rawQuery("Select Description,Day,Month,Year,Price from Expense where Category=category",null);			
		}
	
	}*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_transc, menu);
		return true;
	}

}
