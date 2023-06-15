package com.calendly.calendly.Model;

import com.calendly.calendly.View.Dialog;

public class InputCheck {

    public InputCheck() { }

    public boolean checkFloat(String newValue) {
        try {
            Double.parseDouble(newValue);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean checkLettersNumbersUnderscore(String value) {
        if (value.length() < 3)
            return false;

        if (!value.matches("[a-zA-Z0-9_ ]+[a-zA-Z0-9_ ]"))
            return false;

        return true;
    }

    public boolean checkNameLastname(String newValue) {
        if (newValue.length() < 3)
            return false;

        if (!newValue.matches("[a-zA-Z ]+[a-zA-Z ]")) {
            System.out.println("match -> false: " + newValue);
            return false;
        }

        return true;
    }

    public boolean checkDate(String value) {
        if (value.length() == 0)
            return false;

        if (!value.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            return false;
        }

        return true;
    }

    public boolean checkInt(String newValue) {
        if (newValue.matches("[0-9]+[0-9]*")) {
            return true;
        }
        return false;
    }

    public boolean checkEmail(String newValue) {
        if (newValue.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}")) {
            return true;
        }

        return false;
    }
}
