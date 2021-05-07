package com.cjr.messagingrabbitmq.receiver;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(Map<String, String> message) {
    System.out.println("Received <" + message.get("id") + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
