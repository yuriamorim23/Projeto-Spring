package com.projetojava.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.projetojava.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}