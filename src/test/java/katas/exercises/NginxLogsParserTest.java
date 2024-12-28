package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NginxLogsParserTest {

    @Test
    public void NginxLogsParsertesting(){
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> parsedLog = NginxLogsParser.parseLog(logEntry);

        assertEquals("122.176.223.47", parsedLog.get("client_ip"));
        assertEquals("05/Feb/2024:08:29:40 +0000", parsedLog.get("date"));
        assertEquals("GET", parsedLog.get("http_method"));
        assertEquals("/web-enabled/Enhanced-portal/bifurcated-forecast.js", parsedLog.get("path"));
        assertEquals("1.1", parsedLog.get("http_version"));
        assertEquals("200", parsedLog.get("status"));
        assertEquals("1684", parsedLog.get("response_bytes"));
        assertEquals("Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00", parsedLog.get("user_agent"));
    }





    @Test
    public void NginxLogsParsernull(){
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(null));

    }

}
