package com.ecore.atlassian.htmlcleaner.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ecore.atlassian.htmlcleaner.ContentToken;
import com.ecore.atlassian.htmlcleaner.TagNode;


/**
 * Extracts a &lt;div class=&quot;errorbox&quot;&gt;...error text...&lt;/div&gt;
 * content.
 * 
 */
public class DivErrorboxExtractor extends AbstractHtmlExtractor<StringBuilder> {

	public DivErrorboxExtractor(StringBuilder resultBuffer) {
		super(resultBuffer);
	}

	@Override
	public void appendContent(List nodes) {
		if (nodes != null && !nodes.isEmpty()) {
			Iterator childrenIt = nodes.iterator();
			while (childrenIt.hasNext()) {
				Object item = childrenIt.next();
				if (item != null && (item instanceof ContentToken)) {
					ContentToken contentToken = (ContentToken) item;
					String content = contentToken.getContent();
					fResultObject.append(content.trim());
				} else if (item instanceof List) {
					appendContent((List) item);
				}
			}
		}
	}

	@Override
	public boolean isFound(TagNode tagNode) {
		String name = tagNode.getName();
		if (name.equals("div")) {
			Map<String, String> atts = tagNode.getAttributes();
			String attributeValue = atts.get("class");
			if (attributeValue != null && attributeValue.toLowerCase().equals("errorbox")) {
//				appendContent(tagNode.getChildren());
				return true;
			}
		}
		return false;
	}

}
