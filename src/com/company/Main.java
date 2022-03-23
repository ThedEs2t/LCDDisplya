package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final char Space = ' ', Horizontal = '|', Vertical = '-';
    private static final byte[] BITMAP = {0077, 0024, 0155, 0165, 0126, 0163, 0173, 0025, 0177, 0167};

    private static void run(InputStream input, OutputStream output) {
        Scanner inputScanner = new Scanner(input);
        while (inputScanner.hasNext()) {
            int size = inputScanner.nextInt();
            String number = inputScanner.next();
            if ((size == 0) && number.equals("0")) {
                break;
            }
        }
    }

    private static String getLCD(int size, String number) {
        final int NumberOfChar = number.length();
        String[][] buf = new String[NumberOfChar][];
        for (int i = 0; i < NumberOfChar; i++) {
            buf[i] = getLCD(size, number.charAt(i));
        }
        final int totalHeight = 2 * size + 3;
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < totalHeight; r++) {
            for (int charIndex = 0; charIndex < totalHeight; charIndex++) {
                sb.append(buf[charIndex][r]);
                if (charIndex < NumberOfChar - 1)
                    sb.append(Space);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String[] getLCDDigit(int size, char B) {
        final int totalHeight = 2 * size + 3;
        String[] rows = new String[totalHeight];
        char[] bufChar = new char[size];
        byte bitmap = BITMAP[B - '0'];


        // Верхняя граница
        Arrays.fill(bufChar, (bitmap & 0001) > 0 ? Horizontal : Space);
        StringBuilder sb = new StringBuilder();
        rows[0] = sb.append(Space).append(String.valueOf(bufChar)).append(Space).toString();

    }

    public static void main(String[] args) {
        run(System.in, System.out);
    }
}

