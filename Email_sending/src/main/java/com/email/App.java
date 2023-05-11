package com.email;

import java.io.File;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      System.out.println("Preparing to send message ");
      
      String message = " Hello , Dear , This is security check..";
      
      String subject = "CodersArea : Confirmation";
      
      String to =" smandeep1609@gmail.com";
      
      String from = "mandeep160902";
      
      // sending normal text
    //  sendEmail(message, subject , to , from);
      
      //sending attach
      
      sendAttach(message, subject , to , from);
      
      
    }
    	
 // for the normal Attachment also
	// this is responsible to send email
    	private static void sendAttach(String message, String subject, String to, String from) {
    		
    		// variable for gmail
    		
    		String host = "smtp.gmail.com";
    		
    		//  get the Sysetm Properties
    		
    	 Properties properties =	System.getProperties();
    	 
    	 System.out.println("PROPERTIES "+properties);
    	 
    	 // setting important information to properties
    	 
    	 //host set
    	 
    	 properties.put("mail.smtp.host" , host);
    	 properties.put("mail.smtp.port" , "465");
    	 properties.put("mail.smtp.ssl.enable" , "true");
    	 properties.put("mail.smtp.auth" , "true");
    	 
    	 
    	 
    	 // step 1: to get the session Object
    	 
    	 Session session=Session.getInstance(properties , new Authenticator() {

    		@Override
    		protected PasswordAuthentication getPasswordAuthentication() {
    			// TODO Auto-generated method stub
    			return new  PasswordAuthentication("**************@gmail.com","********");
    		} 
    		 
    	 });
    		
    		session.setDebug(true);
    		
    		
    		 // Step 2: Compose the message [text, multi media]
    		MimeMessage m = new MimeMessage(session);
    		
    		

    		try {
    			// from email 
    			m.setFrom(from);
    			
    			//adding recipient  to message
    			m.addRecipient(Message.RecipientType.TO ,  new InternetAddress(to));
    			
    			//adding  Subject   to message
    			
    			m.setSubject(subject);
    			
    			//adding Attachment   to message
    				
    			//file Path
    			
    			String Path ="C:\\Users\\Default\\Desktop\\default.png";
    			
    			MimeMultipart mimeMultipart=new MimeMultipart();
    			
    			m.setContent(mimeMultipart);
    			
    			// text
    			//file
    			
    			MimeBodyPart textMime = new MimeBodyPart();
    			MimeBodyPart fileMime = new MimeBodyPart();
    			
    			try {
    				
    				textMime.setText(message);
        			 File file= new File(Path);
        			 fileMime.attachFile(file);
    				
    				
    			}catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    			
    			// send
    			
    			
    			// step 3 : Send the message using  Transport Class
    			
    			Transport.send(m);
    			
    			System.out.println("Sent Success.........................");
    			
    			
    		} catch (MessagingException e) {
    		
    			
    			e.printStackTrace();
    		}
		
	

    	
    	// for the normal text
    	
 /*   	
    	
		// this is responsible to send email
	private static void sendEmail(String message, String subject, String to, String from) {
		
		// variable for gmail
		
		String host = "smtp.gmail.com";
		
		//  get the Sysetm Properties
		
	 Properties properties =	System.getProperties();
	 
	 System.out.println("PROPERTIES "+properties);
	 
	 // setting important information to properties
	 
	 //host set
	 
	 properties.put("mail.smtp.host" , host);
	 properties.put("mail.smtp.port" , "465");
	 properties.put("mail.smtp.ssl.enable" , "true");
	 properties.put("mail.smtp.auth" , "true");
	 
	 
	 
	 // step 1: to get the session Object
	 
	 Session session=Session.getInstance(properties , new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new  PasswordAuthentication("mandeep160902@gmail.com","********");
		} 
		 
	 });
		
		session.setDebug(true);
		
		
		 // Step 2: Compose the message [text, multi media]
		MimeMessage m = new MimeMessage(session);
		
		

		try {
			// from email 
			m.setFrom(from);
			
			//adding recipient  to message
			m.addRecipient(Message.RecipientType.TO ,  new InternetAddress(to));
			
			//adding  Subject   to message
			
			m.setSubject(subject);
			
			//adding Text  to message
			
			m.setText(message);
			
			// send
			
			
			// step 3 : Send the message using  Transport Class
			
			Transport.send(m);
			
			System.out.println("Sent Success.........................");
			
			
		} catch (MessagingException e) {
		
			
			e.printStackTrace();
		}
		*/
		
	}
}
