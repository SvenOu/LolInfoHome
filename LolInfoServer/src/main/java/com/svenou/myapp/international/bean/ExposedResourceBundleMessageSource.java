package com.svenou.myapp.international.bean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.CollectionUtils;

public class ExposedResourceBundleMessageSource extends
		ResourceBundleMessageSource {
	public static final String WHOLE = "whole";
	private Set<String> baseNames;
	private Map<String, Map<String, String>> cachedData = new HashMap();

	public Set<String> getKeys(String baseName, Locale locale) {
		ResourceBundle bundle = getResourceBundle(baseName, locale);
		return bundle.keySet();
	}

	public Map<String, String> getKeyValues(String basename, Locale locale) {
		System.out.print(locale.toString() + ":" + locale.getLanguage()
				+ " country:" + locale.getCountry());
		String cacheKey = basename + locale.getLanguage() + locale.getCountry();
		if (this.cachedData.containsKey(cacheKey)) {
			return (Map) this.cachedData.get(cacheKey);
		}
		ResourceBundle bundle = getResourceBundle(basename, locale);

		if (bundle == null) {
			locale = Locale.US;

			return getKeyValues(basename, locale);
		}

		TreeMap treeMap = new TreeMap();
		for (String key : bundle.keySet()) {
			treeMap.put(key, getMessage(key, null, locale));
		}
		this.cachedData.put(cacheKey, treeMap);
		return treeMap;
	}

	public Map<String, String> getKeyValues(Locale locale) {
		String cacheKey = "whole" + locale.getCountry();
		if (this.cachedData.containsKey(cacheKey)) {
			return (Map) this.cachedData.get(cacheKey);
		}
		TreeMap treeMap = new TreeMap();
		for (String baseName : this.baseNames) {
			treeMap.putAll(getKeyValues(baseName, locale));
		}
		this.cachedData.put(cacheKey, treeMap);
		return treeMap;
	}

	public void setBasenames(String[] basenames) {
		this.baseNames = new TreeSet(CollectionUtils.arrayToList(basenames));
		super.setBasenames(basenames);
	}
}