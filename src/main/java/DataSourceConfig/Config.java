package DataSourceConfig;

import Models.Browser;
import Models.Environment;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class Config {

    public Environment environment;
    public Browser browser;

    @JsonAnyGetter
    public Environment getEnvironment() {
        return environment;
    }

    @JsonAnyGetter
    public Browser getBrowser() {
        return browser;
    }
}
