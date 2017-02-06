package com.ecore.atlassian;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.ecore.atlassian.html.HTML2WikiConverter;
import com.ecore.atlassian.html.jira.ToJIRA;

public class ConvertToJIRA {

	private static String convertHtml() {
	    
	    HTML2WikiConverter conv = new HTML2WikiConverter();
	    conv.setInputHTML(getHTML());
	    String convertedText = conv.toWiki(new ToJIRA(true, true));
	 
	    return convertedText;
	}
	
	public static String getHTML(){
		
		BufferedReader br = null;
		String everything = null;
		
		try {
			
			br = new BufferedReader(new FileReader("html.txt"));
			
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return everything;
	}
	
	public static void main(String[] args){
		
		String converted = convertHtml();
		
		System.out.println(converted);
	}
	
}
