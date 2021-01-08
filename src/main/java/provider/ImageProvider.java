package provider;

import exception.config.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageProvider extends ContentProvider{

    @Override
    public byte[] provide(String uri) throws IOException, ConfigurationException {
        Path path = Paths.get(persist.getRootDir() + File.separatorChar +
                "images" + File.separatorChar + uri);

        if(!Files.exists(path)) {notFound=true; return "".getBytes();}
        return Files.readAllBytes(path);
    }
}
