package uk.co.unitycoders.fracture.storage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by webpigeon on 12/01/14.
 */
public class JPAFactory {
    private static final String PERSISTENCE_UNIT_NAME = "UC-FRACTURE-RPG";

    public static EntityManagerFactory buildFactory() {
        Map properties = new HashMap();
        properties.put("javax.persistence.jdbc.url", "jdbc:derby:memory:fracture-test;create=true");

        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
    }

}
