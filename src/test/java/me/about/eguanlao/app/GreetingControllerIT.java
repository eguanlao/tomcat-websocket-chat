package me.about.eguanlao.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIT {

  @LocalServerPort
  private int port;

  private URL url;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Before
  public void setUp() throws MalformedURLException {
    this.url = new URL("http://localhost:" + port + "/greeting");
  }

  @Test
  public void should_return_a_greeting() {
    final ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url.toString(),
        String.class);

    assertThat(responseEntity.getBody()).isEqualTo("Greetings from Spring Boot!");
  }

}
