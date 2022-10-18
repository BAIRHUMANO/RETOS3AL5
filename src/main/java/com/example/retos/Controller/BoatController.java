package com.example.retos.Controller;

import com.example.retos.Model.Boat;
import com.example.retos.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Boat")

public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }
    @GetMapping("/{id}")     ///     localhost:8080/api/Category/21
    public Optional<Boat> getBoat(@PathVariable("id") int id) { return boatService.getBoat(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) { return boatService.save(boat); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update (@RequestBody Boat boat){
        return boatService.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return boatService.delete(id);
    }

}
