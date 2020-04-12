package himanshu.springframework.himanshupetclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {

    public Set<T> findAll();

    public T save(T object);

    public T finById(ID id);

    public void delete(T object);

    public void deleteById(ID id);

}
