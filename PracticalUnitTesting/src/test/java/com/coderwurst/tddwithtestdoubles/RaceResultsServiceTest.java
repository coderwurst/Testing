package com.coderwurst.tddwithtestdoubles;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import org.junit.Test;

import com.coderwurst.tddwithtestdoubles.Client;
import com.coderwurst.tddwithtestdoubles.Message;

public class RaceResultsServiceTest {

	RaceResultsService raceResults = new RaceResultsService();
	Client clientA = mock(Client.class);				// behavior is verified (line 22) therefore test spy
	Client clientB = mock(Client.class, "client b");
	Message message = mock(Message.class);			// used in test but nothing verified - dummy
	
	@Test
	public void testMessageShouldNotBeSentToUnsubscribedSubscribers() {

		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}
	
	@Test
	public void testSubscribedClientShouldReceiveMessage() {
		
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
	
	@Test
	public void testMessageShouldBeSentToAllSubscribedClients() {

		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);
		raceResults.send(message);
		
		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}
	
	@Test
	public void testSendOnlyOneMessageToMultiSubscriber() {
		
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
}
