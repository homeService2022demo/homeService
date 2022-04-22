package com.example.data.entity;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author fh.kazemi
 **/
public class TrackingCode {
    public static String generate(){
        return  new BigInteger
                (130, new SecureRandom()).toString(32);
        /*String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        this.orderTackingCode = IntStream.range(0, 10)
                .map(i -> new SecureRandom().nextInt(characterSet.length()))
                .mapToObj(randomInt -> characterSet.substring(randomInt, randomInt + 1))
                .collect(Collectors.joining());*/
    }
}
