package com.silvabrendon.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class GameNotFoundException extends ResourceException {

    private Long gameId;

    public GameNotFoundException(Long gameId) {
        this.gameId = gameId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pb.setTitle("Game was not found");
        pb.setDetail("There is no game with id " + gameId + ".");

        return pb;

    }
}
