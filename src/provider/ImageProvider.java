package provider;

public class ImageProvider extends ContentProvider{

    public ImageProvider(String resource) {
        super(resource);
    }

    @Override
    public String provide() {
        return null;
    }
}
