package Interfaces;

import Modeles.Station;
import java.util.List;

public interface IStation {

    public int create(Station station);

    public int update(Station station);

    public int delete(Station station);

    public List<Station> afficherStations();
}
