package Interfaces;

import Modeles.Service;
import java.util.List;

public interface IService {

    public int create(Service service);

    public int update(Service service);

    public int delete(Service service);

    public List<Service> afficherServices();

}
