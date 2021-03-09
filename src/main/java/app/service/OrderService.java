package app.service;

import app.model.Order;
import app.model.Pet;
import app.model.PetStatus;
import app.storage.OrderRepository;
import app.storage.PetRepository;
import app.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService {
;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PetRepository petRepository;

    public void addOrder (Order order) {
        orderRepository.save(order);
    }

    public Optional<Order> getOrderById (long id) {
        return orderRepository.findById(id);
    }

    public boolean deleteOrderById (long id) {
            if (orderRepository.existsById(id)) {
                orderRepository.deleteById(id);
                return true;
        }
            return false;
    }

    public Map<PetStatus, Integer> getQuantityStatus (List<Pet> petList) {
        Map<PetStatus, Integer> statusList = new HashMap<>();
        for (Pet currentPet : petList
             ) {
            statusList.put(currentPet.getPetStatus(), statusList.getOrDefault(currentPet.getPetStatus(), 0) + 1);
        }
        return statusList;

    }
}