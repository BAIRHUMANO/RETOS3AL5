package com.example.retos.Repository.crudRepository;

import com.example.retos.Model.Reservation;
import com.nimbusds.jose.shaded.json.writer.CollectionMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Date;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    /* Estos comentarios no afecta el funcionamiento de los metodos que vamos a hacer
     * Reporte 1
     *
     * SELECT * FROM Reservation WHERE startDate AFTER fechaA AND devolutionDate BEFORE fechaB;
     *
     */
     public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);
    /*
     * Reporte 2
     *
     * SELECT * FROM Reservation WHERE status = "valorQueNecesito";
     *
     */
     public List<Reservation> findAllByStatus(String status);

     /*
      * Reporte 3
      *
      * SELECT client COUNT(client) FROM Reservation GROUP BY client ORDER BY COUNT(client) DESC;
      *       [ valor1,     valor2 ] List<Objet[]>
              [ valor3,     valor4 ]
      */
     @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
     public List<Object[]> getTotalReservationsByClient();

    //* public List<Object[]> getTotalReservationsByCabin();


}
