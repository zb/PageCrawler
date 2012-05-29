package pagecrawler.logic;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class HandleWordCount 
{
	
	public static HashMap<String, Integer> countWords(String text)
	{
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		int count;			
		
		String[] allWords = text.toLowerCase().replaceAll(" +", " ").split(" ");
				
		for (int i = 0; i < allWords.length; i++)
		{
			count = StringUtils.countMatches(text, allWords[i]);
			if (count > 0)
			{				
				wordCountMap.put(allWords[i], count);
			}
		}				
		return wordCountMap;		
	}	
	
}