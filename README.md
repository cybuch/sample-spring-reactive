This is sample Spring Boot reactive app.

The purpose of this is app is to show Zalando Logbook [0] misbehaving with async requests. As mentionted in issue [1] when one
is using e.g. CompletableFuture as controller's return type then the response is broken - it always returns status 200 and it's
stripped of Content-Type header. You can try it by making GET requests to /syncNotFound and /asyncNotFound. It works just perfect
when you disable Logbook Filter.


[0] https://github.com/zalando/logbook
[1] https://github.com/zalando/logbook/issues/143
