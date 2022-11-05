package ru.kadetch.prospring.ch4;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
