package org.checkoutprocess.Exception;

import java.security.PublicKey;

/**
 *  Throws Exception for the unwanted case
 */
public class PromotionException extends Exception{
    public PromotionException(){
        super();
    }

    public PromotionException(String message){
        super(message);
    }
}
