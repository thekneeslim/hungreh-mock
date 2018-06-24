package com.testing.eventlistener;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.io.PrintWriter;

@Configuration
public class MyMockListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        int port = event.getEmbeddedServletContainer().getPort();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("mock-port.txt", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.println(String.format("passedMockPort=%d", port));
        writer.close();
    }
}
