package com.vortice.SourcingManager.services;

public interface EmailService {
	
	public void sendSimpleMessage(String from, String[] to, String subject, String text);

}
