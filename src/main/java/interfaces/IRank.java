package interfaces;

import java.util.List;

public interface IRank {
    void readInfo(List<String> listInfo);
    String writeInfo(String info);
    List<String> changeInfo(String info);
}
