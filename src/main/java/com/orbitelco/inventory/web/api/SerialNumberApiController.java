package com.orbitelco.inventory.web.api;

import com.orbitelco.inventory.data.common.SerialStatus;
import com.orbitelco.inventory.data.entity.SerialNumber;
import com.orbitelco.inventory.data.entity.SerialNumberKey;
// import com.orbitelco.inventory.data.entity.SerialNumberKey;
import com.orbitelco.inventory.data.repository.SerialNumberRepository;
// import com.orbitelco.inventory.web.exception.BadRequestException;
import com.orbitelco.inventory.web.exception.NotFoundException;

// import com.orbitelco.inventory.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/api/serials")
public class SerialNumberApiController {
  private final SerialNumberRepository serialNumberRepository;

  public SerialNumberApiController(SerialNumberRepository serialNumberRepository) {
    this.serialNumberRepository = serialNumberRepository;
  }

  @GetMapping
  public List<SerialNumber> getAllSerialNumbers(){
    return this.serialNumberRepository.findAll();
  }

  @GetMapping("/status/{status}")
  public List<SerialNumber> getSerialNumbersByStatus(@PathVariable("status") SerialStatus status) {
      return this.serialNumberRepository.findByStatus(status);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SerialNumber addSerialNumber(@RequestBody SerialNumber serialNumber){
    return this.serialNumberRepository.save(serialNumber);
  }

  // @GetMapping("/{productId}/{serialNumber}")
  // public SerialNumber getSerialNumber(@PathVariable("productId") String productId, 
  //                                     @PathVariable("serialNumber") String serialNumber) {
  //   SerialNumberKey id = new SerialNumberKey(productId, serialNumber);
  //   Optional<SerialNumber> serialNumberOptional = this.serialNumberRepository.findById(id);
  //   if (serialNumberOptional.isEmpty()) {
  //     throw new NotFoundException("SerialNumber not found with productId: " + productId +
  //                                 " and serialNumber: " + serialNumber);
  //   }
  //   return serialNumberOptional.get();
  // }

@PutMapping("/{productId}/{serialNumber}")
public SerialNumber updateSerialNumber(@PathVariable("productId") String productId,
                                       @PathVariable("serialNumber") String serialNumber,
                                       @RequestBody SerialNumber updatedSerialNumber) {
    // Construct the composite key
    SerialNumberKey id = new SerialNumberKey(productId, serialNumber);

    // Retrieve the existing entity
    SerialNumber existingSerialNumber = serialNumberRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("SerialNumber not found with productId: " + productId +
                                                 " and serialNumber: " + serialNumber));

    // Update the fields of the existing entity with values from the provided object
    // (except the composite key fields)
    // Example: existingSerialNumber.setSomeField(updatedSerialNumber.getSomeField());

    // Save the updated entity
    return serialNumberRepository.save(existingSerialNumber);
}

  // @DeleteMapping("/{id}")
  // @ResponseStatus(HttpStatus.RESET_CONTENT)
  // public void deleteSerialNumber(@PathVariable("id")String id){
  //   this.serialNumberRepository.deleteById(id);
  // }
}
