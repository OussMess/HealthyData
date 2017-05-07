package bridgeSide;

import bridgeSide.SessionData;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@ApplicationScoped
public class SessionHandler {
    private final Set<SessionData> sessions = new HashSet<>();

    public void addSession(SessionData session) {
        sessions.add(session);
    }
    public void removeSession(Session session){
        sessions.remove(findBySession(session));
    }

    public void sendToAllConnectedSessions(String message) throws IOException {
        for (SessionData session : sessions) {
            try {
                session.getSession().getBasicRemote().sendText(message);
            } catch (IOException e) {
                sessions.remove(session);
            }
        }
    }
    public SessionData findBySession(Session session){
        for (SessionData sessionData : sessions) {
            if(sessionData.getSession() == session){
                return sessionData;
            }
        }
        return null;
    }
    public Set<SessionData> findByKey(String idPatient, String idSensor, String idMeasure){
        Set<SessionData> sessionDataSet = new HashSet<>();
        for(SessionData sessionData : sessions){
            boolean b =sessionData.isTheOne(idPatient, idSensor, idMeasure);
            if(sessionData.isTheOne(idPatient, idSensor, idMeasure)){
                sessionDataSet.add(sessionData);
            }
        }
        return sessionDataSet;
    }
}
