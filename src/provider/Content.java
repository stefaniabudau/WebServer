package provider;

public class Content {
    private boolean ok;
    private byte[] content;

    public Content(byte[] content, boolean ok){
        this.content = content;
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }

    public byte[] getContent() {
        return content;
    }
}
