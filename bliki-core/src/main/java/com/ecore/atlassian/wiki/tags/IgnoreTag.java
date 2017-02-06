package com.ecore.atlassian.wiki.tags;

import java.io.IOException;

import com.ecore.atlassian.tags.util.INoBodyParsingTag;

/**
 * Wiki tag which renders no HTML output. This tag is useful for ignoring wiki
 * extension tags, which shouldn't be supported. See <a
 * href="http://code.google.com/p/gwtwiki/issues/detail?id=94">Issue 94</a>
 * 
 */
public class IgnoreTag extends HTMLTag implements INoBodyParsingTag {

	public IgnoreTag(String tagName) {
		super(tagName);
	}

	@Override
	public boolean isAllowedAttribute(String attName) {
		return true;
	}

}