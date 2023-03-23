package com.bifengle.demo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenInDefaultBrowser implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OpenInDefaultBrowser.class);

    @Value("${auto-open-browser.enable}")
    boolean enable;

    @Value("${auto-open-browser.url}")
    String url;

    @Override
    public void run(String... args) throws Exception {
        try {
            if (enable) {
                Runtime runtime  = Runtime.getRuntime();
                runtime.exec(new String[]{ "open", "http:localhost:8080" });
            }
        } catch (Exception err) {
            err.printStackTrace();
            logger.error(err.getMessage());
        }
    }
}
