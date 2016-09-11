package com.coderwurst.tddwithtestdoubles;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.coderwurst.tddwithtestdoubles.Client;
import com.coderwurst.tddwithtestdoubles.Message;

public class RaceResultsServiceTest {

	@Test
	public void testSubscribedClientShouldReceiveMessage() {
		RaceResultsService raceResults = new RaceResultsService();
		Client client = mock(Client.class);				// behaviour is verified (line 22) therefore test spy
		Message message = mock(Message.class);			// used in test but nothing verified - dummy
		
		raceResults.addSubscriber(client);
		raceResults.send(message);
		
		verify(client).receive(message);
	}

}
