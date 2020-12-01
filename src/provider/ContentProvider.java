package provider;
import config.Persist;
import config.Settings;
import exception.config.InvalidRootDirException;

import java.io.IOException;

public abstract class ContentProvider {

    protected Persist persist = Settings.persist;
    protected boolean notFound = false;

    public abstract byte[] provide(String uri) throws InvalidRootDirException, IOException;

    public boolean isNotFound() {
        return notFound;
    }
}
