package com.ecore.atlassian.html.jira;

import java.util.HashMap;
import java.util.Map;

import com.ecore.atlassian.html.wikipedia.ATag;
import com.ecore.atlassian.html.wikipedia.AbstractHTMLToWiki;
import com.ecore.atlassian.html.wikipedia.HTMLTag;
import com.ecore.atlassian.html.wikipedia.IHTMLToWiki;
import com.ecore.atlassian.html.wikipedia.NoOutputTag;
import com.ecore.atlassian.html.wikipedia.OpenCloseTag;

/**
 * Convert HTML text to Google Code wiki syntax.
 * 
 * See: <a href="http://code.google.com/p/support/wiki/WikiSyntax">Google code
 * WikiSyntax</a>
 * 
 */
public class ToJIRA extends AbstractHTMLToWiki implements IHTMLToWiki {
	static private final Map<String, HTMLTag> TAG_MAP = new HashMap<String, HTMLTag>();
	static {
		TAG_MAP.put("a", new ATag("[", "]"));
		TAG_MAP.put("b", new OpenCloseTag("*", "*"));
		TAG_MAP.put("strong", new OpenCloseTag("*", "*"));
		TAG_MAP.put("i", new OpenCloseTag("_", "_"));
		TAG_MAP.put("em", new OpenCloseTag("_", "_"));
		
		TAG_MAP.put("table", new TableGCTag());
		// TAG_MAP.put("caption", new CaptionTag());
		TAG_MAP.put("tr", new TrGCTag());
		TAG_MAP.put("td", new TdGCTag());
		TAG_MAP.put("th", new ThGCTag());
		// TAG_MAP.put("img", new ImgTag());
		TAG_MAP.put("p", new OpenCloseTag("\n", "\n\n"));
		TAG_MAP.put("code", new OpenCloseTag("{{{", "}}}"));
		TAG_MAP.put("blockquote", new OpenCloseTag("\n{quote}","{quote}"));
		TAG_MAP.put("cite", new OpenCloseTag("\n??","??"));
		TAG_MAP.put("u", new OpenCloseTag("+", "+"));
		TAG_MAP.put("del", new OpenCloseTag("~~", "~~"));
		TAG_MAP.put("s", new OpenCloseTag("~~", "~~"));
		TAG_MAP.put("sub", new OpenCloseTag(",,", ",,"));
		TAG_MAP.put("sup", new OpenCloseTag("^", "^"));
		// TAG_MAP.put("div", new OpenCloseHTMLTag("\n<div", "\n</div>"));
		// TAG_MAP.put("font", new OpenCloseHTMLTag("<font", "</font>"));
		TAG_MAP.put("pre", new OpenCloseTag("\n{{{\n", "\n}}}\n"));
		TAG_MAP.put("h1", new OpenCloseTag("\nh1. ", " \n", true));
		TAG_MAP.put("h2", new OpenCloseTag("\nh2. ", " \n", true));
		TAG_MAP.put("h3", new OpenCloseTag("\nh3. ", " \n", true));
		TAG_MAP.put("h4", new OpenCloseTag("\nh4. ", " \n", true));
		TAG_MAP.put("h5", new OpenCloseTag("\nh5. ", " \n", true));
		TAG_MAP.put("h6", new OpenCloseTag("\nh6. ", " \n", true));
		TAG_MAP.put("ul", new ListGCTag("*", "*", "#"));
		TAG_MAP.put("ol", new ListGCTag("#", "*", "#"));
		TAG_MAP.put("script", new NoOutputTag());
	}

	public ToJIRA(boolean noDiv, boolean noFont) {
		super(TAG_MAP, noDiv, noFont);
	}

	public ToJIRA() {
		this(false, false);
	}

}
