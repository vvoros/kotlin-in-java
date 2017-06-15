package application.controller;

import application.model.Hello;
import application.model.HelloKotlin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

  private static final String HELLO_TEMPLATE = "Hello, %s!";

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/hello")
  public Hello greeting(@RequestParam(defaultValue="World") String name) {
    return new Hello(counter.incrementAndGet(), String.format(HELLO_TEMPLATE, name));
  }

  @RequestMapping("/hello-kotlin")
  public HelloKotlin greetingKotlin(@RequestParam(defaultValue="World") String name) {
    return new HelloKotlin(counter.incrementAndGet(), String.format(HELLO_TEMPLATE, name));
  }
}
