package webserver;

public class Response {

    private String message;
    private String contentType;
    private byte[] content;

    public Response(String message, String contentType, byte[] content){
        this.message = message;
        this.contentType = contentType;
        this.content = content;
    }

    public String getMessage() {
        return this.message;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getContent() {
        return this.content;
    }
}
