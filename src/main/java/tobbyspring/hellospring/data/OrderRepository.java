package tobbyspring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobbyspring.hellospring.order.Order;

public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
            em.persist(order);
    }
}
