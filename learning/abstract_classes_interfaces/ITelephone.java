package chapter13;//package com.edus.chapter13;

public interface ITelephone
{
	void powerOn();
	void powerOff();
	void dial(long number);
	void answer();
	void message(String compose);
	boolean isRinging();
	String contactList(long contact);
}
