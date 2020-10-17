package utils;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    public static void main(String[] args) {
        String s = "GET /hello.htm HTTP/1.1";
        boolean val = s.matches("^GET /[a-zA-z0-9./]* HTTP/[0-9].[0-9]$");
        assertTrue(false, "naaaay");
    }
}
