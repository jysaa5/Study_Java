package thread_ex;

//라면 끓이는 섹션에 버너가 4개가 있다면, 스레드도 4개를 만들어서 라면이 최대 4개까지 동시에 끓여지도록 프로그래밍한다.
public class Thread_RamenProgram {

	public static void main(String args[]) {
		
		try {
		RamenCook ramenCook = new RamenCook(100); //라면의 개수를 임의로 100개를 줘본다.
		//각각의 스레드 
		new Thread(ramenCook, "A").start();
		new Thread(ramenCook, "B").start();
		new Thread(ramenCook, "C").start();
		new Thread(ramenCook, "D").start();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


//인터페이스: Runnable -> run()에서 스레드를 사용
class RamenCook implements Runnable{
	
	//끓여야 할 라면의 수
	private int ramenCount;
	//각 버너의 상태
	private String[] burners = {"_", "_", "_", "_"}; //비어있는 상태
	
	//생성자: 끓일 라면의 개수를 받아온다.
	public RamenCook(int count) {
		ramenCount = count;
	}
	
	
	//스레드가 실행되면 이 부분이 실행된다.
	//스레드에서 진행할 작업을 여기에 정의한다.
	@Override
	public void run() {
		
		//라면이 0이 될때까지 반복
		while (ramenCount>0) {
			
			// 이 안에 있는 블럭은 한번에 한 스레드만 손을 댈 수 있다.
			synchronized(this) {
				//라면 한 개 감소
				ramenCount --;
				
				System.out.println(Thread.currentThread().getName()+":"+ramenCount+"개 남음");
				
				
				
			}
			
			//이부분 코드 개선이 필요하다
			//그리고 버너들 4개 중 빈 것을 찾는다.
			for(int i=0; i<burners.length; i++) {
				if(!burners[i].equals("_")) {
					continue;
				}

			//둘 이상의 스레드가 한 버너를 켜지 못하게 한다.
			synchronized(this) {
				
				//해당 스레드의 이름으로 버너를 차지한다.
				burners[i] = Thread.currentThread().getName();
				System.out.println("                                     "+Thread.currentThread().getName() + ": ["+(i+1)+"]번 버너 ON");
				showBurners();
			}
				
			try {
			//스레드의 sleep은 해당 스레드를 일정 시간 정지하는 것이다.
			//라면 끓이는 시간: 2초
			Thread.sleep(2000);	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			//라면이 다 끓고 나면, 버너를 비우는 구간
			synchronized(this) {
				
				burners[i] = "_";
				System.out.println("                         "+Thread.currentThread().getName()+": ["+(i+1)+ "]번 버너 OFF");
				
				showBurners();
				}
			break;
			
			}

			try {
				//스레드가 다음 라면을 끓이기 까지 0~1.0초까지 랜덤으로 시간이 걸리도록 한다.
				// 이렇게 하면 순서가 어느정도 뒤엉키게 할 수 있다.
				Thread.sleep(Math.round(1000*Math.random()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//실행되는 시점마다 버너들의 상태를 출력한다.
	private void showBurners() {
		String stringToPrint = "                                                   ";
		for(int i=0; i<burners.length; i++) {
			stringToPrint += (" "+burners[i]);
		}
		System.out.println(stringToPrint);
	}
	
}


