package p12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
//		System.out.println("A1:");
//		powersOfTwo().forEach(System.out::println);
//		System.out.println();
//
//		System.out.println("A3:");
//		testStream(powersOfTwo(), 4);
//		System.out.println();
//
//		System.out.println("A4:");
//		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
//		System.out.println(Arrays.toString(toArray(list)));
//		System.out.println();
//
//		System.out.println("A5:");
//		System.out.println(Arrays.toString(getRandNumbers(10)));
//		System.out.println();
//
//		System.out.println("A6:");
//		getCharStream("abcdefg").forEach(System.out::println);
//		System.out.println();
//
//		System.out.println("A8:");
//		System.out.println(getMax(new int[] { 1, 2, 3, 5, 33, 2, 44, -5 }));
//		System.out.println();

		System.out.println("A9:");
		System.out.println(Arrays.toString(getPos("banana", 'a')));
		System.out.println();

		System.out.println("A10:");
		long z = 100000000000000181L;
		long start = System.nanoTime();
		boolean prime = isPrimeParallel(z);
		long parallelTime = System.nanoTime() - start;
		start = System.nanoTime();
		isPrimeSerial(z);
		long serialTime = System.nanoTime() - start;

		if (prime) {
			System.out.println(z + " is prime");
		} else {
			System.out.println(z + " is not prime");
		}

		System.out.println("parallel time: " + parallelTime + " ns");
		System.out.println("serial time: " + serialTime + " ns");

		System.out.println("serialtime / paralleltime = " + serialTime * 1.0 / parallelTime);
	}

	public static IntStream powersOfTwo() {
		return IntStream.iterate(1, i -> i * 2).limit(31);
	}

	public static void testStream(IntStream stream, int num) {
		stream.limit(num).forEach(System.out::println);
	}

	public static int[] toArray(ArrayList<Integer> list) {
		return list.stream().mapToInt(i -> i).toArray();
	}

	public static double[] getRandNumbers(int cnt) {
		if (cnt < 0) {
			throw new ArithmeticException();
		}

		return DoubleStream.generate(Math::random).limit(cnt).toArray();
	}

	public static Stream<Character> getCharStream(String s) {
		return IntStream.range(0, s.length()).mapToObj(s::charAt);
	}

	public static int getMax(int[] arr) {
		return Arrays.stream(arr).parallel().max().getAsInt();
	}

	public static int[] getPos(String s, char c) {
		return IntStream.range(0, s.length()).parallel().filter(i -> (s.charAt(i) == c)).toArray();
	}

	public static boolean isPrimeParallel(long z) {
		return LongStream.range(2, ((long) Math.sqrt(z) + 1)).parallel().noneMatch(i -> z % i == 0);
	}

	public static boolean isPrimeSerial(long z) {
		return LongStream.range(2, ((long) Math.sqrt(z) + 1)).noneMatch(i -> z % i == 0);
	}
}
