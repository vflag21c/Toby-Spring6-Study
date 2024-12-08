package tobbyspring.hellospring;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateListenerConfig {

    private final EntityManagerFactory emf;

    public HibernateListenerConfig(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @PostConstruct
    void init() {
        SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

//        registry.appendListeners(EventType.PRE_INSERT, BatchAuditColumnEventListener.class);
//        registry.appendListeners(EventType.PRE_UPDATE, new BatchAuditColumnEventListener.class);
        registry.appendListeners(EventType.PRE_INSERT, ApiAuditColumnEventListener.class);
        registry.appendListeners(EventType.PRE_UPDATE, ApiAuditColumnEventListener.class);
    }
}
