package app.storage;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class KeyStorage {

    List<String> stringList = new ArrayList<>();

    public void addKey (String key) {
        stringList.add(key);
    }

    public boolean keyExists (String key) {
        return stringList.contains(key);
    }
    public List<String> getAllKeys () {
        return stringList;
    }
}
