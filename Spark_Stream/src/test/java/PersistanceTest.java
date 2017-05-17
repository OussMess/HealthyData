import org.junit.Test;

import static org.junit.Assert.*;

/* Created by Oussama on 15/05/2017. */
public class PersistanceTest {
    @Test
    public void insertInfo() throws Exception {
        Persistance persistance = new Persistance();
        persistance.insertInfo(1454, 576, "m1");
    }

}