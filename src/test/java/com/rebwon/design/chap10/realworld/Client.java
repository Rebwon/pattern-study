package com.rebwon.design.chap10.realworld;

public final class Client {

    public static void main(String[] args) {
        EmailContent content = new ExternalEmailContent(
            new SecureEmailContent(new BasicEmailContent("msolo021015@gmail.com")));

        System.out.println(content.getContent());
    }
}
