package provider;

public abstract class ContentProvider {

    protected String resource;

    public ContentProvider(String resource){
        this.resource = resource;
    }

    public abstract String provide();
}
