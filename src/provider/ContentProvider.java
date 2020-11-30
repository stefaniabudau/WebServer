package provider;
import config.Persist;
import config.Settings;
import exception.config.InvalidRootDirException;

import java.io.IOException;

public abstract class ContentProvider {

    protected Persist persist = Settings.persist;
    public abstract byte[] provide(String uri) throws InvalidRootDirException, IOException;
}
