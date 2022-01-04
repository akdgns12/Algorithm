package 매일코딩;

public class 복습_방금그곡 {
	 public String solution(String m, String[] musicinfos) {
		 String answer =  "(None)";
		 
		 for(int i=0; i<m.length(); i++) {
			 m = m.replace("A#", "a");
			 m = m.replace("C#", "c");
			 m = m.replace("d#", "d");
			 m = m.replace("e#", "e");
			 m = m.replace("f#", "f");
			 m = m.replace("g#", "g");
		 }
		 
		 int maxtime = 0;
		 for(int i=0; i<musicinfos.length; i++) {
			 String[] tmp = musicinfos[i].split(",");
			 
			 tmp[3] = tmp[3].replace("A#","a");
			 tmp[3] = tmp[3].replace("C#","c");
			 tmp[3] = tmp[3].replace("D#","d");
			 tmp[3] = tmp[3].replace("E#","e");
			 tmp[3] = tmp[3].replace("F#","f");
			 tmp[3] = tmp[3].replace("G#","g");
			 
			 String[] startTime = tmp[0].split(":");
			 String[] endTime = tmp[1].split(":");
			 
			 int hour = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
			 int min = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]) + (hour*60);
			 
			 String meltmp = "";
			 for(int j=0; j<min; j++) {
				 meltmp += tmp[3].charAt(j % tmp[3].length());
			 }
			 
			 if(meltmp.contains(m)) {
				 if(maxtime < tmp[3].length()) {
					 maxtime = tmp[3].length();
					 answer = tmp[2];
				 }
			 }
		 }
		 
		 return answer;
	 }
}

