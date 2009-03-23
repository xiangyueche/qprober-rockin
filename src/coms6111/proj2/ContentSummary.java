package coms6111.proj2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ContentSummary {
	private static Log log = LogFactory.getLog(ContentSummary.class);
	

	private String databaseName;
	private Map<String, Integer> docFreqs;
	
	public ContentSummary(String newDatabaseName) {
		databaseName = newDatabaseName;
		docFreqs = new HashMap<String, Integer>();
	}
	
	public void setDocFreq(String word, Integer freq) {
		docFreqs.put(word, freq);
	}
	
	public void setDocFreqs(Map<String, Integer> newDocFreqs) {
		docFreqs = newDocFreqs;
	}
	
	public void setDocFreqs(List<String> words, List<Integer> freqs) {
		if (words.size() != freqs.size()) {
			log.warn("ContentSummary: setDocFreqs: words.size() != freqs.size() ("
					+ words.size() + ", " + freqs.size() + ")");
			return;
		}
		for (int i = 0; i < words.size(); i++) {
			docFreqs.put(words.get(i), freqs.get(i));
		}
	}
	
	public Integer getDocFreq(String word) {
		return docFreqs.get(word);
	}
	
	public Map<String, Integer> getDocFreqs() {
		return docFreqs;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
}
