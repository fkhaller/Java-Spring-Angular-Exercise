package com.haller.ISBN.Verifier;

/**
 *
 * @author Forrest
 */
public class VerificationResponse {
    
    boolean isISBN10;
    boolean isISBN13;
    
    public VerificationResponse() {
        isISBN10 = false;
        isISBN13 = false;
    }

    public boolean isIsISBN10() {
        return isISBN10;
    }

    public void setIsISBN10(boolean isISBN10) {
        this.isISBN10 = isISBN10;
    }

    public boolean isIsISBN13() {
        return isISBN13;
    }

    public void setIsISBN13(boolean isISBN13) {
        this.isISBN13 = isISBN13;
    }
    
}
