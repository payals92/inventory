import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.*;

class EvenNumberPrinter implements Callable<String> {
    public String call() {
        return null;
    }
}

class OddNumberPrinter implements Callable<String> {
    public String call() {
        return null;
    }
}

class Solution {
    public static int a = 0;
    public static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> poojaPayal = new Callable<String>() {
            @Override
            public String call() throws Exception {
                synchronized (this) {
                    Solution.map.put("Pooja Payal", 26);
                }

                return "Pooja payal";
            }
        };


      ExecutorService es = Executors.newFixedThreadPool(10);
      Future<String> poojaPayalFuture = es.submit(poojaPayal);
      Future<String> poojaPayalFuture = es.submit(poojaPayal);
      Future<String> poojaPayalFuture = es.submit(poojaPayal);
      Future<String> poojaPayalFuture = es.submit(poojaPayal);



      System.out.println(poojaPayalFuture.get());
    }
}

class ErrorResponseMessageException extends Exception{
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private HttpStatus httpStatus;

    public ErrorResponseMessageException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}