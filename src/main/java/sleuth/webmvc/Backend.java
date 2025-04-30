package sleuth.webmvc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Backend {
  Logger logger = LoggerFactory.getLogger(Backend.class);
  @RequestMapping("/api")
  public String printDate(@RequestHeader(name = "user_name", required = false) String username) {
    logger.info("Backend Server Called");
    if (username != null) {
      return new Date().toString() + " " + username;
    }
    return new Date().toString();
  }

  public static void main(String[] args) {
    SpringApplication.run(Backend.class,
        "--spring.application.name=backend",
        "--server.port=9000"
    );
  }
}
