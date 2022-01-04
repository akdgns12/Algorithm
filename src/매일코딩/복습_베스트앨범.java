package 매일코딩;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class 복습_베스트앨범 {
	static class Music{
		String genre;
		int play;
		int idx;
		
		Music(String genre, int play, int idx){
			this.genre = genre;
			this.play = play;
			this.idx = idx;
		}
	}
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); // 장르별 총 재생횟수
		}
		
		// 1. 장르선정
		ArrayList<String> genres_order = new ArrayList<>();
		while(map.size() != 0) {
			int max = -1;
			String max_key = "";
			for(String key : map.keySet()) {
				int tmp_cnt = map.get(key);
				if(tmp_cnt > max) {
					max = tmp_cnt;
					max_key = key;
				}
			}
			genres_order.add(max_key);
			map.remove(max_key);
		}
		
		// 장르내 노래선정
		ArrayList<Music> result = new ArrayList<>();
		for(String gern : genres_order) {
			ArrayList<Music> list = new ArrayList<>();
			for(int i=0; i<genres.length; i++) {
				if(genres[i].equals(gern)) {
					list.add(new Music(gern, plays[i], i));
				}
			}
			Collections.sort(list, (o1,o2) -> o2.play - o1.play);
			result.add(list.get(0));
			if(list.size() != 1	) {
				result.add(list.get(1));
			}
		}
		
		int[] answer = new int[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i).idx;
		}
		
		return answer;
	}
}
