package epi.C06Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The first approach I was thinking was to write a function called, findNextPrime and the iterate over
 * it till we find a prime number larger that n. But I think the approach given in book is much simpler one
 */
public class EnumerateAllPrimes {

    public static List<Integer> primes(int n) {
        // ith entry, prime = true, notprime = false
        boolean[] prime = new boolean[n];
        List<Integer> primes = new ArrayList<>();

        Arrays.fill(prime, true);

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                primes.add(i);
                for (int current = i + i; current < n; current += i) {
                    prime[current] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(primes(100));
        System.out.println(primes(20));
        System.out.println(primes(25));

    }
}
