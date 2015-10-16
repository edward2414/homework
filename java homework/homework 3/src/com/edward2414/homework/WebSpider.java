package com.edward2414.homework;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class WebSpider {
	String StartUrl;
	WebSpider(String s)
	{
		StartUrl = s;
	}
	@SuppressWarnings("deprecation")
	public String getHtml()
	{
		String mString = "", buf;
		try{
			URL mUrl = new URL(StartUrl);
			DataInputStream in =
					new DataInputStream(
					new BufferedInputStream(
					mUrl.openStream()));
			String ms0="<!--HTMLBUILERPART0-->";
			String ms1="<!--/HTMLBUILERPART0-->";
			boolean flag = false;
			int i, j, k;
			while((buf = in.readLine()) != null){
				buf = (new String(buf.getBytes("ISO-8859-1"),"GBK"));
				if((i = buf.indexOf(ms0)) >= 0) flag = true;
				if((i = buf.indexOf(ms1)) >= 0) flag = false;
				if(true) mString += buf + '\n';
			}
			in.close();
		}catch(Exception e){
			
		}
		return mString;
	}
    public static void main(String[] args)
    {
    	String StartUrl = "http://www.ybdu.com/xiaoshuo/2/2442/";
    	WebSpider mWebSpider = new WebSpider(StartUrl);
    	String s = new String(mWebSpider.getHtml());
    	/*
    	String ss = new String("");
    	int index0 = 0;
    	while((index0 = s.indexOf("href=\"")) != -1)
    	{
    		ss = s.substring(index0);
    		ss = ss.substring(ss.indexOf("\"") + 1);
    		s = ss.substring(ss.indexOf("\"") + 1);
    		ss = ss.substring(0, ss.indexOf("\""));
    		if(ss.indexOf("/") == -1) continue;
    		System.out.println(ss);
    	}
    	*/
    	String ss = new String("");
    	int index0 = 0;
    	while((index0 = s.indexOf("<li><a href")) != -1)
    	{
    		ss = s.substring(index0);
    		ss = ss.substring(ss.indexOf("\"") + 1);
    		//s = ss.substring(ss.indexOf("\"") + 1);
    		s = ss;
    		ss = ss.substring(0, ss.indexOf("\""));
    		System.out.println(StartUrl + ss);
    	}
    }
}
