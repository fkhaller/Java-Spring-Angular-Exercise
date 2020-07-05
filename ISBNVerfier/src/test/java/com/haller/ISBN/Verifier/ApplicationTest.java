package com.haller.ISBN.Verifier;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
    
        private final String FAIL_13ISBN_10ISBN = "isbns=FAIL,978-3-16-148410-0,1861972717";
        private final String RESPONSE_TO_VALIDATE = "[{\"isISBN10\":false,\"isISBN13\":false,\"isbn\":\"FAIL\"},{\"isISBN10\":false,\"isISBN13\":true,\"isbn\":\"978-3-16-148410-0\"},{\"isISBN10\":true,\"isISBN13\":false,\"isbn\":\"1861972717\"}]";
        private final String VERIFICATION_ENDPOINT = "/api/verifyISBN/";
    
        @Autowired
	private TestRestTemplate restTemplate;
        
        @Test
	public void isbnVerificationTest() throws Exception {
		String body = this.restTemplate.getForObject(VERIFICATION_ENDPOINT + "?" + FAIL_13ISBN_10ISBN, String.class);
                assertThat(body).isEqualTo(RESPONSE_TO_VALIDATE);
	}

}
