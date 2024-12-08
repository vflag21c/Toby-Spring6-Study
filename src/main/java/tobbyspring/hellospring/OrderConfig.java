package tobbyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import tobbyspring.hellospring.data.OrderRepository;
import tobbyspring.hellospring.order.OrderService;

@Configuration
@Import({DataConfig.class, HibernateListenerConfig.class, ApiAuditingConfig.class, ApiAuditColumnEventListener.class})
public class OrderConfig {
    @Bean
    public OrderService orderService(JpaTransactionManager transactionManager) {
        return new OrderService(orderRepository(), transactionManager);
    }


    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepository();
    }
}
