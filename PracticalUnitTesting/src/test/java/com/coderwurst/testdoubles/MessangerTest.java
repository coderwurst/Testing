package com.coderwurst.testdoubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class MessangerTest {
	
	/* 
	 * DUMMY mock - needed as a param but no other action carried out on it; 
	 * passed directly into second method.
	 * also could use null value for this object, but is better in the long 
	 * term to use a mocked object in case method functionality should be
	 * extended
	 */
	Template template = mock(Template.class);
	
	Client client = mock(Client.class);
	
	/*
	 * STUB mock - indirect input of the class, used to pass value into the class
	 * which is then used (to send email)
	 */
	TemplateEngine templateEngine = mock(TemplateEngine.class);

	/*
	 * TEST SPY - allows us to take control of indirect test inputs and be used
	 * to verify behaviour between class under test and its collaborators
	 */
	MailServer mailServer = mock(MailServer.class);
	
	@Before
	public void setup() {
		when(templateEngine.prepareMessage(template, client)).thenReturn("... mesage contents...");
		when(client.getEmail()).thenReturn("me@mail.com");
	}
	
	@Test
	public void testShouldSendEmail() {
		
		Messenger messenger = new Messenger(mailServer, templateEngine);
		
		messenger.sendMessage(client, template);
		
		verify(mailServer).send("me@mail.com", "... mesage contents...");
	}
	
}
