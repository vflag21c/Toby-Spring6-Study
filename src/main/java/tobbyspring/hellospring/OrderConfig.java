package tobbyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import tobbyspring.hellospring.order.*;

import javax.sql.DataSource;

@Configuration
@Import({DataConfig.class, HibernateListenerConfig.class, ApiAuditingConfig.class, ApiAuditColumnEventListener.class})
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository(DataSource dataSource) {
        return new JdbcOrderRepository(dataSource);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, PlatformTransactionManager transactionManager) {
        return new OrderServiceImpl(orderRepository);
    }

}
