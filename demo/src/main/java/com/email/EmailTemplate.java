package com.email;

import java.io.File;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EmailTemplate {
	
	
	public static String createtemplate(String domainName, String sendername,String path,InputStream object){
		 String html ="";
		Document doc = null;
		// InputStream object=null;
		try {
		    doc = Jsoup.parse(path);
		   // doc = Jsoup.parse(object, "UTF-8","");
		   // object.close();
		} catch (Exception ex) {
		}

		Elements els = doc.body().getAllElements();
		for (Element e : els) {
		    if (e.text().contains("domainUrl")) {
		        e.html(e.html().replaceAll("domainUrl",domainName));
		    }
		    if(e.text().contains("sendername")){
		    	e.html(e.html().replaceAll("sendername", sendername));
		    }
		}
		
	   html = doc.toString();
	   //System.out.println(html);
	   return html;
		
		
		
		
	}
	
	
	public static String gettemplatedata(InputStream object){
		
		 String html ="";
			Document doc = null;
			// InputStream object=null;
			try {
			    //doc = Jsoup.parse(new File(path), "UTF-8");
			    doc = Jsoup.parse(object, "UTF-8","");
			    object.close();
			} catch (Exception ex) {
			}
			 html = doc.toString();
		return html;
	}
	
//public static StringBuilder getTemplate(){
//		
//		StringBuilder myvar = new StringBuilder(); 
//		myvar.append("<p style=\"text-transform: capitalize\">Dear Business Owner,</p>")
//		     .append("")
//		     .append("<p>Hope you are doing well.</p>")
//		     .append("")
//		     .append("<p>I thought you might like to know some reasons why you are not getting enough website hits/visitors and conversion.</p>")
//		     .append("")
//		     .append("<p>My name is Wendi Jarvis and I am the SEO and Digital marketing expert of a leading SEO service provider company. As per my analysis, your website is not performing well in the Google, Yahoo and Bing organic searches.</p>")
//		     .append("")
//		     .append("<p>Also your traffic flow is poor from last couple of months due to some of the reasons. You might know about recent Google PENGUIN 4.0 UPDATES.</p>")
//		     .append("")
//		     .append("<p>Google has completely dropped all authorship functionality from the search results and webmaster tools. So be careful on it and take the help of a SEO company to fix it.</p>")
//		     .append("<p><b>Some of the aspects given below:</b></p>")
//		     .append("<ul>")
//		     .append("<li>Due to poor and unauthorized link sites.</li>")
//		     .append("<li>Relevant keyword phrases are not visible on first page listing.</li>")
//		     .append("<li>Due to HTML validation errors and warnings present in website.</li>")
//		     .append("<li>Your website is not search engine friendly.</li>")
//		     .append("<li>Website content quality is not high standard.</li>")
//		     .append("<li>Website is having on-page and on-site issues.</li>")
//		     .append("</ul>")
//		     .append("<p><b>Area of Improvement:</b></p>")
//		     .append("<ul>")
//		     .append("<li>We will give you 1st page ranking on Google, Yahoo, and Bing.</li>")
//		     .append("<li>Improve your organic traffic and sales.</li>")
//		     .append("<li>If you will not satisfied with our results then we will refund your money as per the money back guarantee policy.</li>")
//		     .append("<li>Secure your website from Google penguin updates 3.0</li>")
//		     .append("<li>Increase your conversion rate.</li>")
//		     .append("<li>Target your local market to increase business.</li>")
//		     .append("</ul>")
//		     .append("<p style=\"color:#3d85c6\"><b>Note*:</b> We give guarantee to improve in your keyword ranking from the first month itself, if we fail to achieve then money back.</p>")
//		     .append("")
//		     .append("<p>We will be optimizing your website in the major search engines like: Google, Yahoo & Bing which results in improvements in keyword ranking, traffic, link popularity, goal conversion, and ROI in the first month of our work.</p>")
//		     .append("")
//		     .append("<p>For more details please reply. We have 24x7 supports, so you can contact any point of time with your website issues.</p>")
//		     .append("")
//		     .append("<p>Thanks & Regards,</p>")
//		     .append("")
//		     .append("<p><b>Wendi Jarvis | (SEO Specialist)</b><br />")
//		     .append("-------------------------------------------------------------------------------</p>");
//	
//		
//		return myvar;
//}

}
