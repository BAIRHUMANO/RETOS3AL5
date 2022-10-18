package com.example.retos.Service;

import com.example.retos.Model.Boat;
import com.example.retos.Repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boat){
        if (boat.getId()==null){
            return boatRepository.save(boat);
        }else{
            Optional<Boat> boatEncontrado = getBoat(boat.getId());
            if (boatEncontrado.isEmpty()){
                return boatRepository.save(boat);
            }else{
                return boat;
            }
        }

    }

    public Boat update(Boat boat){
        if (boat.getId()!=null){
            Optional<Boat>  boatEncontrado = getBoat(boat.getId());
            if (!boatEncontrado.isEmpty()) {
                if (boat.getName() != null) {
                    boatEncontrado.get().setName(boat.getName());
                }
                if (boat.getBrand() != null) {
                    boatEncontrado.get().setBrand(boat.getBrand());
                }
                if (boat.getYears() != null) {
                    boatEncontrado.get().setYears(boat.getYears());
                }
                if (boat.getDescription() != null) {
                    boatEncontrado.get().setDescription(boat.getDescription());
                }
                if (boat.getCategory() != null) {
                    boatEncontrado.get().setCategory(boat.getCategory());
                }
                return boatRepository.save(boatEncontrado.get());

            }
        }
        return boat;
    }

    public boolean delete(int id){
        Boolean respuesta = getBoat(id).map(elemento ->{
            boatRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }

}
