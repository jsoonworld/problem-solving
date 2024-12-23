package org.platform.inflearn.javaintro.section5.KthBigNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(sc.nextInt());
        }

        Set<Integer> sums = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(j) > numbers.indexOf(i))
                        .flatMap(j -> numbers.stream()
                                .filter(k -> numbers.indexOf(k) > numbers.indexOf(j))
                                .map(k -> i + j + k)))
                .collect(Collectors.toSet());


        // 내림차순 정렬
        List<Integer> result = new ArrayList<>(sums);
        result.sort(Collections.reverseOrder());

        // K번째 값 출력
        if (K <= result.size()) {
            System.out.println(result.get(K - 1));
        } else {
            System.out.println(-1);
        }
    }
}
