/**
 * Title: CheckDigit.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: Lab2
 */
public final class CheckDigit {
/**
 * Compute the UPC's 12th digit (the check digit).
 * @param args The String of UPC.
 */
    public static void main(final String[] args) {
        long input = Long.parseLong(args[0]);
        long k = input % 10;
        long j = input / 10 % 10;
        long i = input / 100  % 10;
        long h = input / 1000 % 10;
        long g = input / 10_000 % 10;
        long f = input / 100_000 % 10;
        long e = input / 1_000_000 % 10;
        long d = input / 10_000_000 % 10;
        long c = input / 100_000_000 % 10;
        long b = input / 1_000_000_000L % 10;
        long a = input / 10_000_000_000L % 10;
        long x = (10 - (3 * a + b + 3 * c
                + d + 3 * e + f + 3 * g + h
                + 3 * i + j + 3 * k) % 10) % 10;
        System.out.println(args[0] + "\r\n" + x);
    }

}
