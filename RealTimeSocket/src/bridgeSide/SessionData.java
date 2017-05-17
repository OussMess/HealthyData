package bridgeSide;

import javax.websocket.Session;
import java.io.IOException;

public class SessionData {
    private Session session;
    private String idPatient;
    private String idSensor;
    private String idMeasure;

    public SessionData(Session session) {
        this.session = session;
    }
    public void SetIds(String idPatient, String idSensor, String idMeasure){
        this.idPatient = idPatient;
        this.idSensor = idSensor;
        this.idMeasure = idMeasure;
    }

    public Session getSession() {
        return session;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public void setIdMeasure(String idMeasure) {
        this.idMeasure = idMeasure;
    }

    public boolean isTheOne(String idPatient, String idSensor, String idMeasure){
        if(this.idPatient.equals(idPatient) && this.idMeasure.equals(idMeasure) && this.idSensor.equals(idSensor)){
            return true;
        }
        return false;
    }
    public void sendData(String message){
        try {
            System.out.println(message);
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
