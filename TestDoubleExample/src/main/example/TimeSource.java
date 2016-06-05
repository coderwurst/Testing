package example;

import org.joda.time.DateTime;

public interface TimeSource {
	DateTime currentTime();
}
