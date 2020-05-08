package himanshu.springframework.himanshupetclinic.services.map;

import himanshu.springframework.himanshupetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

    public T save(T object){
        if(object!=null) {
            if (object.getId() == null)
                object.setId(this.getNextId());
            else {
                if(map.get(object.getId()) !=null){
                    throw new RuntimeException("Id Must Be unique");
                };
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T object){
        map.entrySet().removeIf(entry-> entry.getValue().equals(object));
    }

    public Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
