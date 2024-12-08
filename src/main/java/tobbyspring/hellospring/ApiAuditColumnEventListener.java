package tobbyspring.hellospring;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
public class ApiAuditColumnEventListener implements PreInsertEventListener, PreUpdateEventListener {


    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        Object entity = preInsertEvent.getEntity();
        preEventProcessing(entity);
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        Object entity = preUpdateEvent.getEntity();
        preEventProcessing(entity);
        return false;
    }

    private void preEventProcessing(Object entity) {
        System.out.println(">>>>>>>>>>> API Event Listener");
    }

}
