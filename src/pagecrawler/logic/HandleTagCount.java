package pagecrawler.logic;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;


public class HandleTagCount 
{	
	static String[] allHtmlTags = {"<address", "<applet", "<area", "<a ", "<base>", "<basefont", "<big", "<blockquote", "<body", "<br", "<b>", "<caption", "<center",
			"<cite", "<code", "<dd", "<dfn", "<dir", "<div", "<dl", "<dt", "<em", "<font", "<form", "<h1", "<h2", "<h3", "<h4", "<h5", "<h6", "<head", "<hr",
			"<html", "<img", "<input", "<isindex", "<i>", "<kbd", "<link", "<li>", "<map", "<menu", "<meta", "<ol", "<option", "<param", "<pre", "<p>", "<samp",
			"<script", "<select", "<small", "<strike", "<strong", "<style", "<sub", "<sup", "<table", "<td", "<textarea", "<th", "<title", "<tr", "<tt", "<ul", "<u>", "<var"};  
						
	public static HashMap<String, Integer> handleAllTags(String allTags)
	{				
		HashMap<String, Integer> htmlTagMap = new HashMap<String, Integer>();
		int count;			
		
		for (int i = 0; i < allHtmlTags.length; i++)
		{
			count = StringUtils.countMatches(allTags, allHtmlTags[i]);
			if (count > 0)
			{				
				htmlTagMap.put(allHtmlTags[i].replace("<", "").replace(">", ""), count);
			}
		}				
		return htmlTagMap;		
	}	
}