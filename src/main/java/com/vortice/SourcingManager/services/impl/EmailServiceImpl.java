package com.vortice.SourcingManager.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.google.common.collect.Lists;
import com.vortice.SourcingManager.dto.UserAccountDTO;
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
	
	@Autowired
	private VelocityEngine velocityEngine;


	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.EmailService#sendSimpleMessage(java.lang.String[], java.lang.String, java.lang.String)
	 */
	@Override
	public void sendSimpleMessage(String from ,String[] to, String subject, String text) throws MessagingException  {
			
//        MimeMessage message = this.emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setSubject(subject + " - " + from);
////        helper.setText("text/html; charset=utf-8", getTemplateNewRequest(text));
//        helper.setTo(getHumanResources());
//        
//        Map model = new HashMap();
//        UserAccountDTO user = new UserAccountDTO();
//        user.setUsername("v.u.bedmar@gmail.com");
//        
//        model.put("user", user);
//        @SuppressWarnings("deprecation")
//		String text = VelocityEngineUtils.mergeTemplateIntoString(
//           velocityEngine, "com/dns/registration-confirmation.vm", model);
//        
//        message.setText("text/html; charset=utf-8", text);
//        
//        this.emailSender.send(message);
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
              UserAccountDTO user = new UserAccountDTO();
              user.setUsername("v.u.bedmar@gmail.com");
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setSubject(subject + " - " + from);
               message.setTo(getHumanResources());
               message.setFrom("v.u.bedmar@gmail.com"); // could be parameterized...
               Map model = new HashMap();
               model.put("user", user);
               String text = VelocityEngineUtils.mergeTemplateIntoString(
                  velocityEngine, "plantilla2.vm", model);
               message.setText(text, true);
            }
         };
         this.emailSender.send(preparator);
        
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
		
		String template2 = "<html lang=\"es-ES\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title></title>\r\n" + 
				"    <style>\r\n" + 
				"      \r\n" + 
				"\r\n" + 
				"#DIV_5 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 700px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 1038.44px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 519.213px 627.4px;\r\n" + 
				"    transform-origin: 519.219px 627.4px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 50px 0px 0px 103.838px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_5*/\r\n" + 
				"\r\n" + 
				"#DIV_6 {\r\n" + 
				"    box-shadow: rgba(0, 0, 0, 0.14) 0px 1px 4px 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 740.8px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 1038.44px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 519.213px 614.9px;\r\n" + 
				"    transform-origin: 519.219px 614.9px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    animation: 1s ease 0s 1 normal both running fadeIn;\r\n" + 
				"    background: rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box;\r\n" + 
				"    border-top: 4px solid rgb(247, 192, 62);\r\n" + 
				"    border-right: 0px none rgb(51, 51, 51);\r\n" + 
				"    border-bottom: 0px none rgb(51, 51, 51);\r\n" + 
				"    border-left: 0px none rgb(51, 51, 51);\r\n" + 
				"    border-radius: 5px 5px 5px 5px;\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px -15px 25px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 15px 0px 0px;\r\n" + 
				"}/*#DIV_6*/\r\n" + 
				"\r\n" + 
				"#DIV_7 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 35.2px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 41.5375px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 20.7625px 17.6px;\r\n" + 
				"    transform-origin: 20.7687px 17.6px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_7*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#A_8 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 122, 183);\r\n" + 
				"    text-decoration: none solid rgb(51, 122, 183);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    column-rule-color: rgb(51, 122, 183);\r\n" + 
				"    perspective-origin: 0px 0px;\r\n" + 
				"    transform-origin: 0px 0px;\r\n" + 
				"    caret-color: rgb(51, 122, 183);\r\n" + 
				"    border: 0px none rgb(51, 122, 183);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 122, 183) none 0px;\r\n" + 
				"}/*#A_8*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_10 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 700px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 951.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 475.95px 605.4px;\r\n" + 
				"    transform-origin: 475.95px 605.4px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px -15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_10*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#FORM_11 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 700px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 597.9px;\r\n" + 
				"    transform-origin: 460.95px 597.9px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#FORM_11*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#FIELDSET_12 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 335.6px;\r\n" + 
				"    min-width: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 167.8px;\r\n" + 
				"    transform-origin: 460.95px 167.8px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    overflow: hidden;\r\n" + 
				"    padding: 0px;\r\n" + 
				"}/*#FIELDSET_12*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_13 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 335.6px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 167.8px;\r\n" + 
				"    transform-origin: 460.95px 167.8px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_13*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#LEGEND_14, #LEGEND_35, #LEGEND_69 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 30.6px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 891.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 445.95px 15.3px;\r\n" + 
				"    transform-origin: 445.95px 15.3px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border-top: 0px none rgb(51, 51, 51);\r\n" + 
				"    border-right: 0px none rgb(51, 51, 51);\r\n" + 
				"    border-bottom: 1px solid rgb(229, 229, 229);\r\n" + 
				"    border-left: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 21px / 30px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 50px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px;\r\n" + 
				"}/*#LEGEND_14, #LEGEND_35, #LEGEND_69*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_15, #DIV_18, #DIV_21, #DIV_24, #DIV_30 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 12.5px;\r\n" + 
				"    transform-origin: 460.95px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px -15px 15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_15, #DIV_18, #DIV_21, #DIV_24, #DIV_30*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#LABEL_16, #LABEL_19, #LABEL_22, #LABEL_25, #LABEL_28, #LABEL_31 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    display: block;\r\n" + 
				"    float: left;\r\n" + 
				"    height: 20px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    max-width: 100%;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 230.475px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 115.238px 10px;\r\n" + 
				"    transform-origin: 115.238px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 700 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 5px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#LABEL_16, #LABEL_19, #LABEL_22, #LABEL_25, #LABEL_28, #LABEL_31*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_17, #DIV_26 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 20px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 691.425px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 345.712px 10px;\r\n" + 
				"    transform-origin: 345.712px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_17, #DIV_26*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_20, #DIV_23, #DIV_32 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 20px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 230.475px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 115.238px 10px;\r\n" + 
				"    transform-origin: 115.238px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_20, #DIV_23, #DIV_32*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_27 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 40px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 20px;\r\n" + 
				"    transform-origin: 460.95px 20px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px -15px 15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_27*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_29 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 40px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 691.425px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 345.712px 20px;\r\n" + 
				"    transform-origin: 345.712px 20px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_29*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#FIELDSET_33 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 330px;\r\n" + 
				"    min-width: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 118.8px;\r\n" + 
				"    transform-origin: 460.95px 118.8px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    overflow: hidden;\r\n" + 
				"    padding: 0px;\r\n" + 
				"}/*#FIELDSET_33*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_34 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 237.6px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 118.8px;\r\n" + 
				"    transform-origin: 460.95px 118.8px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_34*/\r\n" + 
				"\r\n" + 
				"#DIV_36, #DIV_70 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 45px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 921.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 460.95px 22.5px;\r\n" + 
				"    transform-origin: 460.95px 22.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px -15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_36, #DIV_70*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_37, #DIV_71 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 45px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 307.3px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 153.65px 22.5px;\r\n" + 
				"    transform-origin: 153.65px 22.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px 20px;\r\n" + 
				"}/*#DIV_37, #DIV_71*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#LABEL_38 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    display: inline-block;\r\n" + 
				"    height: 20px;\r\n" + 
				"    max-width: 100%;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 39.675px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 19.8375px 10px;\r\n" + 
				"    transform-origin: 19.8375px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 700 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 5px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#LABEL_38*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_39 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 45px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 230.475px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 115.238px 22.5px;\r\n" + 
				"    transform-origin: 115.238px 22.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px 20px;\r\n" + 
				"}/*#DIV_39*/\r\n" + 
				"\r\n" + 
				"#LABEL_40 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    display: inline-block;\r\n" + 
				"    height: 20px;\r\n" + 
				"    max-width: 100%;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 63.525px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 31.7625px 10px;\r\n" + 
				"    transform-origin: 31.7625px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 700 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 5px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#LABEL_40*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_41, #DIV_43 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 45px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 153.65px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 76.825px 22.5px;\r\n" + 
				"    transform-origin: 76.825px 22.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px 20px;\r\n" + 
				"}/*#DIV_41, #DIV_43*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#LABEL_42 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    display: inline-block;\r\n" + 
				"    height: 20px;\r\n" + 
				"    max-width: 100%;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 74.4375px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 37.2125px 10px;\r\n" + 
				"    transform-origin: 37.2188px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 700 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 5px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#LABEL_42*/\r\n" + 
				"\r\n" + 
				"#LABEL_44 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    display: inline-block;\r\n" + 
				"    height: 20px;\r\n" + 
				"    max-width: 100%;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 70.8px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 35.4px 10px;\r\n" + 
				"    transform-origin: 35.4px 10px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 700 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 5px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#LABEL_44*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_45 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"	HEIGHT: 200px;\r\n" + 
				"    max-height: 600px;\r\n" + 
				"	overflow-y: scroll;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 891.9px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 445.95px 41px;\r\n" + 
				"    transform-origin: 445.95px 41px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 1px solid rgb(204, 204, 204);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 0px 0px 30px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_45*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_46 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 80px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 873.1px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 436.55px 40px;\r\n" + 
				"    transform-origin: 436.55px 40px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_46*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_47, #DIV_57, #DIV_77, #DIV_83, #DIV_89, #DIV_95, #DIV_101, #DIV_107, #DIV_113, #DIV_119, #DIV_125, #DIV_131 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 843.1px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 421.55px 12.5px;\r\n" + 
				"    transform-origin: 421.55px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_47, #DIV_57, #DIV_77, #DIV_83, #DIV_89, #DIV_95, #DIV_101, #DIV_107, #DIV_113, #DIV_119, #DIV_125, #DIV_131*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_48, #DIV_58, #DIV_78, #DIV_84, #DIV_90, #DIV_96, #DIV_102, #DIV_108, #DIV_114, #DIV_120, #DIV_126, #DIV_132 {\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 873.1px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 436.55px 12.5px;\r\n" + 
				"    transform-origin: 436.55px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    animation: 1s ease 0s 1 normal both running fadeIn;\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    margin: 10px -15px;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"}/*#DIV_48, #DIV_58, #DIV_78, #DIV_84, #DIV_90, #DIV_96, #DIV_102, #DIV_108, #DIV_114, #DIV_120, #DIV_126, #DIV_132*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_49, #DIV_59, #DIV_79, #DIV_85, #DIV_91, #DIV_97, #DIV_103, #DIV_109, #DIV_115, #DIV_121, #DIV_127, #DIV_133 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 25px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 291.025px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 145.512px 12.5px;\r\n" + 
				"    transform-origin: 145.512px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_49, #DIV_59, #DIV_79, #DIV_85, #DIV_91, #DIV_97, #DIV_103, #DIV_109, #DIV_115, #DIV_121, #DIV_127, #DIV_133*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#INPUT_50, #INPUT_60 {\r\n" + 
				"    box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;\r\n" + 
				"    color: rgb(85, 85, 85);\r\n" + 
				"    display: block;\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(85, 85, 85);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 261.025px;\r\n" + 
				"    column-rule-color: rgb(85, 85, 85);\r\n" + 
				"    perspective-origin: 130.512px 12.5px;\r\n" + 
				"    transform-origin: 130.512px 12.5px;\r\n" + 
				"    caret-color: rgb(85, 85, 85);\r\n" + 
				"    background: rgb(238, 238, 238) none repeat scroll 0% 0% / auto padding-box border-box;\r\n" + 
				"    border: 1px solid rgb(204, 204, 204);\r\n" + 
				"    border-radius: 4px 4px 4px 4px;\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(85, 85, 85) none 0px;\r\n" + 
				"    padding: 6px 12px;\r\n" + 
				"    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s, -webkit-box-shadow 0.15s ease-in-out 0s;\r\n" + 
				"}/*#INPUT_50, #INPUT_60*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_51, #DIV_55, #DIV_61, #DIV_65 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 25px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 218.275px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 109.137px 12.5px;\r\n" + 
				"    transform-origin: 109.137px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_51, #DIV_55, #DIV_61, #DIV_65*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#INPUT_52, #INPUT_56, #INPUT_66 {\r\n" + 
				"    box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;\r\n" + 
				"    color: rgb(85, 85, 85);\r\n" + 
				"    display: block;\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(85, 85, 85);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 188.275px;\r\n" + 
				"    column-rule-color: rgb(85, 85, 85);\r\n" + 
				"    perspective-origin: 94.1375px 12.5px;\r\n" + 
				"    transform-origin: 94.1375px 12.5px;\r\n" + 
				"    caret-color: rgb(85, 85, 85);\r\n" + 
				"    background: rgb(238, 238, 238) none repeat scroll 0% 0% / auto padding-box border-box;\r\n" + 
				"    border: 1px solid rgb(204, 204, 204);\r\n" + 
				"    border-radius: 4px 4px 4px 4px;\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(85, 85, 85) none 0px;\r\n" + 
				"    padding: 6px 12px;\r\n" + 
				"    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s, -webkit-box-shadow 0.15s ease-in-out 0s;\r\n" + 
				"}/*#INPUT_52, #INPUT_56, #INPUT_66*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#DIV_53, #DIV_63 {\r\n" + 
				"    bottom: 0px;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: rgb(51, 51, 51);\r\n" + 
				"    float: left;\r\n" + 
				"    height: 25px;\r\n" + 
				"    left: 0px;\r\n" + 
				"    min-height: 1px;\r\n" + 
				"    position: relative;\r\n" + 
				"    right: 0px;\r\n" + 
				"    text-decoration: none solid rgb(51, 51, 51);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    top: 0px;\r\n" + 
				"    width: 145.512px;\r\n" + 
				"    column-rule-color: rgb(51, 51, 51);\r\n" + 
				"    perspective-origin: 72.75px 12.5px;\r\n" + 
				"    transform-origin: 72.7562px 12.5px;\r\n" + 
				"    caret-color: rgb(51, 51, 51);\r\n" + 
				"    border: 0px none rgb(51, 51, 51);\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(51, 51, 51) none 0px;\r\n" + 
				"    padding: 0px 15px;\r\n" + 
				"}/*#DIV_53, #DIV_63*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#INPUT_54, #INPUT_64 {\r\n" + 
				"    box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;\r\n" + 
				"    color: rgb(85, 85, 85);\r\n" + 
				"    display: block;\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(85, 85, 85);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 115.512px;\r\n" + 
				"    column-rule-color: rgb(85, 85, 85);\r\n" + 
				"    perspective-origin: 57.75px 12.5px;\r\n" + 
				"    transform-origin: 57.7562px 12.5px;\r\n" + 
				"    caret-color: rgb(85, 85, 85);\r\n" + 
				"    background: rgb(238, 238, 238) none repeat scroll 0% 0% / auto padding-box border-box;\r\n" + 
				"    border: 1px solid rgb(204, 204, 204);\r\n" + 
				"    border-radius: 4px 4px 4px 4px;\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(85, 85, 85) none 0px;\r\n" + 
				"    padding: 6px 12px;\r\n" + 
				"    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s, -webkit-box-shadow 0.15s ease-in-out 0s;\r\n" + 
				"}/*#INPUT_54, #INPUT_64*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#INPUT_62 {\r\n" + 
				"    box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset;\r\n" + 
				"    color: rgb(85, 85, 85);\r\n" + 
				"    display: block;\r\n" + 
				"    height: 25px;\r\n" + 
				"    text-align: center;\r\n" + 
				"    text-decoration: none solid rgb(85, 85, 85);\r\n" + 
				"    text-size-adjust: 100%;\r\n" + 
				"    width: 188.275px;\r\n" + 
				"    column-rule-color: rgb(85, 85, 85);\r\n" + 
				"    perspective-origin: 94.1375px 12.5px;\r\n" + 
				"    transform-origin: 94.1375px 12.5px;\r\n" + 
				"    caret-color: rgb(85, 85, 85);\r\n" + 
				"    background: rgb(238, 238, 238) none repeat scroll 0% 0% / auto padding-box border-box;\r\n" + 
				"    border: 1px solid rgb(204, 204, 204);\r\n" + 
				"    border-radius: 4px 4px 4px 4px;\r\n" + 
				"    font: normal normal 400 normal 14px / 20px \"Helvetica Neue\", Helvetica, Arial, sans-serif;\r\n" + 
				"    outline: rgb(85, 85, 85) none 0px;\r\n" + 
				"    padding: 6px 12px;\r\n" + 
				"    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s, -webkit-box-shadow 0.15s ease-in-out 0s;\r\n" + 
				"}/*#INPUT_62*/\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body> " + 
				" <div id=\"DIV_5\"> " + 
				"				<div id=\"DIV_6\">\r\n" + 
				"					<div id=\"DIV_7\">\r\n" + 
				"						 <a href=\"/home/requests\" id=\"A_8\"><i id=\"I_9\"></i></a>\r\n" + 
				"					</div> <!--bindings={ \"ng-reflect-ng-if\": \"true\" }-->\r\n" + 
				"					<div id=\"DIV_10\">\r\n" + 
				"						<form name=\"formNewRequest\" id=\"FORM_11\">\r\n" + 
				"							<fieldset id=\"FIELDSET_12\">\r\n" + 
				"								<div id=\"DIV_13\">\r\n" + 
				"									 \r\n" + 
				"									<legend id=\"LEGEND_14\">\r\n" + 
				"										DATOS GENERALES DE LA SOLICITUD\r\n" + 
				"									</legend>\r\n" + 
				"									<div id=\"DIV_15\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"petitioner\" id=\"LABEL_16\">\r\n" + 
				"											SOLICITANTE\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_17\">\r\n" + 
				"											Victor Bedmar Lam\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_18\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"nres\" id=\"LABEL_19\">\r\n" + 
				"											RECURSOS\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_20\">\r\n" + 
				"											2/2\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_21\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"nres\" id=\"LABEL_22\">\r\n" + 
				"											ESTADO\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_23\">\r\n" + 
				"											Abierta\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_24\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"title\" id=\"LABEL_25\">\r\n" + 
				"											PERFIL\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_26\">\r\n" + 
				"											Programador /a Java con Francés (Indefinido)\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_27\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"destask\" id=\"LABEL_28\">\r\n" + 
				"											DESCRIPCION ROL\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_29\">\r\n" + 
				"											Ampliamos equipo en Barcelona, por ello precisamos incorporar un/a desarrollador /a Java con experiencia de al menos 5 años, para un importante cliente.\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_30\">\r\n" + 
				"										 \r\n" + 
				"										<label for=\"expstartdate\" id=\"LABEL_31\">\r\n" + 
				"											FECHA DE INCORPORACION\r\n" + 
				"										</label>\r\n" + 
				"										<div id=\"DIV_32\">\r\n" + 
				"											20/11/2018\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"							</fieldset>\r\n" + 
				"							<fieldset id=\"FIELDSET_33\">\r\n" + 
				"								<div id=\"DIV_34\">\r\n" + 
				"									 \r\n" + 
				"									<legend id=\"LEGEND_35\">\r\n" + 
				"										REQUERIMIENTOS TÉCNICOS\r\n" + 
				"									</legend>\r\n" + 
				"									<div id=\"DIV_36\">\r\n" + 
				"										<div id=\"DIV_37\">\r\n" + 
				"											 \r\n" + 
				"											<label for=\"area\" id=\"LABEL_38\">\r\n" + 
				"												AREA\r\n" + 
				"											</label>\r\n" + 
				"										</div>\r\n" + 
				"										<div id=\"DIV_39\">\r\n" + 
				"											 \r\n" + 
				"											<label for=\"detalle\" id=\"LABEL_40\">\r\n" + 
				"												DETALLE\r\n" + 
				"											</label>\r\n" + 
				"										</div>\r\n" + 
				"										<div id=\"DIV_41\">\r\n" + 
				"											 \r\n" + 
				"											<label for=\"expyearsreq\" id=\"LABEL_42\">\r\n" + 
				"												EXP. AÑOS\r\n" + 
				"											</label>\r\n" + 
				"										</div>\r\n" + 
				"										<div id=\"DIV_43\">\r\n" + 
				"											 \r\n" + 
				"											<label for=\"reqdes2\" id=\"LABEL_44\">\r\n" + 
				"												REQ / DES\r\n" + 
				"											</label>\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"									<div id=\"DIV_45\">\r\n" + 
				"										<div id=\"DIV_46\">\r\n" + 
				"											<div id=\"DIV_47\">\r\n" + 
				"												<div id=\"DIV_48\">\r\n" + 
				"													<div id=\"DIV_49\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_50\" value=\"prueba\"/>\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_51\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_52\" value=\"prueba\"/>\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_53\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_54\" value=\"prueba\"/>\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_55\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_56\" value=\"prueba\"/>\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"											<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"																						<div id=\"DIV_57\">\r\n" + 
				"												<div id=\"DIV_58\">\r\n" + 
				"													<div id=\"DIV_59\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_60\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_61\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_62\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_63\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_64\" />\r\n" + 
				"													</div>\r\n" + 
				"													<div id=\"DIV_65\">\r\n" + 
				"														<input name=\"tec\" type=\"text\" id=\"INPUT_66\" />\r\n" + 
				"													</div>\r\n" + 
				"												</div>\r\n" + 
				"											</div>\r\n" + 
				"										</div>\r\n" + 
				"									</div>\r\n" + 
				"								</div>\r\n" + 
				"							</fieldset>\r\n" + 
				"							\r\n" + 
				"						</form>\r\n" + 
				"					</div>\r\n" + 
				"			</div>\r\n" + 
				"		</app>\r\n" + 
				" </body>\r\n" + 
				"</html>";
		return template2;
		
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
