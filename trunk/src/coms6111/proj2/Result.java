package coms6111.proj2;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Represents one result as returned by search engine
 */
public class Result {
	private static Log log = LogFactory.getLog(Result.class);
	
	public String title, summary;
	public URL url;
	
	/**
	 * Constructor.
	 * @param theTitle Title of a search engine result.
	 * @param theSummary Summary text of a search engine result.
	 * @param theUrl URL returned by search engine for this result.
	 */
	public Result(String theTitle, String theSummary, String theUrl) {
		title = theTitle;
		summary = theSummary;
		try {
			url = new URL(theUrl);
		} catch (MalformedURLException e) {
			log.warn(e);
			url = null;
		}
	}
	
	public boolean equals(Object other) {
		Result otherR;
		try {
			otherR = (Result) other;
		} catch (ClassCastException e) {
			return false;
		}
		return (this.title.equals(otherR.title))
				&& (this.summary.equals(otherR.summary))
				&& (this.url.equals(otherR.url));
	}
}
