package lesson5.prefix.sums;

import java.util.HashMap;

// 문제: GenomicRangeQuery
/*
Find the minimal nucleotide from a range of sequence DNA.

A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
which correspond to the types of successive nucleotides in the sequence. 
Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and
T have impact factors of 1, 2, 3 and 4, respectively.
You are going to answer several queries of the form: What is the minimal impact factor of
nucleotides contained in a particular part of 
the given DNA sequence?
The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained 
in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), 
whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T,
whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides,
in particular nucleotide A whose impact factor is 1, so the answer is 1.

Write a function:
class Solution { public int[] solution(String S, int[] P, int[] Q); }
that, given a non-empty string S consisting of N characters and two non-empty arrays
P and Q consisting of M integers, 
returns an array consisting of M integers specifying the consecutive answers to all queries.
Result array should be returned as an array of integers.
For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
    
the function should return the values [2, 4, 1], as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
*/

/* 
문제 요약: 
DNA 서열은 문자 A,C,G 및 T로 구성된 문자열로 표현 될 수 있으며, 이는 서열에서 연속적인 뉴클레오티드의 유형에 해당한다.
각각의 뉴클레오티드는 영향 인자를 가지며, 이는 정수이다.
유형 A, C, G, T의 뉴클레오티드는 각각 1,2,3,4의 충격 계수를 갖는다.
주어진 DNA 서열의 특정 부분에 포함된 뉴클레오티드의 최소 충격 계수는 무엇인가?
DNA서열은 N 개의 문자로 구성된 비어 있지 않은 문자열 S = S[0]S[1]...S[N-1]로 제공된다.
비어 있지 않은 배열 P와 Q에 각각 M 정수로 구성된 M 쿼리가 있다.
K번째 쿼리 (0 ≤ K < M)를 사용하려면 위치 P[K]와 Q[K] (포함)사이의 DNA 서열에 포함된 뉴클레오티드의 최소 충격 계수를 찾아야한다.
위치 2와 4 사이의 DNA 부분에는 뉴클레오티드 G와 C (2 회)가 포함되어 있다.
그 영향 계수는 각각 3과 2이므로 답은 2이다.
위치 5와 5 사이의 부분은 단일 뉴클레오티드 T를 포함한다.
영향 계수가 4이므로 답은 4입니다.
위치 0과 6 사이의 부분 (전체 문자열)에는 모든 뉴클레오티드가 포함된다.
특히 충격 계수가 1 인 뉴클레오티드 A이므로 답은 1이다.
*/

// 솔루션: HashMap, 이중 for문
// Task Score: 62 %

class GenomicRangeQuery_Solution_01 {
    public int[] solution(String S, int[] P, int[] Q) {
    	
    	int p_point = 0;
    	int q_point = 0;
    	int num = 4;
    	// A, C, G, T = 1, 2, 3, 4
    	int[] result = new int[P.length];
    	char ch1;
    	String str = "";
    	
    	HashMap<Character, Integer> dnaMap = new HashMap<Character, Integer>();
    	dnaMap.put('A', 1);
    	dnaMap.put('C', 2);
    	dnaMap.put('G', 3);
    	dnaMap.put('T', 4);
    	
    	
    	
    	for(int i=0; i<P.length; i++) {
    		p_point = P[i];
    		q_point = Q[i];
    		
    		str = S.substring(p_point, q_point+1);
    		
    		for(int j=0; j<str.length(); j++) {
    			
    			ch1 = str.charAt(j);
    			
    			num = Math.min(dnaMap.get(ch1).intValue(), num);
    			
    		}
    		
    		result[i] = num;
    		num = 4;

    	}
    	
    	return result;
        
    }
}

public class GenomicRangeQuery_Sol_01 {
	
	public static void main(String[] args) {
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		GenomicRangeQuery_Solution_01 sol = new GenomicRangeQuery_Solution_01();
		for(int n: sol.solution(S, P, Q)) {
			System.out.println(n);
		}
	}

}
