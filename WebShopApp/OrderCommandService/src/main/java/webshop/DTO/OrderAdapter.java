package webshop.DTO;

import webshop.domain.Order;

public class OrderAdapter {
    public static Order getOrderFromOrderDTO(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getOrderNumber(),orderDTO.getDate(),
                orderDTO.getProducts(),orderDTO.getCustomer());

        return order;
    }

    public static OrderDTO getOrderDTOFromOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO(order.getOrderNumber(),order.getDate(),
                order.getProducts(),order.getCustomer());
        return orderDTO;
    }
}
