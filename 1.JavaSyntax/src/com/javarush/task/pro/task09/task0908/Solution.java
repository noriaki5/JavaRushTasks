package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        if (binaryNumber == null)
            return hexNumber;
        if (binaryNumber.length() % 4 == 3) {
            binaryNumber += "000";
        }
        else if (binaryNumber.length() % 4 == 2) {
            binaryNumber += "00";
        }
        else if (binaryNumber.length() % 4 == 1) {
            binaryNumber += "0";
        }
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            String substring = binaryNumber.substring(i, i + 4);
            String element;
            if (substring.equals("0000")) {
                element = "0";
            }
            else if (substring.equals("0001")) {
                element = "1";
            }
            else if (substring.equals("0010")) {
                element = "2";
            }
            else if (substring.equals("0011")) {
                element = "3";
            }
            else if (substring.equals("0100")) {
                element = "4";
            }
            else if (substring.equals("0101")) {
                element = "5";
            }
            else if (substring.equals("0110")) {
                element = "6";
            }
            else if (substring.equals("0111")) {
                element = "7";
            }
            else if (substring.equals("1000")) {
                element = "8";
            }
            else if (substring.equals("1001")) {
                element = "9";
            }
            else if (substring.equals("1010")) {
                element = "a";
            }
            else if (substring.equals("1011")) {
                element = "b";
            }
            else if (substring.equals("1100")) {
                element = "c";
            }
            else if (substring.equals("1101")) {
                element = "d";
            }
            else if (substring.equals("1110")) {
                element = "e";
            }
            else if (substring.equals("1111")) {
                element = "f";
            }
            else {
                return "";
            }
            hexNumber += element;
        }
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        String binaryNumber = "";
        if (hexNumber == null)
            return binaryNumber;
        for (int i = 0; i < hexNumber.length(); i++) {
            String element = Character.toString(hexNumber.charAt(i));
            if (element.equals("0")) {
                binaryNumber += "0000";
            } else if (element.equals("1")) {
                binaryNumber += "0001";
            } else if (element.equals("2")) {
                binaryNumber += "0010";
            } else if (element.equals("3")) {
                binaryNumber += "0011";
            } else if (element.equals("4")) {
                binaryNumber += "0100";
            } else if (element.equals("5")) {
                binaryNumber += "0101";
            } else if (element.equals("6")) {
                binaryNumber += "0110";
            } else if (element.equals("7")) {
                binaryNumber += "0111";
            } else if (element.equals("8")) {
                binaryNumber += "1000";
            } else if (element.equals("9")) {
                binaryNumber += "1001";
            } else if (element.equals("a")) {
                binaryNumber += "1010";
            } else if (element.equals("b")) {
                binaryNumber += "1011";
            } else if (element.equals("c")) {
                binaryNumber += "1100";
            } else if (element.equals("d")) {
                binaryNumber += "1101";
            } else if (element.equals("e")) {
                binaryNumber += "1110";
            } else if (element.equals("f")) {
                binaryNumber += "1111";
            } else {
                return "";
            }
        }
        return binaryNumber;
    }
}
