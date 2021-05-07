package com.ascent.restfulmilktea;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MilkTeaService {
    List<MilkTea> milkTeaList = new ArrayList<>();
    Long nextVal = 0L;

    public List<MilkTea> findAllMilkTeas() {
        return milkTeaList;
    }

    public MilkTea addMilkTea(MilkTea milkTea) {
        milkTea.setId(nextVal++);
        milkTeaList.add(milkTea);
        return milkTea;
    }

    public Long deleteMilkTea(Long id) {
        for (MilkTea milkTea : milkTeaList) {
            if (milkTea.getId().equals(id)) {
                milkTeaList.remove(milkTea);
                return id;
            }
        }
        return -1L;
    }

    public MilkTea getMilkTeaById(Long id) {
        for (MilkTea milkTea : milkTeaList) {
            if (milkTea.getId().equals(id)) {
                return milkTea;
            }
        }
        return null;
    }

    public MilkTea updateMilkTea(MilkTea milkTea, Map<String, Object> fields) {
        fields.forEach((key,value) -> {
            Field field = ReflectionUtils.findField(MilkTea.class, key);
            if (field != null ) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, milkTea, value);
            }
        });
        return milkTea;
    }

}
