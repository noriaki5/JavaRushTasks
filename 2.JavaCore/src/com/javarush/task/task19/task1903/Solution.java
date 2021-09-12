package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        public String getCountryCode() {
            return data.getCountryCode();
        }

        public String getCompany() {
            return data.getCompany();
        }

        public String getContactFirstName() {
            return data.getContactFirstName();
        }

        public String getContactLastName() {
            return data.getContactLastName();
        }

        public int getCountryPhoneCode() {
            return data.getCountryPhoneCode();
        }

        @Override
        public String getName() {
            return String.format("%s, %s", getContactLastName(), getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            return String.format("+%d(%s)%s-%s-%s",
                    getCountryPhoneCode(),
                    (String.format("%010d", data.getPhoneNumber()).substring(0,3)),
                    (String.format("%010d", data.getPhoneNumber()).substring(3,6)),
                    (String.format("%010d", data.getPhoneNumber()).substring(6,8)),
                    (String.format("%010d", data.getPhoneNumber()).substring(8)));
        }

        @Override
        public String getCompanyName() {
            return getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(getCountryCode());
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}