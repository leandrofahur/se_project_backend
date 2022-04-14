package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;

@Service
public class ForgotPasswordService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public ForgotPasswordService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;		
	}
	
	public void SendForgotPassword(User user) throws MailException{
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject("Reset Email Password");
		simpleMailMessage.setText("To reset your password, click on the following link: http://localhost:8081/resetpassword");
		
		javaMailSender.send(simpleMailMessage);
	}
	
}
