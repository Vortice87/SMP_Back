package com.vortice.SourcingManager.services;

import javax.mail.MessagingException;

public interface EmailService {
	
	public void sendSimpleMessage(String from, String[] to, String subject, String text) throws MessagingException;

}
