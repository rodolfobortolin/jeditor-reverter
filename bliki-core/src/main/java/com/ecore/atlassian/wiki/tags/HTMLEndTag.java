package com.ecore.atlassian.wiki.tags;

import com.ecore.atlassian.htmlcleaner.EndTagToken;


public class HTMLEndTag extends EndTagToken 
{

	public HTMLEndTag(String name)
	{
		super(name);
	}


	@Override
	public boolean isReduceTokenStack()
	{
		return false;
	}
	
}