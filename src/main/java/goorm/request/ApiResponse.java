package goorm.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import goorm.request.exception.ErrorCode;
import lombok.Getter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Getter
public class ApiResponse<T> {
    private final Status status;
    @JsonInclude(Include.NON_EMPTY)
    private MetaData metadata;
    @JsonInclude(Include.NON_EMPTY)
    private List<T> results;
    @JsonInclude(Include.NON_EMPTY)
    private Object data;

    public ApiResponse(List<T> results) {
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new MetaData(results.size());
        this.results = results;
    }

    public ApiResponse(int code, String message, Object data) {
        this.status = new Status(code, message);
        this.data = data;
    }

    @Getter
    public static class Status {
        private final int code;
        private final String message;

        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    @Getter
    public static class MetaData {
        int resultCount;
        public MetaData(int resultCount) {
            this.resultCount = resultCount;
        }
    }
}
