package com.ecore.atlassian.html.wikipedia;

import com.ecore.atlassian.htmlcleaner.TagNode;


public class TrTag extends ConvertEmptyHTMLTag {

	@Override
	public void open(TagNode node, StringBuilder resultBuffer) {
		resultBuffer.append("\n|-");
	}

}
