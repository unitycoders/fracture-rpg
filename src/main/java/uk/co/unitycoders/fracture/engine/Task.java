package uk.co.unitycoders.fracture.engine;

import javax.persistence.EntityManager;

/**
 * Created by webpigeon on 18/01/14.
 */
public interface Task extends Runnable {
    void setManager(EntityManager entityManager);
}
