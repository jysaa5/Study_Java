package graph.ex.extract.data;

import java.util.HashMap;
import java.util.LinkedList;

// 문제: 회사에 여러 개의 프로젝트가 있는데, 어떤 프로젝트들은 특정 프로젝트가 완료되어야만 진행 할 수 있는 프로젝트가 있다.
// 프로젝트의 목록과 각 프로젝트간의 의존여부를 넘겨주면 의존도에 입각한 프로젝트의 진행순서를 반환하는 함수를 구현하시오.

// 예시: Projects: a, b, c, d, e, f, g
//      dependencies: (f, a), (f, b), (f, c), (b, a), (c, a), (a, e), (b, e), (d, g)
// (f, a): 앞에 있는 f가 실행 되어야 뒤에 있는 a가 실행된다는 의미이다.

// Graph를 자료구조에 저장하는 방법: 1. Matrix (매트릭스) 2. Linked List (연결 리스트)

// Solution: 연결리스트로 그래프 저장하기. 
// 1. 프로젝트들을 LinkedList에 저장한다. 
/* | a | -> f -> b -> c
 * | b | -> f
 * | c | -> f
 * | d | 
 * | e | -> a -> b
 * | f | 
 * | g | -> d
 * 
 * 
 * 2. 프로젝트 개수만큼 배열 방 만들기
 * 3. 함수 만들기 = F()
 * 
 * 4. 함수 호출
 * F(a) -> F(f)
 * F(b)
 * F(c)
 * F(d)
 * F(e)
 * F(g)
 * 
 * | f | b | c | a | d | e | g |
 * 
 * */

// project 클래스
class Project {
	
	// 프로젝트 이름
	private String name; 
	
	// 먼저 처리 되어야 할 프로젝트를 저장하는 연결리스트 선언
	private LinkedList<Project> dependencies;
	
	// 순서를 정할 때, 배열에 담았는지 여부를 체크하는 변수
	private boolean marked;
	
	// 생성자
	public Project(String name) {
		this.name = name;
		// 마킹 플래그는 false로 초기화
		this.marked = false;
		this.dependencies = new LinkedList<Project>();
	}
	
	// addDependency 메서드: 의존관계를 추가해주는 함수
	public void addDependency(Project project) {
		
		// 먼저 처리해야되는 프로젝트를 받아서 리스트에 추가
		if(!dependencies.contains(project)) {
			dependencies.add(project);
		}
		
	}// addDependency 메서드 종료
	
	
	// 멤버변수가 private으로 선언했으므로, 각종 데이터를 가져오거나 설정할 public 형식의 메서드 생성
	
	// getDependencies 메서드: dependencies 변수를 가져오는 메서드
	public LinkedList<Project> getDependencies(){
	
		return this.dependencies;
	
	}// getDependencies 메서드 종료
	
	
	// getName 메서드: name 변수를 가져오는 메서드 
	public String getName() {
		
		return this.name;
	
	}// getName 메서드 종료
	
	
	// setMarked 메서드: marked 변수를 설정하는 메서드
	public void setMarked(boolean marked) {
	
		this.marked = marked;
	
	}// setMarked 메서드 종료
	
	
	// getMarked 메서드: marked 변수를 가져오는 메서드
	public boolean getMarked() {
		
		return this.marked;
	
	}// getMarked 메서드 종료
		
}//Project 클래스 종료


// ProjectManager 클래스: 프로젝트를 관리할 클래스 
class ProjectManager{
	
	// 프로젝트를 저장할 해시맵 -> 배열방 대신에 해시맵 사용: 프로젝트 이름으로 검색했을 때, 더 빠르기 때문이다.
	private HashMap<String, Project> projects;
	
	// 생성자
	// names: 이름으로 프로젝트를 만든다.
	// dependencies: 의존도를 프로젝트 노드에 추가한다.
	public ProjectManager(String[] names, String[][] dependencies) {
		buildProjects(names);
		addDependencies(dependencies);
	}
	
	// buildProjects 메서드: 프로젝트를 만드는 함수
	public void buildProjects(String[] names) {
		//프로젝트를 해시맵으로 생성
		projects = new HashMap<String, Project>();
		
		// 프로젝트 이름과 프로젝트 객체를 추가
		for(int i = 0; i < names.length; i++) {
			projects.put(names[i], new Project(names[i]));
		}
		
	}// buildProjects 메서드 종료

	
	// addDependencies 메서드: 의존도를 추가하는 함수 
	public void addDependencies(String[][] dependencies) {
		
		// 의존도 배열을 돈다.
		for(String[] dependency : dependencies) {
			// before: 앞에 것은 먼저 처리
			Project before = findProject(dependency[0]);
			// after: 뒤에 것은 나중에 처리
			Project after = findProject(dependency[1]);
			// 나중에 처리 하는 것에 dependency로 먼저 처리해야 하는 것들을 추가한다.
			after.addDependency(before);
			
		}
		
	}// addDependencies 메서드 종료
	
	
	// 의존성 입각
	
	private int index;
	
	// 프로젝트 순서 정하는 메서드
	public Project[] buildOrder() {
		
		// 마킹 플래그를 초기화
		initMarkingFlages();
		
		// 결과값을 저장할 배열
		Project[] ordered = new Project[this.projects.size()];
		
		index = 0;
		// 프로젝트를 하나씩 돌면서 재귀함수 호출
		for(Project project : this.projects.values()) {
			buildOrder(project, ordered);
		}
		
		// 함수가 끝날때 결과가 저장된 배열방 반환
		return ordered;
		
	}//buildOrder 메서드 종료
	
	//buildOrder 메서드
	public void buildOrder(Project project, Project[] ordered) {
		
		// 호출을 받으면, 먼저 처리해야 하는 프로젝트가 있는지 확인
		if(!project.getDependencies().isEmpty()) {
			
			// 먼저 처리 해야하는 포로젝트가 있을 때.
			for(Project p: project.getDependencies()) {
				buildOrder(p, ordered);
			}
			
		}
		
		// 모든 의존하는 프로젝트가 처리 되었을 때.
		// 결과 배열방에 추가가 되었는지 확인하고 아직 배열방에 추가가 안된 프로젝트이면
		// 마킹 플래그를 true로 설정
		if(project.getMarked() == false) {
			
			project.setMarked(true);
			
			// 배열방에 프로젝트 저장
			ordered[index] = project;
			
			index ++;
			
		}
		
	}//buildOrder 메서드 종료
	
	
	// initMarkingFlages: 순서를 정하기 전에 마킹 플래그를 초기화 해주는 메서드
	private void initMarkingFlages() {
	
		for(Project project : this.projects.values()) {
			project.setMarked(false);
		}
		
	}// initMarkingFlages 메서드 종료
	
	
	// findProject: 프로젝트르 이름으로 프로젝트 객체를 반환하는 메서드
	// 프로젝트를 hash Map으로 선언했으므로 검색시 O(1) 시간이 걸림
	public Project findProject(String name) {
		return projects.get(name);
	}
	
	
}

// Graph_Extract_Data 클래스
public class Graph_Extract_Data {
	
	// main: 메인 실행 함수 
	public static void main(String[] args) {
	
		String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {{"f", "a"}, {"f","b"}, {"f", "c"}, {"b", "a"}, {"c", "a"}, {"a", "e"}, {"b", "e"}, {"d","g"}};
		
		ProjectManager pm = new ProjectManager(projects, dependencies);
		
		Project[] ps = pm.buildOrder();
		
		for(Project p : ps) {
			if(p!= null) {
				System.out.print(p.getName()+" ");
			}
		}
		
		
		
	}// main 메서드 종료
	
	
}// Graph_Extract_Data 클래스 종료
