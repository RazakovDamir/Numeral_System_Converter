package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String checker = "0123456789abcdefghijklmnopqrstuvwxyz";
        String dot = ".";
        boolean isError = false;
        int source = 0;
        if (scanner.hasNextInt()) {
            source = scanner.nextInt();
        } else {
            isError = true;
            System.out.println();
        }
        if(source < 1 || source > 36) {
            isError = true;
        }
        if(isError) {
            System.out.println("Error");
            System.exit(0);
        }
        String n = "";
        if(scanner.hasNext()) {
            n = scanner.next();
        } else {
            isError = true;
        }
        int radix = 0;
        if (scanner.hasNextInt()) {
            radix = scanner.nextInt();
        } else {
            isError = true;
            System.out.println();
        }
        if(radix < 1 || radix > 36) {
            isError = true;
        }
        if(isError) {
            System.out.println("Error");
            System.exit(0);
        }
        for(int i = 0; i < n.length(); i++) {
            String n1 = "";
            String n2 = "";
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '.' || n.charAt(i) == ',') {
                    n1 = n.substring(0, j);
                    n2 = n.substring(n1.length() + 1);
                }
            }
            if(!checker.substring(0,source).contains(n1) && !n.contains(dot)) {
                isError = true;
            }

            if(isError) {
                System.out.println("Error");
                System.exit(0);
            }
            if (n2.length() > 0) {
                frRadix(source, n, radix);
            } else {
                notFrRadix(source, n, radix);
            }
            break;
        }
    }
    public static void notFrRadix(int source, String n, int radix) {
        int k = Integer.parseInt(n);
        if(source == 1 && radix !=10) {
            String number1 = Integer.toString(Integer.parseInt(n));
            int b = number1.length();
            String c = Integer.toString(b, radix);
            System.out.println(c);
        }else if(source == 1){
            String number1 = Integer.toString(Integer.parseInt(n));
            System.out.println(number1.length());
        } else if (radix == 1) {
            while (k > 0) {
                System.out.print("1");
                k--;
            }
        } else {
            System.out.println(Integer.toString(Integer.parseInt(n, source), radix));
        }
    }
    public static void frRadix(int source, String n, int radix) {
        char[] a = new char[n.length()];
        StringBuilder decimals = new StringBuilder();
        String fractional1;
        for (int i = 0; i < n.length(); i++) {
            a[i] = n.charAt(i);
        }
        for (char c : a) {
            decimals.append(c);
            if (c == '.' || c == ',') {
                break;
            }
        }
        String decimals11 = decimals.substring(0, decimals.length() - 1);
        fractional1 = n.substring(decimals11.length() + 1);
        String newdecimals = Integer.toString(Integer.parseInt(decimals11, source), radix);
        int y;
        double decimals1 = 0;
        String[] tz = new String[fractional1.length()];
        String[] k = new String[fractional1.length()];
        for (int i = 0; i < fractional1.length(); i++) {
            k[i] = String.valueOf(fractional1.charAt(i));
        }
        StringBuilder b = new StringBuilder();
        if (source != 10) {
            for(int i = 0; i < fractional1.length(); i++) {
                tz[i] = Integer.toString(Integer.parseInt(k[i], 36), 10);
            }
            double[] x = new double[fractional1.length()];
            for (int i = 0; i < fractional1.length(); i++) {
                y = i + 1;
                x[i] = Integer.parseInt(tz[i]) / Math.pow(source, y);
            }
            for (int i = 0; i < fractional1.length(); i++) {
                decimals1 += x[i];
            }
            double h =  decimals1 * radix;
            int g = (int) h;
            if(g > 9) {
                b.append(Integer.toString(g, radix));
            } else {
                b.append(g);
            }
            double h1 = (h - g) * radix;
            int g1 = (int) h1;
            if(g1 > 9) {
                b.append(Integer.toString(g1, radix));
            } else {
                b.append(g1);
            }
            double h2 = (h1 - g1) * radix;
            int g2 = (int) h2;
            if(g2 > 9) {
                b.append(Integer.toString(g2, radix));
            } else {
                b.append(g2);
            }
            double h3 = (h2 - g2) * radix;
            int g3 = (int) h3;
            if(g3 > 9) {
                b.append(Integer.toString(g3, radix));
            } else {
                b.append(g3);
            }
            double h4 = (h3 - g3) * radix;
            int g4 = (int) h4;
            if(g4 > 9) {
                b.append(Integer.toString(g4, radix));
            } else {
                b.append(g4);
            }
            System.out.println(newdecimals + "." + b);
        } else {
            String fracn = "0." + fractional1;
            String kj = "";
            double h =  Double.parseDouble(fracn) * radix;
            int g = (int) h;
            if(g > 9) {
                kj += Integer.toString(g, radix);
            } else {
                kj += Integer.toString(g);
            }
            double h1 = (h - g) * radix;
            int g1 = (int) h1;
            if(g1 > 9) {
                kj += Integer.toString(g1, radix);
            } else {
                kj += Integer.toString(g1);
            }
            double h2 = (h1 - g1) * radix;
            int g2 = (int) h2;
            if(g2 > 9) {
                kj += Integer.toString(g2, radix);
            } else {
                kj += Integer.toString(g2);
            }
            double h3 = (h2 - g2) * radix;
            int g3 = (int) h3;
            if(g3 > 9) {
                kj += Integer.toString(g3, radix);
            } else {
                kj += Integer.toString(g3);
            }
            double h4 = (h3 - g3) * radix;
            int g4 = (int) h4;
            if(g4 > 9) {
                kj += Integer.toString(g4, radix);
            } else {
                kj += Integer.toString(g4);
            }
            System.out.print(newdecimals + "." + kj);
        }
    }
}
