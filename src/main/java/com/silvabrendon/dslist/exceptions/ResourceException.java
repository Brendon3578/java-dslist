package com.silvabrendon.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceException extends RuntimeException{
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle(("Resource internal server error"));

        return pb;
    }
}
