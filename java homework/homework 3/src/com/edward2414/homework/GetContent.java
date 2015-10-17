package com.edward2414.homework;
import java.io.IOException;

public class GetContent {
	
	private String url;
	
	GetContent(String s)
	{
		url = s;
	}
	
	public String getTitle() throws IOException
	{
		WebSpider mWebSpider = new WebSpider(this.url);
		String s = new String(mWebSpider.getHtml());
		String ss = s.substring(s.indexOf("<div class=\"h1title\">"));
		s = ss.substring(0, ss.indexOf("</h1>"));
		s = s.replaceAll("<div class=\"h1title\">\n", "");
		s = s.replaceAll("<h1>", "");
		s = s.trim();
		s = s.replaceAll("\\?", " ");
		s = s.replaceAll("&nbsp;", " ");
		return s;
	}
	
	public String getContent() throws IOException
	{
		WebSpider mWebSpider = new WebSpider(this.url);
		String s = new String(mWebSpider.getHtml());
		String ss = s.substring(s.indexOf("<div id=\"htmlContent\""));
		s = ss.substring(0, ss.indexOf("<div class="));
		s = s.replaceAll("<div id=\"htmlContent\" class=\"contentbox\">", "");
		s = s.replaceAll("<br />", "");
		s = s.replaceAll(" ", "");
		s = s.replaceAll("&nbsp;", " ");
		return s;
	}
	
}
