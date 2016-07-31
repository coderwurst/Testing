package com.coderwurst.sut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * an object stores with put() method can be retrieved with get() method
 * 2nd object with same key as initial object results in old value being replaced
 * clear method removes all content
 * null value can be used as a kay
 * 
 * use:
 * 		@Before to create a fresh, empty map before each test method
 */
@RunWith(JUnitParamsRunner.class)
public class HashMapManipulationTest {
	
	private HashMapManipulation hashMap;
	
	private static final Object [] getHashMapData() {
		return new Object [] {
				new Object [] { "bart", "Bart Simpson" },
				new Object [] { "homer", "Homer Simpson"},
				new Object [] { "marge", "Marge Simpson"}
		};
	}
	
	private static final Object [] getNullHashMapData() {
		return new Object [] {
			new Object [] { null, "Maggie Simspon" }	
		};
	}
	
	@Before
	public void setup() {
		hashMap = new HashMapManipulation();
	}
	
	@Test
	@Parameters(method = "getHashMapData")
	public void testPutAndGetMethod(String key, String name) {		
		// given
		hashMap.put(key, name);
		
		// then
		assertEquals(name, hashMap.get(key));
	}
	
	@Test
	@Parameters(method = "getNullHashMapData")
	public void testNullAsKeyValue(String key, String name) {
		// given
		hashMap.put(key, name);
		
		// then
		assertNotNull(hashMap);
		assertEquals(name, hashMap.get(null));
	}
	
	@Test
	@Parameters(method = "getHashMapData")
	public void testRemove(String key, String name) {
		// given
		hashMap.put(key,  name);
		
		// when
		hashMap.clear();
		
		// then
		assertEquals(new HashMap(), hashMap);
	}

}
