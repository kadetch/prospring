package ru.kadetch.prospring.ch4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String message) {
        System.out.println("Using digest1");
        digest(message, digest1);
        System.out.println("Using digest2");
        digest(message, digest2);
    }

    public void digest(String message, MessageDigest digest) {
        System.out.println("Using algorithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytesMessage = message.getBytes(StandardCharsets.UTF_8);
        byte[] hashMessage = digest.digest(bytesMessage);
        System.out.println(hashMessage);
    }
}
