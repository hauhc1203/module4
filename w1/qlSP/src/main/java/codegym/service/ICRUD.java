package codegym.service;

import java.util.ArrayList;

public interface ICRUD<E> {
     ArrayList<E> getAll();
     E findByID(int id);
     E findByName(String name);
     int getIndex(int id);

}
