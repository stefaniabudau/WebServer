package webserver;

import java.util.Objects;

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
        return message;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(message, response.message) &&
                Objects.equals(contentType, response.contentType) &&
                Objects.equals(content, response.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, contentType, content);
    }
}
