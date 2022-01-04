package 프로그래머스level2;
/*
 * 음악제목, 재생이 시작되고 끝난 시각, 악보
 * 네오가 기억한 멜로디를 담은 문자열 m, 방송된 곡의 정보 담고있는 배열 musicinfos
 * musicinfos 음악 시작시간, 끝난시각, 음악 제목, 악보정보 ','로 구분된 문자열
 * 
 * 조건이 일치하는 음악이 여러개일 떄에는 라디오에서 재생된 시간이 제일 긴 음악제목을
 * 반환, 재생된 시간도 같을 경우 먼저 입려된 음악 제목을 반환
 * 일치하는게 없으면 none
 */
// 시작시간, 종료시간,제목, 멜로디 4가지 정보를 가지고 있는 문자열로 이루어진 배열과
// 사용자가 기억하고 있는 멜로디를 가지고 사용자가 기억하는 노래의 제목을 찾는 문제
public class 방금그곡 {
	
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxtime = 0;
		for(int i=0; i<m.length(); i++) {
			m = m.replace("A#", "a");
			m = m.replace("C#", "c");
			m = m.replace("D#", "d");
			m = m.replace("F#", "f");
			m = m.replace("G#", "g");
			m = m.replace("E#", "e");
		}
		
		for(int i=0; i<musicinfos.length; i++) {
			String[] tmp = musicinfos[i].split(",");
			
			tmp[3] = tmp[3].replace("A#", "a");
			tmp[3] = tmp[3].replace("C#", "c");
			tmp[3] = tmp[3].replace("D#", "d");
			tmp[3] = tmp[3].replace("F#", "f");
			tmp[3] = tmp[3].replace("G#", "g");
			tmp[3] = tmp[3].replace("E#", "e");
			
			String[] starttime = tmp[0].split(":");
			String[] endtime = tmp[1].split(":");
			
			int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
			int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour*60);
			
			String meltmp = "";
			for(int j=0; j<min; j++) {
				meltmp += tmp[3].charAt(j % tmp[3].length());
			}
			
			//sysout(meltmp); 노래가 진행되는 동안의 음들
			if(meltmp.contains(m)) {
				if(maxtime < meltmp.length()) {
					maxtime = meltmp.length();
					answer = tmp[2];
				}
			}
		}
		
		return answer;
	}
}
