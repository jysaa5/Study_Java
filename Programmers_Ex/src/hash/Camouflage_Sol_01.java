package hash;

import java.util.HashMap;


// 문제: 위장
/*
문제 설명
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경,
 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류 | 이름
얼굴 | 동그란 안경, 검정 선글라스
상의 |파란색 티셔츠
하의 |청바지
겉옷 |긴 코트

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.

입출력 예
clothes	return
[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3

입출력 예 설명
예제 #1
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이
 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

예제 #2
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup
*/
/* 
솔루션: 
이 문제에서 필요한 것은 옷 종류의 개수가 몇 가지 있는지이다.
따라서 옷 종류의 이름은 쓸모 없는 값이다.
{옷 종류}:{총 개수}와 같은 형태로 매칭되어야 하므로, key:Value 형태와 비슷하다고 생각해서
HashMap을 사용하였다.
HashMap을 사용하면 이미 있는 종류인지 파악하는 key 검색이 빠르고, key 검색이 빠르기 때문에 그에 따른
value 업데이트도 빠르다.

경우의 수를 구하는 공식은 4종류의 옷과 그 옷이 {n, m, o, p}의 개수로 있을 때 아래와 같다.
(n+1)*(m+1)*(o+1)*(p+1) -1
각 종류들은 하나를 입거나 안 입거나의 선택지가 있기 때문에 옷의 개수에 안 입는 선택지를 하나 추가한다.
그리고 옷을 고르는 선택은 동시에 일어나는 일이기 때문에 각 옷들을 곱해 경우의 수를 계산한다.
이 때, 하나도 안 입은 선택지는 없으므로 그 경우의 수를 하나를 뺀다. 
 
*/
class Camouflage_Solution_01 {

	public int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			
			if (map.get(clothes[i][1]) == null) {
			
				map.put(clothes[i][1], 1);
			
			} else {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			}
		}

		for (String keys : map.keySet()) {
			answer *= (map.get(keys) + 1);
		}

		answer -= 1;

		return answer;
	}
}

public class Camouflage_Sol_01 {

	public static void main(String[] args) {
		Camouflage_Solution_01 sol = new Camouflage_Solution_01();
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(sol.solution(clothes));
	}

}
