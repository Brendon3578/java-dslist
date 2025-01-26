package com.silvabrendon.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class IllegalMoveException extends  ResourceException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Invalid position movement");
        pb.setDetail("Invalid source or destination index to move games of the list.");

        return pb;

    }
}
