package citygenerator.controllers;

import citygenerator.model.DataLayer.POJO.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {
    private static final String template = "Message: %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/message")
    public Message message(@RequestParam(value="name", defaultValue="TEST") String name) {
        return new Message(counter.incrementAndGet(),
                String.format(template, name));
    }
}
