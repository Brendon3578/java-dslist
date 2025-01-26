package com.silvabrendon.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class GameListNotFoundException extends ResourceException {

    private Long gameListId;

    public GameListNotFoundException(Long gameListId) {
        this.gameListId = gameListId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pb.setTitle("Game List was not found");
        pb.setDetail("There is no list about games with id " + gameListId + ".");

        return pb;

    }
}
