package com.ecore.atlassian.wiki.tags;

import java.io.IOException;
import java.util.List;


public class ATag extends HTMLTag {
	public ATag() {
		super("a");
	}

	@Override
	public boolean isReduceTokenStack() {
		return false;
	}

	// public boolean isAllowedAttribute(String attributeName) {
	// if (attributeName.equals("href") || attributeName.equals("title") ||
	// attributeName.equals("rel")) {
	// return true;
	// }
	// return false;
	// }

	public String getCloseTag() {
		return "</a>";
	}



	@Override
	public boolean addAttribute(String attName, String attValue, boolean checkXSS) {
		super.addAttribute(attName, attValue, checkXSS);
		if (attName != null && attValue != null && attName.equalsIgnoreCase("href")) {
			String valueLowerCased = attValue.trim().toLowerCase();
			if (valueLowerCased.startsWith("http:") || valueLowerCased.startsWith("https:") || valueLowerCased.startsWith("ftp:")
					|| valueLowerCased.startsWith("ftps:") || valueLowerCased.startsWith("mailto:")) {
				addAttribute("rel", "nofollow", true);
				return true;
			}
		}
		return false;
	}

}