package converter;

import java.math.BigInteger;

public class Converter {

    public String fromAnyBase(int sourceBase, int targetBase, String sourceNumber) {

        if (sourceNumber.equals("0")) {
            return "0";
        }

        StringBuilder finalLetter = new StringBuilder();
        sourceNumber = sourceNumber.toUpperCase();

        BigInteger bigInteger = new BigInteger("0");

            int counter = sourceNumber.length() - 1;

            for (int i = 0; i < sourceNumber.length(); i++) {
                BigInteger pow = new BigInteger(String.valueOf(sourceBase)).pow(counter);
                if (sourceNumber.charAt(i) >= '0' && sourceNumber.charAt(i) <= '9') {
                    bigInteger = bigInteger.add(new BigInteger(String.valueOf(sourceNumber.charAt(i) - 48)).multiply(pow));
                }
                if (sourceNumber.charAt(i) >= 'A' && sourceNumber.charAt(i) <= 'Z') {
                    bigInteger = bigInteger.add(new BigInteger(String.valueOf(sourceNumber.charAt(i) - 55)).multiply(pow));
                }
                counter--;
            }

        BigInteger quotient = bigInteger;

        while (quotient.compareTo(BigInteger.valueOf(0)) > 0 ) {
            BigInteger mod = quotient.mod(new BigInteger(String.valueOf(targetBase)));
            if (mod.compareTo(BigInteger.valueOf(9)) > 0) {
                finalLetter.append(Character.toString(Integer.parseInt(String.valueOf(mod)) + 55));
            } else {
                finalLetter.append(mod);
            }
            quotient = quotient.divide(new BigInteger(String.valueOf(targetBase)));
        }
            return String.valueOf(finalLetter.reverse());
        }
    }
