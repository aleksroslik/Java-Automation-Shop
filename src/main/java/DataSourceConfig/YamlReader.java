package DataSourceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {

    public static Config config;

    public Config getConfig() {
        return config;
    }

    public YamlReader() {
        try {
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            config = om.readValue(new File("src/main/resources/browser.yaml"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
