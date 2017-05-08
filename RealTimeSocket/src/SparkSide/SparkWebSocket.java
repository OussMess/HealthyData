package SparkSide;/* Created by Oussama on 06/05/2017. */


import bridgeSide.SessionData;
import bridgeSide.SessionHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

@ApplicationScoped
@ServerEndpoint("/spark")
public class SparkWebSocket {
    @Inject
    private SessionHandler sessionHandler;

    @OnOpen
    public void open(Session session) {

        System.out.println("open Spark");
    }

    @OnClose
    public void close(Session session) {
        System.out.println("close Spark");
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("Spark "  + error.getMessage());
    }

    @OnMessage
    public void handleMessage(String message, Session session) throws IOException {
        System.out.println(message);
        String[] str = message.split("[:]");
        String data = str[2];
        String[] keys = str[1].split("[;]");
        String time = str[0];
        Set<SessionData> sessionDataSet = sessionHandler.findByKey(keys[0], keys[1], keys[2]);
        if(sessionDataSet == null){
            return;
        }
        for(SessionData sessionData : sessionDataSet){
            sessionData.sendData(time +";" +data);
        }

    }
}
