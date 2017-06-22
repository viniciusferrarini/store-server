package br.com.slotshop.server.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vinic on 19/06/2017.
 */
public interface CrudService<T, ID extends Serializable> {

    List<T> findAll();

    T findOne(ID id);

    void delete(ID id);

    T save(T entidade);

    void save(List<T> entidadeList);

    T update(T entidade);

    Long count();
}