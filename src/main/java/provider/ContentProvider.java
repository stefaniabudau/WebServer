package provider;
import config.Persist;
import config.Settings;
import exception.config.ConfigurationException;

import java.io.IOException;

public abstract class ContentProvider {

    protected Persist persist = Settings.persist;
    protected boolean notFound = false;

    public abstract byte[] provide(String uri) throws IOException, ConfigurationException;

    public boolean isNotFound() {
        return notFound;
    }
}
