package users.ranks;

import interfaces.IRank;

import java.util.List;

public abstract class Visitor implements IRank {

    public void readInfo(List<String> listInfo) {    }

    public String writeInfo(String info) {
        return null;
    }
}
