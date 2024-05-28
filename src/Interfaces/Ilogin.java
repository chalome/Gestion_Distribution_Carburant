package Interfaces;

import Modeles.*;

public interface Ilogin {

    public boolean isLogin(Employe employe);

    public boolean isGestionnaire(String employe);

    public boolean isChefService(String employe);

    public boolean isAdmin(String employe);
}
