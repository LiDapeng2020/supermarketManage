package com.supermarket.utils;

import com.supermarket.dto.ComboboxData;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ComboboxUtil {
    public static List<ComboboxData> getComboboxDataList(List<? extends Object> list) {
        List<ComboboxData> comboboxData = new ArrayList<>();
        for (Object object : list) {
            try {
                Field idField = object.getClass().getDeclaredField("id");
                Field nameField = object.getClass().getDeclaredField("name");
                //对private的属性的访问
                idField.setAccessible(true);
                nameField.setAccessible(true);
                Integer id = (Integer) idField.get(object);
                String name = (String) nameField.get(object);
                comboboxData.add(new ComboboxData(id, name));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return comboboxData;
    }
}