package io.github.cloudadc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TestConfiguration {

	@Test
	public void testValidCIDR() {
		
		Configuration validator = Configuration.instance();
		
		Boolean res = validator.isValidCIDR("10.1.10.0/24");
		assertTrue(res);
		
		res = validator.isValidCIDR("10.1.10.0/33");
		assertFalse(res);
		
		res = validator.isValidCIDR("10.1.10.0/23");
		assertTrue(res);
		
		res = validator.isValidCIDR("10.1.10.0/22");
		assertTrue(res);
		
		res = validator.isValidCIDR("10.1.10.0/21");
		assertTrue(res);
		
		res = validator.isValidCIDR("10.1.10.0/16");
		assertTrue(res);
		
	}
	
	@Test
	public void testListAddressList() {
		
		Configuration config = Configuration.instance();
		
		String[] addresses = config.addressLists("10.1.10.0/24");
		assertEquals(addresses.length, 254);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[253], "10.1.10.254");
		
		addresses = config.addressLists("10.1.10.0/25");
		assertEquals(addresses.length, 126);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[125], "10.1.10.126");
		
		addresses = config.addressLists("10.1.10.128/25");
		assertEquals(addresses.length, 126);
		assertEquals(addresses[0], "10.1.10.129");
		assertEquals(addresses[125], "10.1.10.254");
		
		addresses = config.addressLists("10.1.10.0/26");
		assertEquals(addresses.length, 62);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[61], "10.1.10.62");
		
		addresses = config.addressLists("10.1.10.64/26");
		assertEquals(addresses.length, 62);
		assertEquals(addresses[0], "10.1.10.65");
		assertEquals(addresses[61], "10.1.10.126");
		
		addresses = config.addressLists("10.1.10.128/26");
		assertEquals(addresses.length, 62);
		assertEquals(addresses[0], "10.1.10.129");
		assertEquals(addresses[61], "10.1.10.190");
		
		addresses = config.addressLists("10.1.10.192/26");
		assertEquals(addresses.length, 62);
		assertEquals(addresses[0], "10.1.10.193");
		assertEquals(addresses[61], "10.1.10.254");
		
		addresses = config.addressLists("10.1.10.0/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[29], "10.1.10.30");
		
		addresses = config.addressLists("10.1.10.32/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.33");
		assertEquals(addresses[29], "10.1.10.62");
		
		addresses = config.addressLists("10.1.10.64/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.65");
		assertEquals(addresses[29], "10.1.10.94");
		
		addresses = config.addressLists("10.1.10.96/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.97");
		assertEquals(addresses[29], "10.1.10.126");
		
		addresses = config.addressLists("10.1.10.128/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.129");
		assertEquals(addresses[29], "10.1.10.158");
		
		addresses = config.addressLists("10.1.10.160/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.161");
		assertEquals(addresses[29], "10.1.10.190");
		
		addresses = config.addressLists("10.1.10.192/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.193");
		assertEquals(addresses[29], "10.1.10.222");
		
		addresses = config.addressLists("10.1.10.224/27");
		assertEquals(addresses.length, 30);
		assertEquals(addresses[0], "10.1.10.225");
		assertEquals(addresses[29], "10.1.10.254");
		
		addresses = config.addressLists("10.1.10.0/28");
		assertEquals(addresses.length, 14);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[13], "10.1.10.14");
		
		addresses = config.addressLists("10.1.10.16/28");
		assertEquals(addresses.length, 14);
		assertEquals(addresses[0], "10.1.10.17");
		assertEquals(addresses[13], "10.1.10.30");
		
		addresses = config.addressLists("10.1.10.32/28");
		assertEquals(addresses.length, 14);
		assertEquals(addresses[0], "10.1.10.33");
		assertEquals(addresses[13], "10.1.10.46");
		
		addresses = config.addressLists("10.1.10.0/29");
		assertEquals(addresses.length, 6);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[5], "10.1.10.6");
		
		addresses = config.addressLists("10.1.10.8/29");
		assertEquals(addresses.length, 6);
		assertEquals(addresses[0], "10.1.10.9");
		assertEquals(addresses[5], "10.1.10.14");
		
		addresses = config.addressLists("10.1.10.16/29");
		assertEquals(addresses.length, 6);
		assertEquals(addresses[0], "10.1.10.17");
		assertEquals(addresses[5], "10.1.10.22");
		
		addresses = config.addressLists("10.1.10.0/30");
		assertEquals(addresses.length, 2);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[1], "10.1.10.2");
		
		addresses = config.addressLists("10.1.10.4/30");
		assertEquals(addresses.length, 2);
		assertEquals(addresses[0], "10.1.10.5");
		assertEquals(addresses[1], "10.1.10.6");
		
		addresses = config.addressLists("10.1.10.8/30");
		assertEquals(addresses.length, 2);
		assertEquals(addresses[0], "10.1.10.9");
		assertEquals(addresses[1], "10.1.10.10");
		
		addresses = config.addressLists("10.1.0.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[509], "10.1.1.254");
		
		addresses = config.addressLists("10.1.2.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.2.1");
		assertEquals(addresses[509], "10.1.3.254");
		
		addresses = config.addressLists("10.1.4.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.4.1");
		assertEquals(addresses[509], "10.1.5.254");
		
		addresses = config.addressLists("10.1.6.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.6.1");
		assertEquals(addresses[509], "10.1.7.254");
		
		addresses = config.addressLists("10.1.8.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.8.1");
		assertEquals(addresses[509], "10.1.9.254");
		
		addresses = config.addressLists("10.1.10.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.10.1");
		assertEquals(addresses[509], "10.1.11.254");
		
		addresses = config.addressLists("10.1.252.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.252.1");
		assertEquals(addresses[509], "10.1.253.254");
		
		addresses = config.addressLists("10.1.254.0/23");
		assertEquals(addresses.length, 510);
		assertEquals(addresses[0], "10.1.254.1");
		assertEquals(addresses[509], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/22");
		assertEquals(addresses.length, 1022);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[1021], "10.1.3.254");
		
		addresses = config.addressLists("10.1.4.0/22");
		assertEquals(addresses.length, 1022);
		assertEquals(addresses[0], "10.1.4.1");
		assertEquals(addresses[1021], "10.1.7.254");
		
		addresses = config.addressLists("10.1.8.0/22");
		assertEquals(addresses.length, 1022);
		assertEquals(addresses[0], "10.1.8.1");
		assertEquals(addresses[1021], "10.1.11.254");
		
		addresses = config.addressLists("10.1.248.0/22");
		assertEquals(addresses.length, 1022);
		assertEquals(addresses[0], "10.1.248.1");
		assertEquals(addresses[1021], "10.1.251.254");
		
		addresses = config.addressLists("10.1.252.0/22");
		assertEquals(addresses.length, 1022);
		assertEquals(addresses[0], "10.1.252.1");
		assertEquals(addresses[1021], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/21");
		assertEquals(addresses.length, 2046);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[2045], "10.1.7.254");
		
		addresses = config.addressLists("10.1.8.0/21");
		assertEquals(addresses.length, 2046);
		assertEquals(addresses[0], "10.1.8.1");
		assertEquals(addresses[2045], "10.1.15.254");
		
		addresses = config.addressLists("10.1.248.0/21");
		assertEquals(addresses.length, 2046);
		assertEquals(addresses[0], "10.1.248.1");
		assertEquals(addresses[2045], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/20");
		assertEquals(addresses.length, 4094);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[4093], "10.1.15.254");
		
		addresses = config.addressLists("10.1.16.0/20");
		assertEquals(addresses.length, 4094);
		assertEquals(addresses[0], "10.1.16.1");
		assertEquals(addresses[4093], "10.1.31.254");
		
		addresses = config.addressLists("10.1.32.0/20");
		assertEquals(addresses.length, 4094);
		assertEquals(addresses[0], "10.1.32.1");
		assertEquals(addresses[4093], "10.1.47.254");
		
		addresses = config.addressLists("10.1.240.0/20");
		assertEquals(addresses.length, 4094);
		assertEquals(addresses[0], "10.1.240.1");
		assertEquals(addresses[4093], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/19");
		assertEquals(addresses.length, 8190);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[8189], "10.1.31.254");
		
		addresses = config.addressLists("10.1.32.0/19");
		assertEquals(addresses.length, 8190);
		assertEquals(addresses[0], "10.1.32.1");
		assertEquals(addresses[8189], "10.1.63.254");
		
		addresses = config.addressLists("10.1.224.0/19");
		assertEquals(addresses.length, 8190);
		assertEquals(addresses[0], "10.1.224.1");
		assertEquals(addresses[8189], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/18");
		assertEquals(addresses.length, 16382);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[16381], "10.1.63.254");
		
		addresses = config.addressLists("10.1.64.0/18");
		assertEquals(addresses.length, 16382);
		assertEquals(addresses[0], "10.1.64.1");
		assertEquals(addresses[16381], "10.1.127.254");
		
		addresses = config.addressLists("10.1.128.0/18");
		assertEquals(addresses.length, 16382);
		assertEquals(addresses[0], "10.1.128.1");
		assertEquals(addresses[16381], "10.1.191.254");
		
		addresses = config.addressLists("10.1.192.0/18");
		assertEquals(addresses.length, 16382);
		assertEquals(addresses[0], "10.1.192.1");
		assertEquals(addresses[16381], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/17");
		assertEquals(addresses.length, 32766);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[32765], "10.1.127.254");
		
		addresses = config.addressLists("10.1.128.0/17");
		assertEquals(addresses.length, 32766);
		assertEquals(addresses[0], "10.1.128.1");
		assertEquals(addresses[32765], "10.1.255.254");
		
		addresses = config.addressLists("10.1.0.0/16");
		assertEquals(addresses.length, 65534);
		assertEquals(addresses[0], "10.1.0.1");
		assertEquals(addresses[65533], "10.1.255.254");
		
		for(int i = 0 ; i < addresses.length ; i ++) {
//			System.out.println((i +1) + " - " + addresses[i]);
		}
	}
}
