package summer.winter.coding;

// 문제: 스킬 트리
// 주어진 스킬에서 이전 스킬이 없는데 이후 스킬만 있는 경우 스킬 트리에서 제외 된다. 
// 예시: Skill = "CBD", Skill_trees = {"BACDE", "CBADF", "AECB", "BDA"}
// BACDE는 C가 B보다 뒤에 있으므로 스킬트리에서 제외 된다.
// CBADF는 C다음 B가 있고 B다음 D가 있으므로 스킬트리가 된다. 
// AECB는 C다음 B가 있으므로 스킬트리가 된다.
// BDA는 C가 없고 B가 있으므로 스킬트리에서 제외된다. 
// 그러므로 총 2개의 스킬트리만 가능하다. 

// 솔루션: 문자열에서 문자가 위치하는 인덱스 비교 

class Solution_01{

	public int solution(String skill, String[] skill_trees) {
		
		// 일단 전체 스킬트리를 모두 사용할 수 있다고 가정하고 대입
		int answer = skill_trees.length;
		
		int beforeIdx = 0;
		
		int currentIdx = 0;
		
		for(int i=0; i<skill_trees.length ; i++) {
			
			beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
			
			for(int j=1; j<skill.length(); j++) {
				
				currentIdx = skill_trees[i].indexOf(skill.charAt(j));
				
				
				// 스킬로 사용할 수 없는 것을 전체 스킬트리에서 감소 시키기
				// 이전 스킬보다 이후 스킬이 먼저 스킬트리에서 나오고 이후 스킬이 존재할 경우
				// 이전 스킬이 없는데 이후 스킬이 있는 경우 
				if(((beforeIdx > currentIdx) && currentIdx != -1) || ((beforeIdx == -1) && (currentIdx != -1))) {
					answer--;
					break;
				}
				
				beforeIdx = currentIdx;
				
			}
			
		}
		
		
		
		
		return answer;
	}

}

public class Skill_Tree_Sol_01 {

	public static void main(String[] args) {
		
		Solution_01 sol = new Solution_01();
		
		String skill = "CBD";
		
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(sol.solution(skill, skill_trees));

	}
}
