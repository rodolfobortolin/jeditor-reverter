package info.bliki.wiki.tags;

import java.io.IOException;
import java.util.List;

/**
 * Wiki tag for references &lt;references /&gt;
 * 
 * See <a href="http://en.wikipedia.org/wiki/Wikipedia:Footnotes">Footnotes</a>
 */
public class ReferencesTag extends HTMLTag {
	public ReferencesTag() {
		super("references");
	}

	
	@Override
	public boolean isReduceTokenStack() {
		return false;
	}

}