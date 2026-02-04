public class KillFeedTest{
	
	public static void pandoraTest() {
		double pandoraKills = 0;
		for (int i = 0; i<KillStream.kills.length; i++) {
			if (KillStream.kills[i].getWeapon().equals("Pandora VX25")) {
				pandoraKills++;
			}
		}
		System.out.println("Pandora Kills: " + pandoraKills);
	}
	
	
	public static void outfitKills() {
		int outfitKills = 0;
		for (int i = 0; i<KillStream.kills.length; i++) {
			if (KillStream.kills[i].getVictim().contains("[")) {
				outfitKills++;
			}
		}
		System.out.println("Outfit Kills: " + outfitKills);
	}
	
	public static void levelChecker() {
		int lowerLevel = 0;
		int sameLevel = 0;
		int higherLevel = 0;
		char start = '(';
		char end = ')';
		String level = "";
		int currentLevel = 21;
		int enemyLevel = 0;
		
		
		for (int i = 0; i<KillStream.kills.length; i++) {
			if (KillStream.kills[i].getVictim().contains("Me")) {
				level = KillStream.kills[i].getKiller();
				level = level.substring((level.indexOf(start) + 1), level.indexOf(end));
				if (level == "")
					enemyLevel = 0;
				else
					enemyLevel = Integer.parseInt(level);
				
				
				if (currentLevel == enemyLevel) 	
					sameLevel++;
				else if (currentLevel > enemyLevel)
					lowerLevel++;
				else if (currentLevel < enemyLevel)		
					higherLevel++;
			}
			
			
		}
		
		System.out.println("Same Level Players: " + sameLevel + "\n"
							+ "Higher Level Players: " + higherLevel + "\n"
							+ "Lower Level Players: " + lowerLevel);
	}
	public static void main(String[] args) {
		double kills = 0;
		double deaths = 0;
		
		for(int i=0; i<KillStream.kills.length; i++) {
			if (KillStream.kills[i].getKiller().equals("Me (21)"))
			{kills++;}
		else {deaths++;}
			
		}	
		System.out.println("K/D for session:" + (kills/deaths));
		
		pandoraTest();
		outfitKills();
		levelChecker();
		
		
	}
}