package org.platform.inflearn.javaintro.section5.KthBigNumber;

import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<String> input = List.of(sc.next().split(" "));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            numbers.add(Integer.parseInt(input.get(i)));
        }

        /**
         * i, j, k의 범위 설정이 잘못됨.
         * j와 k가 항상 i보다 큰 값을 보장하지 않으므로, 잘못된 조합이 포함될 수 있다.
         */
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < N-2; i++) {
            int sum = 0;
            for (int j = 1; j < N-1; j++) {
                for (int k = 2; k < N; k++) {
                    sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    sums.add(sum);
                }
            }
        }

        /**
         * 중복 제거를 위한 Set 사용 이후 처리 문제:
         * 중복된 합은 제거했지만, Set의 값을 리스트로 변환한 뒤에도 정렬 순서가 요구사항에 맞지 않을 수 있음.
         * 내림차순 정렬 후 K번째 값을 출력해야 하는데, 현재는 오름차순으로 정렬하고 result.get(K + 1)을 출력.
         * K번째 값이 존재하지 않을 경우 처리 누락:
         * 코드에서 result.get(K + 1)을 직접 호출하는데, IndexOutOfBoundsException에 대한 처리 없음.
         */
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterSet = sums.iterator();
        while (iterSet.hasNext()) {
            result.add(iterSet.next());
        }
        Collections.sort(result);
        System.out.println(result.get(K + 1));
    }
}
