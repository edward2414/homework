package com.edward2414.homework;

import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

public class WebSpider {
	
	String StartUrl = "";
	
	WebSpider(String s)
	{
		StartUrl = s;
	}
	
	public String getHtml() throws IOException{
		String ret = "";
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpget = new HttpGet(StartUrl);
	    try{
		    CloseableHttpResponse response = httpclient.execute(httpget);
		    HttpEntity entity = response.getEntity();
		    if(entity != null)
		    {
			    ret =  EntityUtils.toString(entity, "GBK");
		    }
	    }
	    catch(ClientProtocolException e)
	    {
		    e.printStackTrace();
	    }
	    catch(IOException e)
	    {
		    e.printStackTrace();
	    }
	    finally
	    {
	        httpclient.close();
	    }
	    return ret;
    }

    public static void main(String[] args) throws IOException
    {
    	String url = "http://www.ybdu.com/xiaoshuo/2/2442/";
    	WebSpider mWebSpider = new WebSpider(url);
    	String s = new String(mWebSpider.getHtml());
    	String ss = new String("");
    	int index0 = 0;
    	GetContent mGetContent;
    	try{
    		File file = new File("诛仙.txt");
    		if(!file.exists()) 
    		{
    			file.createNewFile();
    		}
    		FileWriter fw = new FileWriter(file.getAbsoluteFile());
    		BufferedWriter bw = new BufferedWriter(fw);
    		while((index0 = s.indexOf("<li><a href")) != -1)
    		{
    			ss = s.substring(index0);
    			ss = ss.substring(ss.indexOf("\"") + 1);
    			s = ss;
    			ss = ss.substring(0, ss.indexOf("\""));
    			mGetContent = new GetContent(url + ss);
    			bw.write(mGetContent.getTitle() + "\n" + mGetContent.getContent() + "\n");
    		}
    		bw.close();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
}
