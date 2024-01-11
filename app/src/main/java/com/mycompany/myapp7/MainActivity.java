package com.mycompany.myapp7;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.util.*;
import java.io.*;

public class MainActivity extends Activity 
{
	Button b1,b2,b3;
	TextView t1;
	int c=0,u=0;
	StringBuilder sb;
	String[] item = {"ROCK","PAPER","SECISSOR"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		b1 = (Button) findViewById(R.id.mainButton1);
		b2 = (Button) findViewById(R.id.mainButton2);
		b3 = (Button) findViewById(R.id.mainButton3);
		t1 = (TextView) findViewById(R.id.mainTextView);
		
		sb = new StringBuilder();
		b1.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					Random r = new Random();
					int i = r.nextInt(3);
					if(i==1)
					{
						c++;
						s("Comp's Win !!!");
					}
					else if(i==0)
					{
						s("Game Drawn !!!");
						t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
					}
					else
					{
						u++;
						s("User Win !!!");
					}
						
					sb.append("user:"+item[0]+" , comp:"+item[i]+"\n");
					t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
					
				}
		    });
			
		b2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					Random r = new Random();
					int i = r.nextInt(3);
					if(i==2)
					{
						c++;
						s("Comp's Win !!!");
					}
					else if(i==1)
					{
						s("Game Drawn !!!");
						t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
					}
					else
					{
						u++;
						s("User Win !!!");
					}
					sb.append("user:"+item[1]+" , comp:"+item[i]+"\n");
					t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
				}
		    });
			
		b3.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					Random r = new Random();
					int i = r.nextInt(3);
					if(i==0)
					{
						c++;
						s("Comp's Win !!!");
					}
					else if(i==2)
					{
						s("Game Drawn !!!");
						t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
					}
					else
					{
						u++;
						s("User Win !!!");
					}
					sb.append("user:"+item[0]+" , comp:"+item[i]+"\n");
					t1.setText(item[i]+" from Computer \n\n User Win : "+u+"\n\n Comp Win : "+c);
				}
		    });
			
    }
	
	private static long back_pressed;

    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
			write(sb.toString());
        }
        else
        {
            back_pressed = 0;
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
	}
	
	
	private void s(String s)
	{
		Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
	}
	
	private void write(String write)
	{
		try { 
			FileWriter fileWriter = new FileWriter("/sdcard/Routine/learn.txt"); 
			fileWriter.write(write); 
			fileWriter.flush(); 
			fileWriter.close(); 
			
		} catch (FileNotFoundException e) { 
			s(e.toString()); 
			
		} catch (IOException e2) { 
			s(e2.toString());  
		} 
	}
	
	

	
	
}
