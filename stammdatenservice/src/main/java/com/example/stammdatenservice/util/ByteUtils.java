package com.example.stammdatenservice.util;

import com.example.stammdatenservice.StammdatenserviceApplication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ByteUtils {

    public List<Long> byteArrayToLongList(byte[] byteArray) {
        List<Long> longList = new ArrayList<>();
        if (byteArray != null && byteArray.length > 0) {
            String idString = new String(byteArray, StandardCharsets.UTF_8);
            String[] idArray = idString.split(",");

            for (String id : idArray) {
                longList.add(Long.parseLong(id.trim()));
            }
        }
        return longList;
    }

}
