package summer.winter.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//문제: 스킬 트리
//주어진 스킬에서 이전 스킬이 없는데 이후 스킬만 있는 경우 스킬 트리에서 제외 된다. 
//예시: Skill = "CBD", Skill_trees = {"BACDE", "CBADF", "AECB", "BDA"}
//BACDE는 C가 B보다 뒤에 있으므로 스킬트리에서 제외 된다.
//CBADF는 C다음 B가 있고 B다음 D가 있으므로 스킬트리가 된다. 
//AECB는 C다음 B가 있으므로 스킬트리가 된다.
//BDA는 C가 없고 B가 있으므로 스킬트리에서 제외된다. 
//그러므로 총 2개의 스킬트리만 가능하다. 

// 솔루션: 스킬트리에서 스킬만 제외하고 모두 다 공란으로 대채 -> 이 생각을 했었는데 어떤 식으로 구현할 지 몰랐었다. 
// ArrayList, iterator, asList, replaceAll 사용 

class Solution_02 {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));

		Iterator<String> it = skillTrees.iterator();

		while (it.hasNext()) {
			
			// skill만 제외하고 나머지를 "" 공란으로 바꾸기 (띄어쓰기나 빈칸이 아님)
			// skill과 replaceAll로 대체된 스킬 트리가 같으면 index = 0 이고 그렇지 않으면 -1을 반환한다. 
			if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
				// skill에 입각한 스킬트리가 아니므로 리스트에서 삭제된다. 
				it.remove();
			}
		}

		// 사용할 수 있는 스킬 트리의 사이즈를 반환 
		answer = skillTrees.size();

		return answer;
	}

}

public class Skill_Tree_Sol_02 {

	public static void main(String[] args) {
		Solution_02 sol = new Solution_02();

		String skill = "CBD";

		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(sol.solution(skill, skill_trees));
	}
}