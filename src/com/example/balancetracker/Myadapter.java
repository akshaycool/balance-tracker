package com.example.balancetracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Myadapter extends ArrayAdapter<String>{
	private Context c;
	SQLiteDatabase db;
	Cursor c1;
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		RelativeLayout l=(RelativeLayout)v.inflate(c,R.layout.activity_show_transc,null);
		TextView descriptv=(TextView)l.findViewById(R.id.t1);
		TextView datetv=(TextView)l.findViewById(R.id.t2);
		TextView pricetv=(TextView)l.findViewById(R.id.t3);
		descriptv.setText("");
		datetv.setText("");
		pricetv.setText("");
		return l;
		//return super.getView(position,v, parent);		
		
	}

	public Myadapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		// TODO Auto-generated constructor stub
		c=context;
		db=context.openOrCreateDatabase("mydb",Context.MODE_PRIVATE,null);
		
	} 

}
