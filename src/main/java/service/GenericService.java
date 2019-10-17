package service;

import domain.Persistable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Persistable<PK>, PK extends Serializable> extends Serializable{
    List<T> findAll();
}
