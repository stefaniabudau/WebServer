package provider;

import exception.config.InvalidRootDirException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HTMLProvider extends ContentProvider {

    @Override
    public byte[] provide(String uri) throws InvalidRootDirException, IOException {
        Path path = Paths.get(persist.getRootDir() + File.separatorChar +
                "pages" + File.separatorChar + uri);

        if(!Files.exists(path)) {notFound=true; return provide404();}
        return Files.readAllBytes(path);
    }

    public byte[] provide404() throws IOException {
        Path notFound = Paths.get(persist.getNotFoundPage());
        return Files.readAllBytes(notFound);
    }

    public byte[] provideDefault() throws IOException {
        Path def = Paths.get(persist.getDefaultPage());
        return Files.readAllBytes(def);
    }
}
