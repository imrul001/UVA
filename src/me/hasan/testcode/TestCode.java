package me.hasan.testcode;

import java.util.ArrayList;
import java.util.List;

class TestCode {
	public static void main(String[] args) {
		List<String> codes = new ArrayList<String>();
		codes.add("01");
		codes.add("001");
		Trie t1 = new Trie(codes);
		System.out.println(t1.isPrefix("01"));
	}
}
