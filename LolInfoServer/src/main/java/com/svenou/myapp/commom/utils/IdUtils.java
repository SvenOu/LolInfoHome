package com.svenou.myapp.commom.utils;

public abstract class IdUtils {
	private static  String SEED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String getId(String prefix) {
		StringBuilder t = new StringBuilder(prefix + System.currentTimeMillis());

		for (int i = 0; i < 4; i++) {
			t.append(SEED.charAt((int) (Math.random() * 26.0D)));
		}
		return t.toString();
	}
}