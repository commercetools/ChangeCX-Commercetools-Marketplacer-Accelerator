package functions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final String PROPERTIES_FILE = "config.properties";
    public static final java.lang.String CLIENT_ID = "clientId";
    public static final java.lang.String CLIENT_SECRET = "clientSecret";
    public static final java.lang.String PROJECT_KEY = "projectKey";

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        try {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getClientId() {
        String clientId = properties.getProperty(CLIENT_ID);
        if(!clientId) {
            clientId = System.getEnv(CLIENT_ID);
        }
        return clientId;
    }

    public String getSecret() {
        String clientSecret = properties.getProperty(CLIENT_SECRET);
        if(!clientSecret) {
            clientSecret = System.getEnv(CLIENT_SECRET);
        }
        return clientSecret;
    }

    public String getProjectId() {
        String projectKey = properties.getProperty(PROJECT_KEY);
        if(!projectKey) {
            projectKey = System.getEnv(PROJECT_KEY);
        }
        return projectKey;
    }

    public String getMainProductType() {
        return properties.getProperty("mainProductType");
    }

    public String getRootCategory() {
        return properties.getProperty("rootCategory");
    }

    public String getChildCategory() {
        return properties.getProperty("childCategory");
    }
}
