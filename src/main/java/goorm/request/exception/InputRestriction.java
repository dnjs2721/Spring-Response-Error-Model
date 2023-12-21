package goorm.request.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InputRestriction {
    private final int maxGrade;
}
