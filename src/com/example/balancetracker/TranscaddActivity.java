package com.example.balancetracker;

import java.util.Date;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TranscaddActivity extends Activity  {
	 DatePicker dp;
	private int day,month,year;
	EditText e1,e2,e3;
	TextView t1;
   Dialog datep;
   Spinner s1;
   SQLiteDatabase sb;
   int row_id=0;
   String itemchose="",price="",description="",date="";
  // String items[]={this.getResources().getString(R.string.title1),this.getResources().getString(R.string.title2),this.getResources().getString(R.string.title3),this.getResources().getString(R.string.title4),getResources().getString(R.string.title5)};
	String items[]={"Entertainment","Medical","Travel","Auto","Groceries"};
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transcadd);
		e1=(EditText)findViewById(R.id.datech);
		e2=(EditText)findViewById(R.id.price);
		e3=(EditText)findViewById(R.id.descrip);
        s1=(Spinner)findViewById(R.id.category);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
         
			@Override
			public void onItemSelected(AdapterView<?> arg0, View v,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
			   TextView tv=(TextView)v;
			   itemchose=tv.getText().toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        try
		{
			
		sb=openOrCreateDatabase("Database1", MODE_PRIVATE, null);
		sb.execSQL("Create table Expense(_id Auto_increment Number,Category text(20),Day Number(2),Month(2),Year(4),Price Number)");
		Log.i("db","Table made");
		}catch(Exception e)
		{Log.i("E","Excceptiion cot");}
		finally{
			try{
				sb.execSQL("Create table Expense(_id Auto_increment Number,Category text(20),Day Number(2),Month(2),Year(4),Price Number)");
				Log.i("db","Table made");
				//c=sb.query("userTable3",null,null,null,null,null,null);
			}
			catch(Exception e1)
			{}
		} 
		//LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
	     // t1=(TextView)findViewById(R.id.date);
	      
	      
	}

	@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	sb.close();
}

	public void showDatepick(View v){
			 dp=new DatePicker(this);
			 dp.setEnabled(true);
			 dp.setCalendarViewShown(false);
			 datep=new Dialog(this);
			
			 LinearLayout l1=new LinearLayout(this);
			 l1.setOrientation(LinearLayout.VERTICAL);
			 l1.addView(dp);
			 datep.setTitle("Select a date");
			 Button b1=new Button(this);
			 Button b2=new Button(this);
			 ViewGroup.MarginLayoutParams params=new MarginLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			 //params.setMargins(0,20,40,60);
			 params.setMargins(20,0,20,0);
			 b1.setText("Set");
			 b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					int a=dp.getMonth()+1;
				   	e1.setText(dp.getDayOfMonth()+"/"+a+"/"+dp.getYear());
				}
			});
			 b1.setLayoutParams(params);
			 b2.setText("Cancel");
			 b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				    datep.dismiss(); 	
				}
			});
			 b1.setLayoutParams(params);
			 LinearLayout l2=new LinearLayout(this);
			 l2.addView(b1);
			 l2.addView(b2);
			 l1.addView(l2);
			 datep.setContentView(l1);
			 
			// datep =new AlertDialog.Builder(getApplicationContext()).setTitle("Select date").setView(dp).setPositiveButton("Set",this).setNegativeButton("Cancel",this).create();
			 datep.show();			
		     
		}		
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.transcadd, menu);
		return true;
	}

	/*@Override
	public void onClick(DialogInterface dialog, int pos) {
		// TODO Auto-generated method stub
		switch(pos){
		case DialogInterface.BUTTON_POSITIVE:
			 day=dp.getDayOfMonth();
			 month=dp.getMonth();
			 year=dp.getYear();
			 Date d=new Date(year-1900,month,day);
			 Log.i("Date",day+"/"+month+"/"+year);
			 
			
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			                      datep.dismiss();
		                          break;
		
		
		}
		
	}*/
	String Day="",Month="",Year="";
public void addtrans(View v){
	  price=e2.getText().toString();
	  date=e1.getText().toString();
	  System.out.print("date"+date);
	  description=e3.getText().toString();
	  //"Insert into userTable3 (_id,username,age) Values ('i','"+nam+"','"+age+"')"
	 /*String datesplit[]=new String[10];
	 datesplit=date.split("/");
	 Log.i("Date",datesplit[0]+datesplit[1]+datesplit[2]);
    // Toast.makeText(this,datesplit[0]+" "+datesplit[1]+" "+datesplit[2],Toast.LENGTH_LONG).show();
     */
	  int index1=date.indexOf("/");
	  int index2=date.lastIndexOf("/");
	  Day= date.substring(0,date.indexOf("/"));
	  Month=date.substring(index1+1,date.lastIndexOf("/"));
	  Year=date.substring(index2+1,date.length());
	  sb.execSQL("Insert into Expense(_id,Category,Day,Month,Year,Price) Values('row_id','"+itemchose+"','"+Integer.parseInt(Day)+"','"+Integer.parseInt(Month)+"','"+Integer.parseInt(Year)+"','"+price+"')");
	  if(price.equalsIgnoreCase("")||date.equalsIgnoreCase("")||description.equalsIgnoreCase("")||itemchose.equalsIgnoreCase("")){
		Toast.makeText(this,"Please enter the fields",Toast.LENGTH_LONG).show();    
	  }
}
public void reset(View v){
	e1.setText("");
	e2.setText("");
	e3.setText("");
}
       

}
