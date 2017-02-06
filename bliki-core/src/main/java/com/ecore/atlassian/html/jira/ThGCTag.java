package com.ecore.atlassian.html.jira;

import com.ecore.atlassian.html.wikipedia.ConvertEmptyHTMLTag;
import com.ecore.atlassian.htmlcleaner.TagNode;



public class ThGCTag extends ConvertEmptyHTMLTag {

	@Override
	public void open(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("| *");
	}
	@Override
	public void close(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("* |");
	}
}
