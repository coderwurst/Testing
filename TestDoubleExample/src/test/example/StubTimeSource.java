package example;

import org.joda.time.DateTime;

/**
 * stub contains pre determined answers - in real life this would return system or DB
 * time, but for testing purposes can simply return pre-determined value
 * 
 */
public class StubTimeSource implements TimeSource {

	@Override
	public DateTime currentTime() {
		return new DateTime(2011, 12, 25, 12, 0, 0, 0);
	}

}
