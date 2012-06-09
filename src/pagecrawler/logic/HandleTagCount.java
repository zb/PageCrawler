package pagecrawler.logic;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;


public class HandleTagCount 
{	
	static String[] allHtmlTags = { "<a ","<abbr", "<address", "<area", "<article", "<aside", "<audio", "<b>", "<base>", "<bdi", "<bdo", "<blockquote", "<body", "<br", 
		"<button", "<canvas", "<caption", "<cite", "<code", "<col>", "<colgroup", "<command", "<datalist", "<dd", "<del", "<details", "<dfn", "<div", "<dl", 
		"<dt", "<em>", "<embed", "<fieldset","<figcaption", "<figure", "<footer", "<form", "<h1", "<h2", "<h3", "<h4", "<h5", "<h6", "<head>", "<header", "<hrgroup",
		"<hr>", "<html", "<i>", "<iframe", "<img", "<input", "<ins", "<keygen", "<kbd", "<label", "<legend", "<link", "<li>", "<map", "<mark", "<menu", "<meta", "<meter",
		"<nav", "<noscript", "<object", "<ol", "<optgroup", "<option", "<output", "<p>", "<param", "<pre", "<progress", "<q", "<rp", "<rt", "<ruby", "<s>", "<samp",
		"<script", "<select", "<small", "<source", "<span", "<strong", "<style", "<sub", "<summary", "<sup", "<table", "<tbody", "<td", "<textarea", "<tfoot", "<th>", 
		"<thead", "<time", "<title", "<tr>", "<track", "<u>", "<ul", "<var", "<video", "<wbr"};  
			
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