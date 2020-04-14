import com.google.j2objc.annotations.Property;

import javax.annotation.Resource;

@Resource(lookup = "data.properties")
public class DataProperties {

    @Property("testUrl")
    private String testUrl;

    @Property("databaseUrl")
    private String databaseUrl;

    @Property("databaseLogin")
    private String databaseLogin;

    @Property("databasePassword")
    private String databasePassword;

    public String getTestUrl() {
        return testUrl;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseLogin() {
        return databaseLogin;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }
}