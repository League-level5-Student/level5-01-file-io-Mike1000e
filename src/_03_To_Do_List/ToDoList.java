package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton add = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	JPanel panel = new JPanel();
	ArrayList<String> buttons = new ArrayList<String>();
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
	}
	
	ToDoList(){
		frame.setVisible(true);
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(add)) {
			String newTask = JOptionPane.showInputDialog("Which task would you like to add?", null);
			buttons.add(newTask);
			
		}
		if(e.getSource().equals(view)) {
			
			for(int i = 0; i <buttons.size(); i++) {
					JOptionPane.showMessageDialog(null, "#" + i + " " + buttons.get(i) );
			}
		}
		if(e.getSource().equals(remove)) {
			int number = Integer.parseInt(JOptionPane.showInputDialog(null, "When you viewed the tasks choose which number task you would like to remove"));
			buttons.remove(number);
		}
		if(e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/DoingList.txt", true);
				for(int i = 0; i < buttons.size(); i++) {
					fw.write("\n " + buttons.get(i));
					
				}
				fw.close();
				
			} catch (IOException j) {
				j.printStackTrace();
			}
			
		}
		if(e.getSource().equals(load)) {
			String location = JOptionPane.showInputDialog(null, "What is the location of your file?");
			try {
				BufferedReader br = new BufferedReader(new FileReader(location + "DoingList.txt"));
				
				String line = br.readLine();
				buttons.add(line);
				while(line != null){
					System.out.println(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
	}
	
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
}

