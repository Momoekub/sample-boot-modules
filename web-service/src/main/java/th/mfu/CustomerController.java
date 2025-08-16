package th.mfu;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import th.mfu.dto.CustomerDto;
import th.mfu.dto.SaleOrderDto;
import th.mfu.mapper.CustomerMapper;
import th.mfu.mapper.SaleOrderMapper;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private SaleOrderRepository orderRepo;
    
    @Autowired
    private CustomerMapper customerMapper;
    
    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id){
        if(!custRepo.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Optional<Customer> customer = custRepo.findById(id);
        CustomerDto customerDto = customerMapper.toDto(customer.get());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}/orders")
    public ResponseEntity<List<SaleOrderDto>> getOrdersForCustomer(@PathVariable Long id) {
        if (!custRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<SaleOrder> orders = orderRepo.findByCustomerId(id);
        List<SaleOrderDto> orderDtos = saleOrderMapper.toDtoList(orders);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<Collection<CustomerDto>> getAllCustomers(){
        List<Customer> customers = custRepo.findAll();
        List<CustomerDto> customerDtos = customerMapper.toDtoList(customers);
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @GetMapping("/customers/name/{prefix}")
    public ResponseEntity<Collection<CustomerDto>> searchCustomerByName(@PathVariable String prefix){
        List<Customer> results = custRepo.findByNameStartingWith(prefix);
        List<CustomerDto> customerDtos = customerMapper.toDtoList(results);
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerMapper.toEntity(customerDto);
        custRepo.save(customer);
        return new ResponseEntity<>("Customer created", HttpStatus.CREATED);
    }

    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        custRepo.deleteById(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
    }

    // @PatchMapping("/customers/{id}")
    // public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
    //     if (!custRepo.existsById(id)) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
        
    //     Optional<Customer> existingCustomerOpt = custRepo.findById(id);
    //     Customer existingCustomer = existingCustomerOpt.get();
        
    //     // Use mapper to update only non-null fields
    //     customerMapper.updateEntityFromDto(customerDto, existingCustomer);
    //     Customer savedCustomer = custRepo.save(existingCustomer);
        
    //     CustomerDto updatedCustomerDto = customerMapper.toDto(savedCustomer);
    //     return new ResponseEntity<>(updatedCustomerDto, HttpStatus.OK);
    // }

}

