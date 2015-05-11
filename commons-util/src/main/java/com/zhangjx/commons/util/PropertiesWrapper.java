package com.zhangjx.commons.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;

import com.zhangjx.commons.io.Resources;
import com.zhangjx.commons.logging.Log;
import com.zhangjx.commons.logging.LogFactory;

public class PropertiesWrapper {

	private Properties properties;

	public static final Log log = LogFactory.getLog(PropertiesWrapper.class);
	
	public PropertiesWrapper() {
		this.properties = new Properties();
	}
	
	public PropertiesWrapper(Properties properties) {
		this.properties = properties;
	}
	
	public PropertiesWrapper(String resource) {
		try {
			this.properties  = Resources.getResourceAsProperties(resource);
		} catch (IOException e) {
			log.error("load resource[" + resource + "] fail", e);
			this.properties = new Properties();
		}
	}
	
	public PropertiesWrapper(URL url) {
		String urlString = url.toString();
		try {
			this.properties = Resources.getUrlAsProperties(urlString);
		} catch (IOException e) {
			log.error("load URL[" + url + "] fail.", e);
			this.properties = new Properties();
		}
	}
	
	public String getString(String key) {
		return properties.getProperty(key);
	}
	
	public String getString(String key, String defaultStr) {
		String value = properties.getProperty(key);
		return value == null ? defaultStr : value;
	}
	
	public boolean getBoolean(String key) {
		String value = properties.getProperty(key);
		return value == null ? Boolean.FALSE : new Boolean(value);
	}
	
	public Integer getInteger(String key) {
		String value = properties.getProperty(key);
		return value == null ? null : Integer.parseInt(value);
	}
	
	public int getInteger(String key, int defaultInt) {
		Integer value = getInteger(key);
		return value == null ? defaultInt : value;
	}
	
	public Long getLong(String key) {
		String value = getString(key);
		return value == null ? null : Long.parseLong(value);
	}
	
	public long getLong(String key, long defaultLong) {
		Long value = getLong(key);
		return value == null ? defaultLong : value;
	}
	
	public Float getFloat(String key) {
		String value = getString(key);
		return value == null ? null : Float.parseFloat(value);
	}
	
	public float getFloat(String key, float defaultFloat) {
		Float value = getFloat(key);
		return value == null ? defaultFloat : value;
	}
	
	public Double getDouble(String key) {
		String value = getString(key);
		return value == null ? null : Double.parseDouble(value);
	}
	
	public double getDouble(String key, double defaultDouble) {
		Double value = getDouble(key);
		return value == null ? defaultDouble : value;
	}
	
	public BigDecimal getBigDecimal(String key) {
		String value = getString(key);
		return value == null ? null : new BigDecimal(key);
	}
	
	public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
		BigDecimal value = getBigDecimal(key);
		return value == null ? defaultValue : value;
	}
	
}
