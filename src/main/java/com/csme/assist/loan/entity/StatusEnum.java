package com.csme.assist.loan.entity;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    WAITING,APPROVED,REJECTED;

    private static Map<String, StatusEnum> valueMap;

    public static StatusEnum getValue(String possibleName)
    {
        if (valueMap == null)
        {
            valueMap = new HashMap<String, StatusEnum>();
            for(StatusEnum statusEnum: values())
                valueMap.put(statusEnum.toString(), statusEnum);
        }
        return valueMap.get(possibleName);

    }
}
