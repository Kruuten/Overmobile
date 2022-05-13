package kruten.overmobile.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(int number) {
        Map<String, Integer> map = new HashMap<>();
        map.put("status", number);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
