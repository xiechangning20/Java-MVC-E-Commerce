package com.Myshop.utils;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;


import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.Myshop.controller.Constants;
import com.Myshop.entity.User;

public class EmailUtils {
	
	//qcjybukqraowbhad
	//vktgranmqthzbhii imap
	public static void sendEmail(User user){
		//sender
		String sender = "your email address";
		String myAccount = "your smtp account";
		//pass
		String myPass = "your smtp password";
		String SMTPHost = "your smtphost";
		
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.port", "587");
		
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.auth", "true");
		
		
	
		
		
		//create session object
		Session session = Session.getDefaultInstance(prop);
	    session.setDebug(true);	
	    
	    
	    MimeMessage message = createMsg(session,sender,user);
	    
	    //send email
	    try {
			Transport tran = session.getTransport();
			tran.connect(SMTPHost,myAccount,myPass);
			tran.sendMessage(message, message.getAllRecipients());
			tran.close();
		}  catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	
		
	}

	private static MimeMessage createMsg(Session session, String sender, User user) {
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender,Constants.hostName,Constants.encodeing));
			InternetAddress add = new InternetAddress(user.getuEmail(),user.getuName(),Constants.encodeing);
			message.setRecipient(MimeMessage.RecipientType.TO, add);
			message.setSubject(Constants.emailSubject,Constants.encodeing);
			String ip = "Your ip address";
			String url = "http://"+ip+"/user?method=active&c="+Base64Utils.encode(user.getuCode());
			String content = user.getuName()+",hello! <br> Welcome to CLay's music shop. To activate your account,please click"
					+ "the link:<a href = '"+url+"'>Click here</a>";
			message.setContent(content,"text/html;charset=utf-8");
			message.setSentDate(new Date());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return message;
	}

}
