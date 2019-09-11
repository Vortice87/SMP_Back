package com.vortice.SourcingManager.services.impl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	public void sendSimpleMessage(String from ,String[] to, String subject, String text) throws MessagingException  {
			
        MimeMessage message = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject + " - " + from);
        helper.setText("text/html; charset=utf-8", getTemplateNewRequest(text));
 
        helper.setTo(getHumanResources());
        this.emailSender.send(message);
        
	}
	
	public String getTemplateNewRequest(String content) {
		
		String template = "<div class=\"row list \" style=\" border-top: 4px solid #F7C03E; padding-top: 15px; border-radius: 5px; background-color: white; box-shadow: 0 1px 4px 0 rgba(0,0,0,.14); margin-right: -15px; margin-left: -15px;\" ><h1 style=\"padding: 20px; \"> <div class=\"col-md-11 row\">\r\n" + 
				"    <fieldset class=\"form-group\">\r\n" + 
				"        <div class=\"container\">\r\n" + 
				"            <div class=\"form-group row\">\r\n" + 
				"                <label for=\"petitioner\" class=\"col-md-3 col-form-label\">SOLICITANTE</label>\r\n" + 
				"                <div class=\"col-md-9\">\r\n" + 
				"                    victor\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"form-group row\">\r\n" + 
				"                <label for=\"nres\" class=\"col-md-3 col-form-label\">RECURSOS</label>\r\n" + 
				"                <div class=\"col-md-3\">\r\n" + 
				"                    4\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"form-group row\">\r\n" + 
				"                <label for=\"nres\" class=\"col-md-3 col-form-label\">ESTADO</label>\r\n" + 
				"                <div class=\"col-md-3\">\r\n" + 
				"                    estado\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"            <div class=\"form-group row\">\r\n" + 
				"                <label for=\"destask\" class=\"col-md-3 col-form-label\">DESCRIPCION ROL</label>\r\n" + 
				"                <div class=\"col-md-9\">\r\n" + 
				"                    descripcion\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"            <div class=\"form-group row\">\r\n" + 
				"                <label for=\"expstartdate\" class=\"col-md-3 col-form-label\">FECHA DE INCORPORACION</label>\r\n" + 
				"                <div class=\"col-md-3\">\r\n" + 
				"                    25-01-1987\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </fieldset>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <fieldset class=\"form-group\">\r\n" + 
				"        <div class=\"container \">\r\n" + 
				"            <legend>REQUERIMIENTOS TÉCNICOS</legend>\r\n" + 
				"            <div class=\"form-group row no-margin-bottom\">\r\n" + 
				"\r\n" + 
				"                <div class=\"col-md-4 align-center\">\r\n" + 
				"                    <label for=\"area\">AREA</label>\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"col-md-3 align-center\">\r\n" + 
				"                    <label for=\"detalle\">DETALLE</label>\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"col-md-2 align-center\">\r\n" + 
				"                    <label for=\"expyearsreq\">EXP. AÑOS</label>\r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"col-md-2 align-center\">\r\n" + 
				"                    <label for=\"reqdes2\">REQ / DES</label>\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"cuadro\">\r\n" + 
				"                <div class=\"container\">\r\n" + 
				"                    <div class=\"form-group row padding-bottom-reqs animated fadeIn\">\r\n" + 
				"                        <div class=\"col-md-4 align-center-req\">\r\n" + 
				"                            area\r\n" + 
				"                        </div>\r\n" + 
				"                        <div class=\"col-md-3\">\r\n" + 
				"                            detalle\r\n" + 
				"                        </div>\r\n" + 
				"                        <div class=\"col-md-2\">\r\n" + 
				"                            exp\r\n" + 
				"                        </div>\r\n" + 
				"                        <div class=\"col-md-3\">\r\n" + 
				"                            req\r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </fieldset>\r\n" + 
				"\r\n" + 
				"</div>  </div>"; 
		return template;
		
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
