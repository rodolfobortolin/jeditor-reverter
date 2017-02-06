package com.ecore.atlassian.html.jira;

import com.ecore.atlassian.html.wikipedia.ConvertEmptyHTMLTag;
import com.ecore.atlassian.htmlcleaner.TagNode;



public class TrGCTag extends ConvertEmptyHTMLTag {

	@Override
	public void open(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("\n|");
	}

	@Override
	public void close(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("|");
	}

}
