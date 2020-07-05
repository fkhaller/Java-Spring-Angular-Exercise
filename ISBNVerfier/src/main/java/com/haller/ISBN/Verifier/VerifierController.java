package com.haller.ISBN.Verifier;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.validator.routines.ISBNValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Forrest
 */
@RestController
@RequestMapping("/api")
public class VerifierController {
    
    //pass in a comma seperated list of possible isbn strings return json of results
    @RequestMapping("/verifyISBN")
    public @ResponseBody String verifyISBN(@RequestParam(name = "isbns") String isbns) throws JsonProcessingException {
        
        List<VerificationResponse> response = new ArrayList<VerificationResponse>();
        
        for (String isbn : isbns.split(",")) {
            VerificationResponse partialResponse = new VerificationResponse();
            partialResponse.ISBN = isbn;
            partialResponse.isISBN10 = ISBNValidator.getInstance(false).isValidISBN10(isbn);
            partialResponse.isISBN13 = ISBNValidator.getInstance(false).isValidISBN13(isbn);

            response.add(partialResponse);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(response);
    }
    
}
