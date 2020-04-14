import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {

    public static DataProperties properties;
    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect(properties.getDatabaseUrl(),
            properties.getDatabaseLogin(), properties.getDatabasePassword());
    private static final String DATABASE = "selenium";

    static {
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point) {
        INFLXUDB.write(point);
    }
}