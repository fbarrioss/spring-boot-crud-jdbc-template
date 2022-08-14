package com.tbp.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class SpringBootCrudJdbcTemplateApplicationTests {

	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory ();
		return new RestTemplate(factory);
	}

	@Test
	public void consultarUsuarioTest() {
		String body = this.restTemplate().getForObject("http://localhost:8080/user/1", String.class);
		assertThat(body,containsString("Barrios"));
	}

}
