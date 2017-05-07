package ClientSide;

/**
 *
 * @author Oussama Messaoudi
 */


import bridgeSide.SessionData;
import bridgeSide.SessionHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ApplicationScoped
@ServerEndpoint("/measure")

public class ClientWebSocket {

    @Inject
    private SessionHandler sessionHandler;

    @OnOpen
    public void open(Session session) {
        System.out.println("open");
        sessionHandler.addSession(new SessionData(session));
    }

    @OnClose
    public void close(Session session) {
        System.out.println("close");
        sessionHandler.removeSession(session);
    }

    @OnError
    public void onError(Throwable error) {

        System.out.println(error.getMessage());
    }

    @OnMessage
    public void handleMessage(String message, Session session) throws IOException {
        System.out.println(message);
        String[] str = message.split(";");
        SessionData sessionData = sessionHandler.findBySession(session);
        sessionData.setIdPatient(str[0]);
        sessionData.setIdSensor(str[1]);
        sessionData.setIdMeasure(str[2]);
    }
}
