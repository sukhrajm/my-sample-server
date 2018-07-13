package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copied from tutorial https://cloud.spring.io/spring-cloud-consul/
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
@RestController
@SpringBootApplication
public class MainApplication {

  private static Logger log = LoggerFactory.getLogger(MainApplication.class);
  
  
  @RequestMapping("/testhome")
  public String home() throws Exception {    
    log.info("Home endpoint called");
    return "Hello World from my-sample-app";
  }
  
  @RequestMapping("/badrequest")
  public ResponseEntity notfound() throws Exception {
    return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
  }

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }

}
