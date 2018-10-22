package name.anonymous.common.front.app.heros.service;

import java.util.Locale;

import javax.mail.MessagingException;

public interface EmailService {

	void sendSimpleMessage(String to, String subject, String text);

	void sendMailWithInline(final String recipientName, final String recipientEmail, final Locale locale)
			throws MessagingException;

	void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException;
}
