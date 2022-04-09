package com.rebwon.java17.try_with_resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class TryWithResourcesExample {

    public static void main(String[] args) {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try (reader) {
            String line = reader.readLine();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
