package com.projetojava.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.projetojava.cursomc.domain.Cliente;
import com.projetojava.cursomc.domain.Pedido;



public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
	//versao html
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	// plugin apra class sendNewPass
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}