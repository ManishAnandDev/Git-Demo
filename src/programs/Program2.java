package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program2 {
	public static double calculateMaxCakeSize(int guests, List<Double> cakes, Map<Double, Integer> cakeSizes) {

		int noOfPieces;

		double currentMaxSize, hopedMaxSize;

		boolean maxedOut = false;

		if (cakes.get(0) == 0) {
			currentMaxSize = cakes.get(1) / guests;
		} else
			currentMaxSize = cakes.get(0);

		for (int i = 1; i < cakes.size() || !maxedOut;) {
			if (i >= cakes.size())
				i = cakes.size() - 1;
			maxedOut = false;
			noOfPieces = (int) (Math.round((Math.floor(cakes.get(i) / currentMaxSize))) - 1);
			// System.out.println(i);
			// System.out.println(noOfPieces);
			if (noOfPieces <= 0) {
				maxedOut = true;
				i += 1;
				continue;
			}
			hopedMaxSize = cakes.get(i) / noOfPieces;
			noOfPieces *= cakeSizes.get(cakes.get(i));

			// System.out.println(hopedMaxSize);

			for (int j = 0; j < cakes.size(); j++) {
				if (j != i)
					noOfPieces += cakeSizes.get(cakes.get(j))
							* (int) (Math.round((Math.floor(cakes.get(j) / hopedMaxSize))));
			}

			// System.out.println(noOfPieces);
			// System.out.println("===========");

			if (noOfPieces >= guests) {
				currentMaxSize = hopedMaxSize;

			} else
				maxedOut = true;
			i += 1;
		}

		return currentMaxSize;
	}

	public static void main(String args[]) {

		Scanner scanner=new Scanner(System.in);
		String noOfTest= scanner.next();
		String[] cakeList =new String[Integer.parseInt(noOfTest)];
		for(int i=0;i<Integer.parseInt(noOfTest);i++)
		{
			cakeList[i]=scanner.next();
		}
		int noOfGuests = Integer.parseInt(scanner.next());
		
		List<Double> cakeArray = new ArrayList<Double>();
		Map<Double, Integer> cakeSizes = new HashMap<Double, Integer>();

		List<String> processedCakeList = new ArrayList<String>();

		if (cakeList.length >= noOfGuests) {

			for (int i = cakeList.length - noOfGuests; i < cakeList.length; i++)
				processedCakeList.add(cakeList[i]);

		} else {
			for (int i = 0; i < noOfGuests - cakeList.length; i++) {
				processedCakeList.add("0");
			}

			for (int i = 0; i < cakeList.length; i++)
				processedCakeList.add(cakeList[i]);

		}

		for (int i = 0; i < processedCakeList.size(); i++) {
			cakeArray.add(
					Integer.parseInt(processedCakeList.get(i)) * Integer.parseInt(processedCakeList.get(i)) * Math.PI);
			if (cakeSizes.get(cakeArray.get(i)) == null) {
				cakeSizes.put(cakeArray.get(i), 0);
			}

			cakeSizes.put(cakeArray.get(i), cakeSizes.get(cakeArray.get(i)) + 1);
		}

		cakeArray = (new ArrayList<Double>(cakeSizes.keySet()));
		Collections.sort(cakeArray);

		System.out.println(calculateMaxCakeSize(noOfGuests, cakeArray, cakeSizes));

	}
}
