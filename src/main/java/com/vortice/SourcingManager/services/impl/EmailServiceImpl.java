package com.vortice.SourcingManager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.services.EmailService;
import com.vortice.SourcingManager.services.UserService;

/**
 * The Class EmailServiceImpl.
 */
@Service
public class EmailServiceImpl implements EmailService{
	
	/** The email sender. */
	@Autowired
	private JavaMailSender emailSender;
	
	/** The user service. */
	@Autowired
	private UserService userService;
	

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.EmailService#sendSimpleMessage(java.lang.String[], java.lang.String, java.lang.String)
	 */
	@Override
	public void sendSimpleMessage(String from ,String[] to, String subject, String text) {
		
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(getHumanResources());
        message.setSubject(subject + " - " + from); 
        message.setText(text);
        emailSender.send(message);		
        
	}
	
	/**
	 * Gets the human resources.
	 *
	 * @return the human resources
	 */
	public String[] getHumanResources() {
		
		List<UserAccount> users = Lists.newArrayList(this.userService.getUsersByProfile("rrhh"));
		String[] emailUsers = new String[users.size()];
		
		for(int i=0; i< users.size(); i++) {
			emailUsers[i]= users.get(i).getUsername();
		}
				
		return emailUsers;
	}
	
	

}
