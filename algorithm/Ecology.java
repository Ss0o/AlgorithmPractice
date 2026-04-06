package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ecology {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int total_cnt = 0;

        while(true) {
            str = br.readLine();
            if(str == null)
                break;
            total_cnt++;
            map.put(str, map.getOrDefault(str,0.0) + 1);
        }
        for(String key : map.keySet()) {
            map.put(key, map.get(key)*100.0/total_cnt);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(String key : keySet) {
            System.out.println(key + " " + String.format("%.4f",map.get(key)));
        }

    }
}
