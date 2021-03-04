import javax.swing.*; 
import java.awt.GridLayout;
import java.awt.event.*; 
import java.awt.Font; 
import java.util.Random;


 class TicTacTo {
	JButton[] buttons = new JButton[9]; 
	JPanel panel; 
	String[] user = new String[2];
	int turn = 0;
	JFrame frame;
	int isFULL = 0; 
	
	

	class ButtonListener implements ActionListener { 
		public void actionPerformed(ActionEvent ev) { 

			if(ev.getSource() == buttons[0]) {
				if(buttons[0].getText().equals(" ")){
					buttons[0].setText(user[turn]);
					turn = turn==0 ? 1: 0;
					//if(turn==0) turn = 1;
					//else turn = 0;
				}
		
			}else if(ev.getSource() == buttons[1]) { 
				if(buttons[1].getText().equals(" ")){
					buttons[1].setText(user[turn]);
					turn = turn==0 ? 1: 0;

				}
			}else if(ev.getSource() == buttons[2]) { 
				if(buttons[2].getText().equals(" ")){
					buttons[2].setText(user[turn]);
					turn = turn==0 ? 1: 0; 
				}
			}else if(ev.getSource() == buttons[3]) { 
				if(buttons[3].getText().equals(" ")){	
					buttons[3].setText(user[turn]);
					turn = turn==0 ? 1: 0; 

				}

			}else if(ev.getSource() == buttons[4]) { 
				if(buttons[4].getText().equals(" ")) { 
					buttons[4].setText(user[turn]);
					turn = turn==0 ? 1: 0; 

				}
			}else if(ev.getSource() == buttons[5]) { 
				if(buttons[5].getText().equals(" ")) { 
					buttons[5].setText(user[turn]);
					turn = turn==0 ? 1: 0; 

				}

			}else if(ev.getSource() == buttons[6]) { 
				if(buttons[6].getText().equals(" ")) { 
					buttons[6].setText(user[turn]);
					turn = turn==0 ? 1: 0;
					 

				}

			}else if(ev.getSource() == buttons[7]) { 
				if(buttons[7].getText().equals(" ")){
					buttons[7].setText(user[turn]); 
					turn = turn==0 ? 1: 0;

				}

			}else if(ev.getSource() == buttons[8]) {
				if(buttons[8].getText().equals(" ")){ 
					buttons[8].setText(user[turn]); 
					turn = turn==0 ? 1: 0;

				}


			}
			String winner = checker();
			
			++isFULL; 
			if(isFULL>4&& !winner.equals("X")) { 
				int result1 = JOptionPane.showConfirmDialog(null, "It's a Tie. Play again?");

				if(result1==0) { 
					

					TicTacToe gui = new TicTacToe();
					gui.go();
				}else if(result1==1) { 

					frame.dispose();

					}


				}

			if(winner.equals("N")) { 
				Random r = new Random();
				while(true){
					int i1 = r.nextInt(9);
					if(buttons[i1].getText().equals(" ")){			//computer move 
						buttons[i1].setText("O");
						turn = turn==0 ? 1: 0;
					

						break;
					}
				}
				winner = checker(); //TK - need to check again.
			}
			
			if(winner.equals("X")) {
				int option = JOptionPane.YES_NO_OPTION; 

				int result = JOptionPane.showConfirmDialog(null, "Game Over. X wins. Play again?");

				if(result == 0) {
					
					TicTacTo gui = new TicTacTo();
					go();

				} else if(result == 1) { 
					frame.dispose(); 
					}

			} else if(winner.equals("O")) {

                int result = JOptionPane.showConfirmDialog(null, "Game Over. O wins. Play again?");
                if(result== 0) { 
                	TicTacTo gui = new TicTacTo();
                	go();

                } else if (result == 1) { 
                	frame.dispose();
                	}
                	

                }

			}


		}

	

	 

	public static void main(String[] args) { 
		TicTacTo gui = new TicTacTo();
		gui.go();	
	
	}
		
	public void go() {
		frame = new JFrame("Tic-Tac Toe"); //TK - need to assign JFrame to the instance varialble so that it can be disposed later.
		JPanel panel = new JPanel();
		JButton quit = new JButton("Quit");


		ButtonListener listener = new ButtonListener();
		buttons[0] = new JButton(" ");
		buttons[0].addActionListener(listener);
		panel.setLayout(new GridLayout(3,3));
		Font myFont = new Font("TimesRoman", Font.BOLD,72); 
		buttons[0].setFont(myFont);

		panel.add(buttons[0]);
		buttons[1] = new JButton(" ");
		buttons[1].addActionListener(listener);
        buttons[1].setFont(myFont);

		panel.add(buttons[1]);
		buttons[2] = new JButton(" ");
		buttons[2].addActionListener(listener);
        buttons[2].setFont(myFont);

		panel.add(buttons[2]);
		buttons[3] = new JButton(" "); 
		buttons[3].addActionListener(listener); 
        buttons[3].setFont(myFont);

		panel.add(buttons[3]); 
		buttons[4] = new JButton(" "); 
		buttons[4].addActionListener(listener);
        buttons[4].setFont(myFont);

		panel.add(buttons[4]);
		buttons[5] = new JButton(" "); 
		buttons[5].addActionListener(listener); 
        buttons[5].setFont(myFont);

		panel.add(buttons[5]);
		buttons[6] = new JButton(" "); 
		buttons[6].addActionListener(listener);
        buttons[6].setFont(myFont);

		panel.add(buttons[6]); 
		buttons[7] = new JButton(" ");
		buttons[7].addActionListener(listener);
        buttons[7].setFont(myFont);

		panel.add(buttons[7]);
		buttons[8] = new JButton(" ");
		buttons[8].addActionListener(listener);
        buttons[8].setFont(myFont);

		panel.add(buttons[8]);

		frame.add(panel);

		frame.pack();
		frame.setSize(500,500); 
		frame.setVisible(true);

		
		user[0] = "X";
		user[1] = "O";


	}


	public String checker() { 
		 
		int count0=0, count1=0;

		//row checker 
			if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
				count0 = 1;
			} else if(buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) { 
				count0 = 1;
			 } else if(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) { 
			 	count0 = 1; 
			 } else if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
				count1 = 1;
			} else if(buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) { 
				count1 = 1;
			 } else if(buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) { 
			 	count1 = 1; 
			 }
		

		//column checker 
			if(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) { 
				count0 =1; 
			} else if(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) { 
				count0 = 1; 
			} else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) { 
				count0 = 1; 
			} else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) { 
				count1 =1; 
			} else if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) { 
				count1 = 1; 
			} else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) { 
				count1 = 1; 

			}
		



		//diagonal checker 

			if(buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) { 
				count0 = 1;
			} else if(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) { 
				count0 = 1;
			} else if(buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) { 
				count1 = 1;
			} else if(buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) { 
				count1 = 1;
			}
			//whoWon(int count0, int count1);
			
			if(count0==1) {
				return "X";
			}
			else if(count1==1) return "O";
			else return "N";
		}

		

		
		


		 
	}





		



		
	