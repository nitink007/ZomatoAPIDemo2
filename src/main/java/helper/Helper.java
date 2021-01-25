package helper;

import java.util.List;
import java.util.Map;

public class Helper {

    public void convertDtMapToQueryParamMap(List<Map<String, String>> maps) {
        for (Map<String, String> map : maps) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("Key: "+entry.getKey());
                System.out.println("Value: "+entry.getValue());

                if (entry.getKey().equals("queryParams")) {

                }
            }
        }
    }

}
