package uk.co.unitycoders.fracture.storage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Created by webpigeon on 12/01/14.
 */
public class JPAFactory {
    private static final String PERSISTENCE_UNIT_NAME = "UC-FRACTURE-RPG";

    public static EntityManagerFactory buildFactory() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

}
