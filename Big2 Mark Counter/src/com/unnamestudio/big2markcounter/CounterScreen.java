package com.unnamestudio.big2markcounter;

import java.util.List;
import com.unnamestudio.big2markcounter.Settings;
import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Input.TouchEvent;

public class CounterScreen extends Screen {
	public CounterScreen(Game game) {
		super(game);
	}
	public boolean isCounterStarted = false;
	public boolean isSelectingSpade = false;
	public boolean isSelectingHeart = false;
	public boolean isSelectingClub = false;
	public boolean isSelectingDiamond = false;
	public boolean isUpdatingSpade = false;
	public boolean isUpdatingHeart = false;
	public boolean isUpdatingClub = false;
	public boolean isUpdatingDiamond = false;
	public boolean inputError = false;
	public int delta_spade = -1;
	public int delta_heart = -1;
	public int delta_club = -1;
	public int delta_diamond = -1;
	public int mapSpadeX = 0;
	public int mapSpadeY = 0;
	public int mapHeartX = 0;
	public int mapHeartY = 0;
	public int mapClubX = 0;
	public int mapClubY = 0;
	public int mapDiamondX = 0;
	public int mapDiamondY = 0;
	
	public int mapNumber(int number){
		return (int)((number)*15);
	}
	public int digit(int number, int position){
        return (int)(number/Math.pow(10,position))%10;
        }
	
	public void mapSpade(int k){//mapping x & y coordinate for buttonsB
		if ( k == -1 || k == 2 || k == 5 || k == 8 || k == 11){
			mapSpadeX = 0;
		}
		if (k == 0 || k == 3 || k == 6 || k == 9 || k == 12){
			mapSpadeX = 240;
		}
		if (k == 1 || k == 4 || k == 7 || k == 10 || k == 13){
			mapSpadeX = 480;
		}
		if (k == -1 || k == 0 || k == 1){
			mapSpadeY = 0;
		}
		if (k == 2 || k == 3 || k == 4){
			mapSpadeY = 256;
		}
		if (k == 5 || k == 6 || k == 7){
			mapSpadeY = 512;
		}
		if (k == 8 || k == 9 || k == 10){
			mapSpadeY = 768;
		}
		if (k == 11 || k == 12 || k == 13){
			mapSpadeY = 1024;
		}
		return;
	}
	public void mapHeart(int k){//mapping x & y coordinate for buttonsB
		if ( k == -1 || k == 2 || k == 5 || k == 8 || k == 11){
			mapHeartX = 0;
		}
		if (k == 0 || k == 3 || k == 6 || k == 9 || k == 12){
			mapHeartX = 240;
		}
		if (k == 1 || k == 4 || k == 7 || k == 10 || k == 13){
			mapHeartX = 480;
		}
		if (k == -1 || k == 0 || k == 1){
			mapHeartY = 0;
		}
		if (k == 2 || k == 3 || k == 4){
			mapHeartY = 256;
		}
		if (k == 5 || k == 6 || k == 7){
			mapHeartY = 512;
		}
		if (k == 8 || k == 9 || k == 10){
			mapHeartY = 768;
		}
		if (k == 11 || k == 12 || k == 13){
			mapHeartY = 1024;
		}
		return;
	}
	public void mapClub(int k){//mapping x & y coordinate for buttonsB
		if ( k == -1 || k == 2 || k == 5 || k == 8 || k == 11){
			mapClubX = 0;
		}
		if (k == 0 || k == 3 || k == 6 || k == 9 || k == 12){
			mapClubX = 240;
		}
		if (k == 1 || k == 4 || k == 7 || k == 10 || k == 13){
			mapClubX = 480;
		}
		if (k == -1 || k == 0 || k == 1){
			mapClubY = 0;
		}
		if (k == 2 || k == 3 || k == 4){
			mapClubY = 256;
		}
		if (k == 5 || k == 6 || k == 7){
			mapClubY = 512;
		}
		if (k == 8 || k == 9 || k == 10){
			mapClubY = 768;
		}
		if (k == 11 || k == 12 || k == 13){
			mapClubY = 1024;
		}
		return;
	}
	public void mapDiamond(int k){//mapping x & y coordinate for buttonsB
		if ( k == -1 || k == 2 || k == 5 || k == 8 || k == 11){
			mapDiamondX = 0;
		}
		if (k == 0 || k == 3 || k == 6 || k == 9 || k == 12){
			mapDiamondX = 240;
		}
		if (k == 1 || k == 4 || k == 7 || k == 10 || k == 13){
			mapDiamondX = 480;
		}
		if (k == -1 || k == 0 || k == 1){
			mapDiamondY = 0;
		}
		if (k == 2 || k == 3 || k == 4){
			mapDiamondY = 256;
		}
		if (k == 5 || k == 6 || k == 7){
			mapDiamondY = 512;
		}
		if (k == 8 || k == 9 || k == 10){
			mapDiamondY = 768;
		}
		if (k == 11 || k == 12 || k == 13){
			mapDiamondY = 1024;
		}
		return;
	}
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents(); 
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i < len; i++) { 
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				
				if(isCounterStarted == false){ //before counter start
					//exit to main screen
					if(inBounds(event, 0, 1074, 272, 206 ) && isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						/*Assets.pop.play(1); //on click sound not existing */
		        		game.setScreen(new MainMenuScreen(game));
		        		return;
					}
					
					//when click continue previous game(counter)
					if(inBounds(event, 0, 525, 360, 211) && isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						isCounterStarted=true;
						return;
					}
					
					//when click new game(counter)
					if(inBounds(event, 360, 525, 360, 211) && isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						Settings.round = 1;
						Settings.spade_balance = 0;
						Settings.spade_be_fired = 0;
						Settings.spade_wins = 0;
						Settings.heart_balance = 0;
						Settings.heart_be_fired = 0;
						Settings.heart_wins = 0;
						Settings.club_balance = 0;
						Settings.club_be_fired = 0;
						Settings.club_wins = 0;
						Settings.diamond_balance = 0;
						Settings.diamond_be_fired = 0;
						Settings.diamond_wins = 0;
						isCounterStarted = true;
						delta_spade = -1;
						delta_heart = -1;
						delta_club = -1;
						delta_diamond = -1;
						mapSpadeX = 0;
						mapSpadeY = 0;
						mapHeartX = 0;
						mapHeartY = 0;
						mapClubX = 0;
						mapClubY = 0;
						mapDiamondX = 0;
						mapDiamondY = 0;
						return;
					}
					
					//change character of spade
					if(isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						if(inBounds(event, 32, 22, 300, 300)){
							isSelectingSpade = true;
							return;
						}
					}
					if(isSelectingSpade == true){
						if(inBounds(event, 32, 22, 300, 300)){
							Settings.character_spade = 1;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32, 22+309, 300, 300)){
							Settings.character_spade = 2;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32, 22+309*2, 300, 300)){
							Settings.character_spade = 3;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32, 22+309*3, 300, 300)){
							Settings.character_spade = 4;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*0, 300, 300)){
							Settings.character_spade = 5;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*1, 300, 300)){
							Settings.character_spade = 6;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*2, 300, 300)){
							Settings.character_spade = 7;
							isSelectingSpade = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*3, 300, 300)){
							Settings.character_spade = 8;
							isSelectingSpade = false;
							return;
						}
					}//end of change character of spade
					
					//change character of heart
					if(isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						if(inBounds(event, 396, 22, 300, 300)){
							isSelectingHeart = true;
							return;
						}
					}
					if(isSelectingHeart == true){
						if(inBounds(event, 32, 22, 300, 300)){
							Settings.character_heart = 1;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32, 22+309, 300, 300)){
							Settings.character_heart = 2;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32, 22+309*2, 300, 300)){
							Settings.character_heart = 3;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32, 22+309*3, 300, 300)){
							Settings.character_heart = 4;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*0, 300, 300)){
							Settings.character_heart = 5;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*1, 300, 300)){
							Settings.character_heart = 6;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*2, 300, 300)){
							Settings.character_heart = 7;
							isSelectingHeart = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*3, 300, 300)){
							Settings.character_heart = 8;
							isSelectingHeart = false;
							return;
						}
					}//end of change character of heart
					
					//change character of club
					if(isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						if(inBounds(event, 396, 950, 300, 300)){
							isSelectingClub = true;
							return;
						}
					}
					if(isSelectingClub == true){
						if(inBounds(event, 32, 22, 300, 300)){
							Settings.character_club = 1;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32, 22+309, 300, 300)){
							Settings.character_club = 2;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32, 22+309*2, 300, 300)){
							Settings.character_club = 3;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32, 22+309*3, 300, 300)){
							Settings.character_club = 4;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*0, 300, 300)){
							Settings.character_club = 5;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*1, 300, 300)){
							Settings.character_club = 6;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*2, 300, 300)){
							Settings.character_club = 7;
							isSelectingClub = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*3, 300, 300)){
							Settings.character_club = 8;
							isSelectingClub = false;
							return;
						}
					}//end of change character of club
					
					//change character of diamond
					if(isSelectingSpade == false && isSelectingHeart == false && isSelectingClub == false && isSelectingDiamond == false){
						if(inBounds(event, 32, 950, 300, 300)){
							isSelectingDiamond = true;
							return;
						}
					}
					if(isSelectingDiamond == true){
						if(inBounds(event, 32, 22, 300, 300)){
							Settings.character_diamond = 1;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32, 22+309, 300, 300)){
							Settings.character_diamond = 2;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32, 22+309*2, 300, 300)){
							Settings.character_diamond = 3;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32, 22+309*3, 300, 300)){
							Settings.character_diamond = 4;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*0, 300, 300)){
							Settings.character_diamond = 5;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*1, 300, 300)){
							Settings.character_diamond = 6;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*2, 300, 300)){
							Settings.character_diamond = 7;
							isSelectingDiamond = false;
							return;
						}
						if(inBounds(event, 32+364, 22+309*3, 300, 300)){
							Settings.character_diamond = 8;
							isSelectingDiamond = false;
							return;
						}
					}//end of change character of diamond
				}//end of before counter start	
				
				//Counter started
				if (isCounterStarted == true){
					
					//clicking next round button
					if(inBounds(event, 0, 525, 360, 211) && inputError == false && isUpdatingSpade == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						if (delta_spade == 0 && delta_heart > 0 && delta_club > 0 && delta_diamond > 0 || delta_heart == 0 && delta_spade > 0 && delta_club > 0 && delta_diamond > 0 || delta_club == 0 && delta_spade > 0 && delta_heart > 0 && delta_diamond > 0 || delta_diamond == 0 && delta_spade > 0 && delta_heart > 0 && delta_club > 0){
							Settings.round ++;
							if (delta_spade == 0){
								Settings.spade_wins ++;
							}else if (delta_spade > 0 && delta_spade <= 9){
								Settings.spade_balance += delta_spade;
							}else if (delta_spade > 9 && delta_spade <= 12){
								Settings.spade_balance += 2*delta_spade;
								Settings.spade_be_fired ++;
							}else if (delta_spade == 13){
								Settings.spade_balance += 3*delta_spade;
								Settings.spade_be_fired ++;
							}
							delta_spade = -1;
							mapSpade(delta_spade);
							
							if (delta_heart == 0){
								Settings.heart_wins ++;
							}else if (delta_heart > 0 && delta_heart <= 9){
								Settings.heart_balance += delta_heart;
							}else if (delta_heart > 9 && delta_heart <= 12){
								Settings.heart_balance += 2*delta_heart;
								Settings.heart_be_fired ++;
							}else if (delta_heart == 13){
								Settings.heart_balance += 3*delta_heart;
								Settings.heart_be_fired ++;
							}
							delta_heart = -1;
							mapHeart(delta_heart);
							
							if (delta_club == 0){
								Settings.club_wins ++;
							}else if (delta_club > 0 && delta_club <= 9){
								Settings.club_balance += delta_club;
							}else if (delta_club > 9 && delta_club <= 12){
								Settings.club_balance += 2*delta_club;
								Settings.club_be_fired ++;
							}else if (delta_club == 13){
								Settings.club_balance += 3*delta_club;
								Settings.club_be_fired ++;
							}
							delta_club = -1;
							mapClub(delta_club);
							
							if (delta_diamond == 0){
								Settings.diamond_wins ++;
							}else if (delta_diamond > 0 && delta_diamond <= 9){
								Settings.diamond_balance += delta_diamond;
							}else if (delta_diamond > 9 && delta_diamond <= 12){
								Settings.diamond_balance += 2*delta_diamond;
								Settings.diamond_be_fired ++;
							}else if (delta_diamond == 13){
								Settings.diamond_balance += 3*delta_diamond;
								Settings.diamond_be_fired ++;
							}
							delta_diamond = -1;
							mapDiamond(delta_diamond);
							return;
						}else{
							inputError = true;
							return;
						}
					}//end of clicking next round button
					
					//for input error
					if(inputError == true){
						if(inBounds(event, 0, 0, 720, 1280)){
							inputError = false;
							return;
						}
					}
					
					//clicking pause button
					if(inBounds(event, 360, 525, 360, 211) && inputError == false && isUpdatingSpade == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						isCounterStarted = false;
						return;
					}
					
					//updating spade's marks
					if(isUpdatingSpade == false && inputError == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						if(inBounds(event, 32, 22, 300, 300)){
							isUpdatingSpade = true;
							return;
						}
					}
					if(isUpdatingSpade == true){
						if(inBounds(event, 240, 0, 240, 256)){
							if (delta_spade != 0){
								delta_spade = 0;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 0){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 0, 240, 256)){
							if (delta_spade != 1){
								delta_spade = 1;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 1){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 0, 256, 240, 256)){
							if (delta_spade != 2){
								delta_spade = 2;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 2){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256, 240, 256)){
							if (delta_spade != 3){
								delta_spade = 3;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 3){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256, 240, 256)){
							if (delta_spade != 4){
								delta_spade = 4;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 4){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*2, 240, 256)){
							if (delta_spade != 5){
								delta_spade = 5;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 5){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*2, 240, 256)){
							if (delta_spade != 6){
								delta_spade = 6;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 6){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*2, 240, 256)){
							if (delta_spade != 7){
								delta_spade = 7;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 7){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*3, 240, 256)){
							if (delta_spade != 8){
								delta_spade = 8;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 8){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*3, 240, 256)){
							if (delta_spade != 9){
								delta_spade = 9;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 9){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*3, 240, 256)){
							if (delta_spade != 10){
								delta_spade = 10;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 10){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*4, 240, 256)){
							if (delta_spade != 11){
								delta_spade = 11;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 11){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*4, 240, 256)){
							if (delta_spade != 12){
								delta_spade = 12;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 12){
								isUpdatingSpade = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*4, 240, 256)){
							if (delta_spade != 13){
								delta_spade = 13;
								mapSpade(delta_spade);
								return;
							}
							if (delta_spade == 13){
								isUpdatingSpade = false;
								return;
							}
						}
					}
					//end of updating spade's marks
					
					//updating heart's marks
					if(isUpdatingSpade == false && inputError == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						if(inBounds(event, 396, 22, 300, 300)){
							isUpdatingHeart = true;
							return;
						}
					}
					if(isUpdatingHeart == true){
						if(inBounds(event, 240, 0, 240, 256)){
							if (delta_heart != 0){
								delta_heart = 0;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 0){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 0, 240, 256)){
							if (delta_heart != 1){
								delta_heart = 1;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 1){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 0, 256, 240, 256)){
							if (delta_heart != 2){
								delta_heart = 2;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 2){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256, 240, 256)){
							if (delta_heart != 3){
								delta_heart = 3;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 3){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256, 240, 256)){
							if (delta_heart != 4){
								delta_heart = 4;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 4){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*2, 240, 256)){
							if (delta_heart != 5){
								delta_heart = 5;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 5){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*2, 240, 256)){
							if (delta_heart != 6){
								delta_heart = 6;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 6){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*2, 240, 256)){
							if (delta_heart != 7){
								delta_heart = 7;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 7){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*3, 240, 256)){
							if (delta_heart != 8){
								delta_heart = 8;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 8){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*3, 240, 256)){
							if (delta_heart != 9){
								delta_heart = 9;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 9){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*3, 240, 256)){
							if (delta_heart != 10){
								delta_heart = 10;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 10){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*4, 240, 256)){
							if (delta_heart != 11){
								delta_heart = 11;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 11){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*4, 240, 256)){
							if (delta_heart != 12){
								delta_heart = 12;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 12){
								isUpdatingHeart = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*4, 240, 256)){
							if (delta_heart != 13){
								delta_heart = 13;
								mapHeart(delta_heart);
								return;
							}
							if (delta_heart == 13){
								isUpdatingHeart = false;
								return;
							}
						}
					}
					//end of updating heart's marks
					
					//updating club's marks
					if(isUpdatingSpade == false && inputError == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						if(inBounds(event, 396, 950, 300, 300)){
							isUpdatingClub = true;
							return;
						}
					}
					if(isUpdatingClub == true){
						if(inBounds(event, 240, 0, 240, 256)){
							if (delta_club != 0){
								delta_club = 0;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 0){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 0, 240, 256)){
							if (delta_club != 1){
								delta_club = 1;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 1){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 0, 256, 240, 256)){
							if (delta_club != 2){
								delta_club = 2;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 2){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256, 240, 256)){
							if (delta_club != 3){
								delta_club = 3;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 3){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256, 240, 256)){
							if (delta_club != 4){
								delta_club = 4;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 4){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*2, 240, 256)){
							if (delta_club != 5){
								delta_club = 5;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 5){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*2, 240, 256)){
							if (delta_club != 6){
								delta_club = 6;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 6){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*2, 240, 256)){
							if (delta_club != 7){
								delta_club = 7;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 7){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*3, 240, 256)){
							if (delta_club != 8){
								delta_club = 8;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 8){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*3, 240, 256)){
							if (delta_club != 9){
								delta_club = 9;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 9){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*3, 240, 256)){
							if (delta_club != 10){
								delta_club = 10;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 10){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 0, 256*4, 240, 256)){
							if (delta_club != 11){
								delta_club = 11;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 11){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*4, 240, 256)){
							if (delta_club != 12){
								delta_club = 12;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 12){
								isUpdatingClub = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*4, 240, 256)){
							if (delta_club != 13){
								delta_club = 13;
								mapClub(delta_club);
								return;
							}
							if (delta_club == 13){
								isUpdatingClub = false;
								return;
							}
						}
					}
					//end of updating club's marks
					
					//updating diamond's marks
					if(isUpdatingSpade == false && inputError == false && isUpdatingHeart == false && isUpdatingClub == false && isUpdatingDiamond == false){
						if(inBounds(event, 32, 950, 300, 300)){
							isUpdatingDiamond = true;
							return;
						}
					}
					if(isUpdatingDiamond == true){
						if(inBounds(event, 240, 0, 240, 256)){
							if (delta_diamond != 0){
								delta_diamond = 0;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 0){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 0, 240, 256)){
							if (delta_diamond != 1){
								delta_diamond = 1;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 1){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*0, 256, 240, 256)){
							if (delta_diamond != 2){
								delta_diamond = 2;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 2){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256, 240, 256)){
							if (delta_diamond != 3){
								delta_diamond = 3;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 3){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256, 240, 256)){
							if (delta_diamond != 4){
								delta_diamond = 4;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 4){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*0, 256*2, 240, 256)){
							if (delta_diamond != 5){
								delta_diamond = 5;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 5){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*2, 240, 256)){
							if (delta_diamond != 6){
								delta_diamond = 6;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 6){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*2, 240, 256)){
							if (delta_diamond != 7){
								delta_diamond = 7;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 7){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*0, 256*3, 240, 256)){
							if (delta_diamond != 8){
								delta_diamond = 8;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 8){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*3, 240, 256)){
							if (delta_diamond != 9){
								delta_diamond = 9;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 9){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*3, 240, 256)){
							if (delta_diamond != 10){
								delta_diamond = 10;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 10){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*0, 256*4, 240, 256)){
							if (delta_diamond != 11){
								delta_diamond = 11;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 11){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*1, 256*4, 240, 256)){
							if (delta_diamond != 12){
								delta_diamond = 12;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 12){
								isUpdatingDiamond = false;
								return;
							}
						}
						if(inBounds(event, 240*2, 256*4, 240, 256)){
							if (delta_diamond != 13){
								delta_diamond = 13;
								mapDiamond(delta_diamond);
								return;
							}
							if (delta_diamond == 13){
								isUpdatingDiamond = false;
								return;
							}
						}
					}//end of updating diamond's marks
				}//end of counter started
			}//end of touch event
		}
	}
	
	private boolean 
	inBounds(TouchEvent event, int x, int y, int width, int height) { 
		if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) 
			return true;
		else
			return false;
	}
	
	
	@Override 
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.counter_screen_bg, 0, 0);
		g.drawPixmap(Assets.counter_screen_character_spade, 32, 22, 0, (Settings.character_spade-1)*300, 300, 300);
		g.drawPixmap(Assets.counter_screen_character_heart, 396, 22, 0, (Settings.character_heart-1)*300, 300, 300);
		g.drawPixmap(Assets.counter_screen_character_club, 396, 950, 0, (Settings.character_club-1)*300, 300, 300);
		g.drawPixmap(Assets.counter_screen_character_diamond, 32, 950, 0, (Settings.character_diamond-1)*300, 300, 300);
		
		//drawings before counter start
		if (isCounterStarted == false){
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 0, 720, 211);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 211*1, 720, 211);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 211*2, 720, 211);
			}	
			g.drawPixmap(Assets.main_screen_exit_button, 0, 1074);
		}//end of drawings before counter start

		//drawings for counter started
		if (isCounterStarted == true){
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 211*3, 720, 211);
				g.drawPixmap(Assets.counter_screen_counts_zh, 32, 342);
				g.drawPixmap(Assets.counter_screen_counts_zh, 396, 342);
				g.drawPixmap(Assets.counter_screen_counts_zh, 32, 747);
				g.drawPixmap(Assets.counter_screen_counts_zh, 396, 747);
				g.drawPixmap(Assets.counter_screen_round, 529, 0, 0, 0, 191, 192);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 211*4, 720, 211);
				g.drawPixmap(Assets.counter_screen_counts_en, 32, 342);
				g.drawPixmap(Assets.counter_screen_counts_en, 396, 342);
				g.drawPixmap(Assets.counter_screen_counts_en, 32, 747);
				g.drawPixmap(Assets.counter_screen_counts_en, 396, 747);
				g.drawPixmap(Assets.counter_screen_round, 529, 0, 0, 192, 191, 192);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsA, 0, 525, 0, 211*5, 720, 211);
				g.drawPixmap(Assets.counter_screen_counts_cn, 32, 342);
				g.drawPixmap(Assets.counter_screen_counts_cn, 396, 342);
				g.drawPixmap(Assets.counter_screen_counts_cn, 32, 747);
				g.drawPixmap(Assets.counter_screen_counts_cn, 396, 747);
				g.drawPixmap(Assets.counter_screen_round, 529, 0, 0, 0, 191, 192);
			}
			//round number
			g.drawPixmap(Assets.counter_screen_numbers, 619+2*15, 49, mapNumber(digit(Settings.round, 0)), 0, 15, 25);
			if (Settings.round >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 619+1*15, 49, mapNumber(digit(Settings.round, 1)), 0, 15, 25);
			}
			if (Settings.round >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 619, 49, mapNumber(digit(Settings.round, 2)), 0, 15, 25);
			}
			
			//spade's statistic
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 341, mapNumber(digit(Settings.spade_balance, 0)), 0, 15, 25);
			if (Settings.spade_balance >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 341, mapNumber(digit(Settings.spade_balance, 1)), 0, 15, 25);
			}
			if (Settings.spade_balance >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 341, mapNumber(digit(Settings.spade_balance, 2)), 0, 15, 25);
			}
			if (Settings.spade_balance >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 341, mapNumber(digit(Settings.spade_balance, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 409, mapNumber(digit(Settings.spade_be_fired, 0)), 0, 15, 25);
			if (Settings.spade_be_fired >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 409, mapNumber(digit(Settings.spade_be_fired, 1)), 0, 15, 25);
			}
			if (Settings.spade_be_fired >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 409, mapNumber(digit(Settings.spade_be_fired, 2)), 0, 15, 25);
			}
			if (Settings.spade_be_fired >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 409, mapNumber(digit(Settings.spade_be_fired, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 476, mapNumber(digit(Settings.spade_wins, 0)), 0, 15, 25);
			if (Settings.spade_wins >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 476, mapNumber(digit(Settings.spade_wins, 1)), 0, 15, 25);
			}
			if (Settings.spade_wins >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 476, mapNumber(digit(Settings.spade_wins, 2)), 0, 15, 25);
			}
			if (Settings.spade_wins >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 476, mapNumber(digit(Settings.spade_wins, 3)), 0, 15, 25);
			}//end of spade's statistic
			
			//heart's statistic
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 341, mapNumber(digit(Settings.heart_balance, 0)), 0, 15, 25);
			if (Settings.heart_balance >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 341, mapNumber(digit(Settings.heart_balance, 1)), 0, 15, 25);
			}
			if (Settings.heart_balance >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 341, mapNumber(digit(Settings.heart_balance, 2)), 0, 15, 25);
			}
			if (Settings.heart_balance >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 341, mapNumber(digit(Settings.heart_balance, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 409, mapNumber(digit(Settings.heart_be_fired, 0)), 0, 15, 25);
			if (Settings.heart_be_fired >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 409, mapNumber(digit(Settings.heart_be_fired, 1)), 0, 15, 25);
			}
			if (Settings.heart_be_fired >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 409, mapNumber(digit(Settings.heart_be_fired, 2)), 0, 15, 25);
			}
			if (Settings.heart_be_fired >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 409, mapNumber(digit(Settings.heart_be_fired, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 476, mapNumber(digit(Settings.heart_wins, 0)), 0, 15, 25);
			if (Settings.heart_wins >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 476, mapNumber(digit(Settings.heart_wins, 1)), 0, 15, 25);
			}
			if (Settings.heart_wins >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 476, mapNumber(digit(Settings.heart_wins, 2)), 0, 15, 25);
			}
			if (Settings.heart_wins >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 476, mapNumber(digit(Settings.heart_wins, 3)), 0, 15, 25);
			}//end of heart's statistic
			
			//club's statistic
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 747, mapNumber(digit(Settings.club_balance, 0)), 0, 15, 25);
			if (Settings.club_balance >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 747, mapNumber(digit(Settings.club_balance, 1)), 0, 15, 25);
			}
			if (Settings.club_balance >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 747, mapNumber(digit(Settings.club_balance, 2)), 0, 15, 25);
			}
			if (Settings.club_balance >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 747, mapNumber(digit(Settings.club_balance, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 818, mapNumber(digit(Settings.club_be_fired, 0)), 0, 15, 25);
			if (Settings.club_be_fired >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 818, mapNumber(digit(Settings.club_be_fired, 1)), 0, 15, 25);
			}
			if (Settings.club_be_fired >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 818, mapNumber(digit(Settings.club_be_fired, 2)), 0, 15, 25);
			}
			if (Settings.club_be_fired >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 818, mapNumber(digit(Settings.club_be_fired, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 631+3*15, 888, mapNumber(digit(Settings.club_wins, 0)), 0, 15, 25);
			if (Settings.club_wins >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 631+2*15, 888, mapNumber(digit(Settings.club_wins, 1)), 0, 15, 25);
			}
			if (Settings.club_wins >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 631+1*15, 888, mapNumber(digit(Settings.club_wins, 2)), 0, 15, 25);
			}
			if (Settings.club_wins >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 631+0*15, 888, mapNumber(digit(Settings.club_wins, 3)), 0, 15, 25);
			}//end of club's statistic
			
			//diamond's statistic
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 747, mapNumber(digit(Settings.diamond_balance, 0)), 0, 15, 25);
			if (Settings.diamond_balance >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 747, mapNumber(digit(Settings.diamond_balance, 1)), 0, 15, 25);
			}
			if (Settings.diamond_balance >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 747, mapNumber(digit(Settings.diamond_balance, 2)), 0, 15, 25);
			}
			if (Settings.diamond_balance >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 747, mapNumber(digit(Settings.diamond_balance, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 818, mapNumber(digit(Settings.diamond_be_fired, 0)), 0, 15, 25);
			if (Settings.diamond_be_fired >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 818, mapNumber(digit(Settings.diamond_be_fired, 1)), 0, 15, 25);
			}
			if (Settings.diamond_be_fired >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 818, mapNumber(digit(Settings.diamond_be_fired, 2)), 0, 15, 25);
			}
			if (Settings.diamond_be_fired >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 818, mapNumber(digit(Settings.diamond_be_fired, 3)), 0, 15, 25);
			}
			g.drawPixmap(Assets.counter_screen_numbers, 271+3*15, 888, mapNumber(digit(Settings.diamond_wins, 0)), 0, 15, 25);
			if (Settings.diamond_wins >= 10){
				g.drawPixmap(Assets.counter_screen_numbers, 271+2*15, 888, mapNumber(digit(Settings.diamond_wins, 1)), 0, 15, 25);
			}
			if (Settings.diamond_wins >= 100){
				g.drawPixmap(Assets.counter_screen_numbers, 271+1*15, 888, mapNumber(digit(Settings.diamond_wins, 2)), 0, 15, 25);
			}
			if (Settings.diamond_wins >= 1000){
				g.drawPixmap(Assets.counter_screen_numbers, 271+0*15, 888, mapNumber(digit(Settings.diamond_wins, 3)), 0, 15, 25);
			}//end of diamond's statistic
			
			g.drawPixmap(Assets.counter_screen_buttonsB, 120, 84, mapSpadeX, mapSpadeY, 240, 256);
			g.drawPixmap(Assets.counter_screen_buttonsB, 480, 84, mapHeartX, mapHeartY, 240, 256);
			g.drawPixmap(Assets.counter_screen_buttonsB, 480, 1014, mapClubX, mapClubY, 240, 256);
			g.drawPixmap(Assets.counter_screen_buttonsB, 120, 1014, mapDiamondX, mapDiamondY, 240, 256);
		}//end of drawings for counter started
		
		//drawings for selecting character
		if (isSelectingSpade == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			g.drawPixmap(Assets.counter_screen_character_spade, (0)*364+32, (0)*309+22, 0, 0*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (0)*364+32, (1)*309+22, 0, 1*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (0)*364+32, (2)*309+22, 0, 2*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (0)*364+32, (3)*309+22, 0, 3*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (1)*364+32, (0)*309+22, 0, 4*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (1)*364+32, (1)*309+22, 0, 5*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (1)*364+32, (2)*309+22, 0, 6*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_spade, (1)*364+32, (3)*309+22, 0, 7*300, 300, 300);
		}
		if (isSelectingHeart == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			g.drawPixmap(Assets.counter_screen_character_heart, (0)*364+32, (0)*309+22, 0, 0*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (0)*364+32, (1)*309+22, 0, 1*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (0)*364+32, (2)*309+22, 0, 2*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (0)*364+32, (3)*309+22, 0, 3*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (1)*364+32, (0)*309+22, 0, 4*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (1)*364+32, (1)*309+22, 0, 5*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (1)*364+32, (2)*309+22, 0, 6*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_heart, (1)*364+32, (3)*309+22, 0, 7*300, 300, 300);
		}
		if (isSelectingClub == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			g.drawPixmap(Assets.counter_screen_character_club, (0)*364+32, (0)*309+22, 0, 0*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (0)*364+32, (1)*309+22, 0, 1*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (0)*364+32, (2)*309+22, 0, 2*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (0)*364+32, (3)*309+22, 0, 3*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (1)*364+32, (0)*309+22, 0, 4*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (1)*364+32, (1)*309+22, 0, 5*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (1)*364+32, (2)*309+22, 0, 6*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_club, (1)*364+32, (3)*309+22, 0, 7*300, 300, 300);
		}
		if (isSelectingDiamond == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			g.drawPixmap(Assets.counter_screen_character_diamond, (0)*364+32, (0)*309+22, 0, 0*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (0)*364+32, (1)*309+22, 0, 1*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (0)*364+32, (2)*309+22, 0, 2*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (0)*364+32, (3)*309+22, 0, 3*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (1)*364+32, (0)*309+22, 0, 4*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (1)*364+32, (1)*309+22, 0, 5*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (1)*364+32, (2)*309+22, 0, 6*300, 300, 300);
			g.drawPixmap(Assets.counter_screen_character_diamond, (1)*364+32, (3)*309+22, 0, 7*300, 300, 300);
		}//end of drawings for selecting character
		
		//drawings for input error
		if (inputError == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_input_error, 118, 418, 0, 0, 494, 422);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_input_error, 118, 418, 0, 844, 494, 422);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_input_error, 118, 418, 0, 422, 494, 422);
			}
		}
		
		//drawings for inputing marks
		if (isUpdatingSpade == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsC_zh, 0, 0);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsC_en, 0, 0);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsC_cn, 0, 0);
			}
			g.drawPixmap(Assets.counter_screen_buttonsB, 0, 0);
			g.drawPixmap(Assets.frame, mapSpadeX, mapSpadeY);
		}
		if (isUpdatingHeart == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsC_zh, 0, 0);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsC_en, 0, 0);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsC_cn, 0, 0);
			}
			g.drawPixmap(Assets.counter_screen_buttonsB, 0, 0);
			g.drawPixmap(Assets.frame, mapHeartX, mapHeartY);
		}
		if (isUpdatingClub == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsC_zh, 0, 0);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsC_en, 0, 0);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsC_cn, 0, 0);
			}
			g.drawPixmap(Assets.counter_screen_buttonsB, 0, 0);
			g.drawPixmap(Assets.frame, mapClubX, mapClubY);
		}
		if (isUpdatingDiamond == true){
			g.drawPixmap(Assets.black_half_opacity, 0, 0);
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_buttonsC_zh, 0, 0);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_buttonsC_en, 0, 0);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_buttonsC_cn, 0, 0);
			}
			g.drawPixmap(Assets.counter_screen_buttonsB, 0, 0);
			g.drawPixmap(Assets.frame, mapDiamondX, mapDiamondY);
		}//end of drawings for inputing marks
	}
	
	@Override
	public void pause() {
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
