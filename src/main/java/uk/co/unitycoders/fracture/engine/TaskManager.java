package uk.co.unitycoders.fracture.engine;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by webpigeon on 18/01/14.
 */
public class TaskManager {
    private ExecutorService service;
    private EntityManagerFactory emf;

    public TaskManager(EntityManagerFactory emf) {
        this.service = Executors.newCachedThreadPool();
        this.emf = emf;
    }

    public void addTask(Task task) {
        service.submit(task);
        task.setManager(emf.createEntityManager());
    }
}
