package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vinic on 19/06/2017.
 */
public abstract class CrudServiceImpl<T, ID extends Serializable> implements CrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public void delete(ID id) {
        preDelete(id);
        getRepository().delete(id);
    }

    @Override
    public T save(T entidade) {
        preSave(entidade);
        return getRepository().save(entidade);
    }

    @Override
    public void save(List<T> entidadeList) {
        getRepository().save(entidadeList);
    }

    @Override
    public T update(T entidade) {
        return getRepository().save(entidade);
    }

    @Override
    public Long count() {
        return getRepository().count();
    }

    protected void preSave(T entidade){
    }

    protected ID preDelete(ID id) {
        return id;
    }

    public String containing(String value) {
        return "%" + value + "%";
    }

    public String containingLowerCase(String value) {
        return "%" + value.toLowerCase() + "%";
    }
}
