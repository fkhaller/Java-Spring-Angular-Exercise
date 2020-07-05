package com.haller.ISBN.Verifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    
        static VerifierController controller;
        private final String FAIL_13ISBN_10ISBN = "FAIL,978-3-16-148410-0,1861972717";
        private final String RESPONSE_TO_VALIDATE = "[{\"isISBN10\":false,\"isISBN13\":false},{\"isISBN10\":false,\"isISBN13\":true},{\"isISBN10\":true,\"isISBN13\":false}]";
    
        @BeforeAll
        static void init(){
            controller = new VerifierController();
        }
        
	@Test
	void contextLoads() {
	}
        
        @Test
        void validateISBN() throws JsonProcessingException {
            String result = controller.verifyISBN(FAIL_13ISBN_10ISBN);
            Assertions.assertEquals(result, RESPONSE_TO_VALIDATE);
        }

}
