package com.ecore.atlassian.html.jira;

import com.ecore.atlassian.html.wikipedia.AbstractHTMLTag;
import com.ecore.atlassian.htmlcleaner.TagNode;



public class TableGCTag extends AbstractHTMLTag {

	@Override
	public void close(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("\n");
	}
}
