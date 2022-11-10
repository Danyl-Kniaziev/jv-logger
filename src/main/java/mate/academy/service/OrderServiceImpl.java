package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderServiceImpl implements OrderService {
    public static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called. Params: userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        // NOTE: In production ready code this order identifier should be generated by DB
        // For test purpose we simplify this and return dummy data
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        // NOTE: In production ready code this method should fetch data from DB
        // For test purpose we simplify this method and return dummy data
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        logger.info("Data successful fetched from DB. Params: Params: "
                + "title={}, price={}", iphone.getTitle(), iphone.getPrice());
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        logger.info("Data successful fetched from DB. Params: Params: "
                + "title={}, price={}", macBook.getTitle(), macBook.getPrice());
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        logger.info("Data successful fetched from DB. Params: Params: "
                + "title={}, price={}", xiaomi.getTitle(), xiaomi.getPrice());
        List<Product> products = List.of(iphone, macBook, xiaomi);
        return products;
    }
}
