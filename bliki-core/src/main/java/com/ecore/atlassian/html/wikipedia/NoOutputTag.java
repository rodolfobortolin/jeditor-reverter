package com.ecore.atlassian.html.wikipedia;

import com.ecore.atlassian.htmlcleaner.TagNode;

public class NoOutputTag extends AbstractHTMLTag {

	@Override
	public void open(TagNode node, StringBuilder resultBuffer) {
	}

	@Override
	public void close(TagNode node, StringBuilder resultBuffer) {
	}

	@Override
	public void content(AbstractHTMLToWiki w, TagNode node, StringBuilder resultBuffer, boolean showWithoutTag) {
	}
}
