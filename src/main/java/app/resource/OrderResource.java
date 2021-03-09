package app.resource;

import app.exceptions.OrderNotFoundException;
import app.model.Order;
import app.model.PetStatus;
import app.service.PetService;
import app.storage.OrderRepository;
import app.storage.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.OrderService;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/store")
public class OrderResource {

    @Autowired
    OrderService orderService;
    @Autowired
    PetService petService;

    @PostMapping (path = "/order")
    public ResponseEntity<String> createOrder (@RequestBody Order order) {
        orderService.addOrder(order);
        return new ResponseEntity<>("Order created", HttpStatus.CREATED);
    }

    @GetMapping (path = "/order/{orderId}")
    public ResponseEntity<Order> getOrderById (@PathVariable ("orderId") long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (path = "/order/{orderId}")
    public ResponseEntity<String> deleteOrderById (@PathVariable ("orderId") long orderId) {
        if (orderService.deleteOrderById(orderId)) {
            return new ResponseEntity<>("Order deleted", HttpStatus.OK);
                   } else {
            return new ResponseEntity<>("Order is not blin found", HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping (path = "/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> getStatusList () {
        Map<PetStatus, Integer> statusList = orderService.getQuantityStatus(petService.getPetList());
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }
}
