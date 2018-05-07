package uz.zgora.pl.raspberry.api;

public class CommonResponse {
    private final int status;
    private final String message;

    public CommonResponse(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
