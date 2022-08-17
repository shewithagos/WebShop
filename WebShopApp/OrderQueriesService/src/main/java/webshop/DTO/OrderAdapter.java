package webshop.DTO;


import webshop.domain.Order;

public class OrderAdapter {
    public static Order getOrderFromOrderDTO(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getOrderNumber(),orderDTO.getDate(),orderDTO.getTotalPrice(),
                orderDTO.getProducts(),orderDTO.getCustomer(),orderDTO.getPayment());

        return order;
    }

    public static OrderDTO getOrderDTOFromOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO(order.getOrderNumber(),order.getDate(),order.getTotalPrice(),
                order.getProducts(),order.getCustomer(),order.getPayment());
        return orderDTO;
    }
}
