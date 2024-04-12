package vicenteee.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnector {
    
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE"; // Name of your persistence unit in persistence.xml

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            // Create the EntityManagerFactory using the persistence unit name
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing EntityManagerFactory: " + e.getMessage());
        }
    }

    // Method to get an EntityManager instance
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Method to close the EntityManagerFactory when the application shuts down
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }


}
