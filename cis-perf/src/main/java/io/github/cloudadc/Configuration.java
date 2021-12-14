package io.github.cloudadc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.util.SubnetUtils;

public class Configuration {
	
	public static Configuration instance() {
		return new Configuration();
	}
	
	public Boolean isValidCIDR(String subnet) {

		// Base on "http://www.faqs.org/rfcs/rfc1519.html"
		Pattern pattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(\\/(\\d|[1-2]\\d|3[0-2]))?$");
		
		Matcher matcher = pattern.matcher(subnet);
		
		return matcher.find();		
	}
	
	public String[] addressLists(String subnet) {
		SubnetUtils utils = new SubnetUtils(subnet);
		return utils.getInfo().getAllAddresses();
	}

}
