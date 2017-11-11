package sample.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class ReactorController {

    @GetMapping(value = "/syncOk", produces = {APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<SampleResponseDto> syncOk() {
        return ResponseEntity.ok(new SampleResponseDto());
    }

    @GetMapping(value = "/syncNotFound", produces = {APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<SampleResponseDto> syncNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new SampleResponseDto());
    }

    @GetMapping(value = "/asyncOk", produces = {APPLICATION_JSON_UTF8_VALUE})
    CompletableFuture<ResponseEntity<SampleResponseDto>> asyncOk() {
        return Mono.just(
                ResponseEntity.ok(new SampleResponseDto())
        ).toFuture();
    }

    @GetMapping(value = "/asyncNotFound", produces = {APPLICATION_JSON_UTF8_VALUE})
    CompletableFuture<ResponseEntity<SampleResponseDto>> asyncNotFound() {
        return Mono.just(
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new SampleResponseDto())
        ).toFuture();
    }

    private static class SampleResponseDto {
        final String myBody = "Sample response body";

        public String getMyBody() {
            return myBody;
        }
    }
}
