package com.coderwurst.testdoubles;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;


public class MessangerTest {
	
	private static final String CLIENT_EMAIL = "me@mail.com";
	private static final String MESAGE_CONTENTS = "... mesage contents...";

	/* 
	 * DUMMY - needed as a param but no other action carried out on it; 
	 * passed directly into second method.
	 * also could use null value for this object, but is better in the long 
	 * term to use a mocked object in case method functionality should be
	 * extended
	 */
	Template template = mock(Template.class);
	
	/*
	 * MOCK - a mock can act as a spy and vice versa, no real difference. In this case, 
	 * when needed in @Before to simulate getEmail() method
	 */
	Client client = mock(Client.class);
	
	/*
	 * STUB - indirect input of the class, used to pass value into the class
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
		when(templateEngine.prepareMessage(template, client)).thenReturn(MESAGE_CONTENTS);
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
	}
	
	@Test
	public void testShouldSendEmail() {
		
		Messenger messenger = new Messenger(mailServer, templateEngine);
		
		messenger.sendMessage(client, template);
		
		verify(mailServer).send(CLIENT_EMAIL, MESAGE_CONTENTS);
	}
	
}
