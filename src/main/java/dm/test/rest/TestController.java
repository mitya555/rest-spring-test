package dm.test.rest;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static final String template = "Hello, %s!";
	
    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }

    @RequestMapping("/long")
    public String count1Trillion() {
    	long timeSpan = System.nanoTime();
    	for (int j = 0; j < 100; j++) {
//			String acc = "";
			StringBuilder acc = new StringBuilder();
			for (int i = 0; i < 10000000; i++) {
//				acc += "A ";
				acc.append("A ");
			}
			String tmp = acc.toString();
		}
    	timeSpan = System.nanoTime() - timeSpan;
//    	Duration ts = Duration.ofNanos(timeSpan);
//    	LocalTime ts = LocalTime.ofNanoOfDay(timeSpan);
    	return "Counted to 1,000,000,000 in " + // ts.format(DateTimeFormatter.ISO_LOCAL_TIME);
    		(timeSpan / 1_000_000_000L) + "." + 
    		("" + (Math.round(timeSpan % 1_000_000_000L / 1e6) + 1_000)).substring(1);
    }

}
