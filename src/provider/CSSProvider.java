package provider;

import exception.config.InvalidRootDirException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSSProvider extends ContentProvider{

    @Override
    public byte[] provide(String uri) throws InvalidRootDirException, IOException {
        Path path = Paths.get(persist.getRootDir() + File.separatorChar +
                "css" + File.separatorChar + uri);

        if(!Files.exists(path)) return "".getBytes();
        return Files.readAllBytes(path);
    }
}
