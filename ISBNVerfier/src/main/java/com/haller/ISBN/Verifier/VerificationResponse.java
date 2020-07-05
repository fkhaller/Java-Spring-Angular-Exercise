package com.haller.ISBN.Verifier;

/**
 *
 * @author Forrest
 */
public class VerificationResponse {
    
    String ISBN;
    boolean isISBN10;
    boolean isISBN13;
    
    public VerificationResponse() {
        ISBN = "";
        isISBN10 = false;
        isISBN13 = false;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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
