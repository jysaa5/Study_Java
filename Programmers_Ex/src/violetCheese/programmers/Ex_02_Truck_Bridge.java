package violetCheese.programmers;

import java.util.LinkedList;
import java.util.Queue;

//자료구조 문제
public class Ex_02_Truck_Bridge {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// 들어간 트럭이 다리에서 완전 내려간 시간: truckOutTime[i] = i번째 트럭이 다리에 완전히 올라간 시간 + 다리의 길이
		int[] truckOutTime = new int[truck_weights.length];

		// 트럭이 다리에 있을 때
		Queue<Integer> truckOnBridge = new LinkedList<Integer>();

		// 시간
		int time = 0;
		// 대기하는 트럭에서 맨 앞에 트럭의 순서
		int firstTruck = 0;

		while (true) {

			// 도착한 트럭 제거: 다리에 트럭이 있으면서 && 가장 먼저 들어간 트럭이 다리에서 완전 내려간 시간
			if (!truckOnBridge.isEmpty() && (truckOutTime[truckOnBridge.peek()] == time)) {

				// 가장 먼저 들어간 트럭을 반환하면서 제거하고 다리 무게를 그 만큼 늘림.
				weight += truck_weights[truckOnBridge.poll()];
			}

			// 대기하는 트럭 추가
			if (firstTruck < truck_weights.length && truck_weights[firstTruck] <= weight) {
				truckOnBridge.add(firstTruck);
				truckOutTime[firstTruck] = time + bridge_length;
				weight -= truck_weights[firstTruck];
				firstTruck++;
			}

			time++;
			if (truckOnBridge.isEmpty()) {
				break;
			}

		}

		return time;

	}

	// test
	public static void main(String[] args) {
		int[] truckArray = { 5, 6, 7, 8 };
		System.out.print(solution(8, 12, truckArray));
	}

}
