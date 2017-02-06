package info.bliki.wiki.tags;

import info.bliki.htmlcleaner.TagNode;
import info.bliki.wiki.tags.util.IBodyTag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Wiki tag for references &lt;ref&gt;reference text...&lt;/ref&gt;
 * 
 * See <a href="http://en.wikipedia.org/wiki/Wikipedia:Footnotes">Footnotes</a>
 */
public class RefTag extends HTMLTag implements IBodyTag {

	public RefTag() {
		super("ref");
	}


	@Override
	public boolean isReduceTokenStack() {
		return false;
	}
}