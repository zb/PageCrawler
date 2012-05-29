package pagecrawler.db;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class DBFunctions 
{	
private static final String userName = "";
private static final String pass = "";
private static final String url = "jdbc:mysql://localhost/Crawler?jdbcCompliantTruncation=false";
	
private static java.sql.Connection connect = null;
private static java.sql.Statement statement = null;
	  	  
	
@SuppressWarnings({ "rawtypes", "unused" })
public static void writeHtmlTagsToDb(String siteUrl, HashMap<String, Integer> tagCount) throws Exception 
{
	try 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(url, userName, pass);
        
        Set<?> set = tagCount.entrySet();

		Iterator<?> i = set.iterator();		
		
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next();
			
			statement = connect.createStatement();
	        int result = statement.executeUpdate("INSERT INTO Crawler.htmlTags(url, tag, count) VALUE('" + siteUrl +  "', '" + me.getKey() + "', " + me.getValue() + ")");
	        	        
	        statement.close();
		}
		System.out.println("HTML tag count write completed.");
	} 
	catch (Exception e) 
	{
		throw e;
	} 
	finally 
	{
		close();
	}
}    


@SuppressWarnings({"rawtypes", "unused"})
public static void writeWordCountToDb(String siteUrl, HashMap<String, Integer> wordCount) throws Exception 
{
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(url, userName, pass);
        
        Set<?> set = wordCount.entrySet();

		Iterator<?> i = set.iterator();		
		
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next();
			
			statement = connect.createStatement();
	        int result = statement.executeUpdate("INSERT INTO Crawler.wordCount(url, word, count) VALUE('" + siteUrl +  "', '" + me.getKey() + "', " + me.getValue() + ")");
	        	        
	        statement.close();
		}
		System.out.println("Word count write completed.");
	} 
	catch (Exception e) 
	{
		throw e;
	} 
	finally 
	{
		close();
	}
}

    
private static void close() 
{
	try 
	{
		if (statement != null) 
		{
			statement.close();
		}

		if (connect != null) 
		{
			connect.close();
		}
	} 
	catch (Exception e) 
	{        	
	}
}
}