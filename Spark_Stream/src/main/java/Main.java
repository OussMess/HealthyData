

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;



// nc -lk 9999


public class Main {
    static WebSocket websocket;

    private static final Pattern END_LINE = Pattern.compile(" ");

    public static void main(String[] args) {
        setSocket();
        setSpark();


    }

    public static void setSpark() {
        SparkConf sparkConf = new SparkConf().setAppName("JavaNetworkWordCount");
        sparkConf.setMaster("local[2]");
        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);

        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(1));

        JavaReceiverInputDStream<String> lines = ssc.socketTextStream(
                "localhost", Integer.parseInt("9999"), StorageLevels.MEMORY_AND_DISK_SER);

        JavaDStream<String> dataBrut = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String x) {
                return Arrays.asList(END_LINE.split(x)).iterator();
            }
        });
        JavaPairDStream<String, Integer> data = dataBrut.mapToPair(
                new PairFunction<String, String, Integer>() {
                    @Override
                    public Tuple2<String, Integer> call(String s) {
                        String str[] = s.split(":");
                        return new Tuple2<>(str[0], Integer.parseInt(str[1]));
                    }
                }).
                reduceByKey(new Function2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer i1, Integer i2) throws Exception {
                        return (i1 + i2) / 2;
                    }
                });
        data.map(new Function<Tuple2<String, Integer>, Object>() {
            @Override
            public Object call(Tuple2<String, Integer> tuple) throws Exception {
                websocket.sendText(System.currentTimeMillis() +":"+ tuple._1 +":" + tuple._2);
                return null;
            }
        }).print();
        data.print();
        ssc.start();
        try {
            ssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setSocket() {
        try {
            websocket = new WebSocketFactory().createSocket("ws://localhost:8080/RealTimeSocket/spark")
                    .addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket ws, String message) {
                            System.out.println("Received msg: " + message);
                        }
                    })
                    .connect();
        } catch (WebSocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
