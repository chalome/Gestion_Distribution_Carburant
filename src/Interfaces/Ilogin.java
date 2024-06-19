package Interfaces;

import Modeles.*;

public interface Ilogin {

    public boolean isLogin(Employe employe);

    public boolean isCharroi(String employe);

    public boolean isAgent(String employe);

    public boolean isAdmin(String employe);
}
