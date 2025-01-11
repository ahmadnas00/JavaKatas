package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLShortenerTest {

    @Test
    public void test1(){
        URLShortener shortener = new URLShortener();
        String longUrl1 = "https://www.example.com/some/really/long/url";
        assertEquals("http://short.ly/1",shortener.shorten(longUrl1).toString());

        String longurl2 = "https://www.example.com/some/really/long2/url";
        assertEquals("http://short.ly/2",shortener.shorten(longUrl1).toString());

    }

    @Test
    public void retrievetest(){
        URLShortener shortener = new URLShortener();
        String longUrl1 = "https://www.example.com/some/really/long/url";
        String longUrl2 = "https://www.example.com/some/really/long2/url";

        String shortUrl1 = shortener.shorten(longUrl1);
        String shortUrl2 = shortener.shorten(longUrl2);

        assertEquals("https://www.example.com/some/really/long/url",shortener.retrieve("http://short.ly/1").toString());
        assertEquals("https://www.example.com/some/really/long2/url",shortener.retrieve("http://short.ly/2").toString());



    }
}
