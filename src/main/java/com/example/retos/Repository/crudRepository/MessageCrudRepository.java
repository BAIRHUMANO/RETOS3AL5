package com.example.retos.Repository.crudRepository;

import com.example.retos.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
