import com.datastax.driver.core.Session;
import com.datastax.spark.connector.cql.CassandraConnector;
import com.google.common.base.Optional;
import controllers.SparkController;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import scala.Tuple2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import static com.datastax.spark.connector.CassandraJavaUtil.javaFunctions;

public class Main{

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Syntax: com.datastax.spark.demo.JavaDemo <Spark Master URL> <Cassandra contact point>");
            System.exit(1);
        }

        SparkConf conf = new SparkConf();
        conf.setAppName("Java API demo");
        conf.setMaster(args[0]);
        conf.set("spark.cassandra.connection.host", args[1]);

        SparkController app = new SparkController(conf);
        app.run();
    }






}