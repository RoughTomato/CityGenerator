package citygenerator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {
    private static final String template = "Message: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/message")
    public Message message(@RequestParam(value="name", defaultValue="TEST") String name) {
        return new Message(counter.incrementAndGet(),
                String.format(template, name));
    }
}
