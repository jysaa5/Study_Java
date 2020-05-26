package hash;

import java.util.Arrays;
import java.util.HashMap;

//자료구조 문제
public class Incomplet_Players {

    //solution1
    //배열과 Arrays 사용.
    //Hash를 사용하지 않고 풀어본 문제이지만, 효율성 테스트에서 다 0점을 받는다. 
    //이유는 for문을 이중으로 사용해서 시간의 복잡도가 O(n*n)이 되버리기 때문이다.
	public static String solution1(String[] participant, String[] completion) {

		String[] p = participant;
		String[] c = completion;
		String[] check = Arrays.copyOf(p, c.length);
		String player = "";

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {

				if (check[i].equals(c[j])) {
					check[i] = "0";
					c[j] = "0";
					break;
				}
			}
		}
		for (int k = 0; k < c.length; k++) {
			if (!check[k].equals("0")) {
				player = check[k];
				break;
			} else if (k == c.length - 1) {
				player = p[p.length - 1];
				break;
			}
		}

		return player;
	}

    //solution2
    //Hash를 사용하지 않고 Array를 사용.	
	public static String solution2(String[] participant, String[] completion) {

		Arrays.sort(participant);
		Arrays.sort(completion);

		int i;

		for (i = 0; i < completion.length; i++) {

			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[i];
	}

    //solution3
    //Hash 사용.
	public static String solution3(String[] participant, String[] completion) {

		String answer = "";
		// 선수 이름 = key, 완주 명단에 있는지 여부 체크를 정수 값 = value
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		// for each문
		// 해쉬맵에 값을 넣는 과정: 중복된 값은 2이고 중복되지 않으면 1이다.
		for (String player : participant) {

			if (hmap.containsKey(player) == true) {

				// 해쉬맵에서 선수 이름의 값을 반환(value) 반환
				int result = hmap.get(player);

				// 해쉬맵에 선수 이름, 값을 넣음
				hmap.put(player, result + 1);
			} else {

				hmap.put(player, 1);
			}
		}

		// 완주한 사람의 value에서 -1을 하여, 0으로 만듦
		for (String player : completion) {
			int result = hmap.get(player);
			hmap.put(player, result - 1);
		}

		// 해쉬맵에서 참가자 이름을 키값으로 value를 가져와서 0이 아닌 키를 찾아낸다.
		for (String player : participant) {
			if (hmap.get(player) != 0) {
				answer = player;
			}
		}

		return answer;
	}

	
    //test
	public static void main(String[] args) {
		String[] participant1 = { "leo", "kiki", "eden" };
		String[] completion1 = { "eden", "kiki" };

		String[] participant2 = { "leo", "kiki", "eden" };
		String[] completion2 = { "eden", "kiki" };

		String[] participant3 = { "leo", "kiki", "eden" };
		String[] completion3 = { "eden", "kiki" };

		System.out.println(solution1(participant1, completion1));
		System.out.println(solution2(participant2, completion2));
		System.out.println(solution3(participant3, completion3));
	}

}
