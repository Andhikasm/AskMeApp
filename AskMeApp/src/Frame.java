import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Frame extends JFrame{
	
	private Me me;
	
	private JPanel jpFrame;
	
	public Frame(){
		
		super("Ask Me");
		me = new Me();
		
		jpFrame = new JPanel(new BorderLayout());
		
		jpFrame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jpFrame.setBackground(Color.black);
		setSize(500, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		add(jpFrame, BorderLayout.CENTER);
		addTitle();
		addCopyright();
		addQuestions();
		
		
	}
	
	
	private void addTitle(){
		
		JLabel jlTitle = new JLabel("Ask Me!");
		
		JPanel jpNorth = new JPanel();
		
		jpNorth.setBackground(Color.BLACK);
		
		jlTitle.setForeground(Color.WHITE);
		
		jlTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		
		jpNorth.add(jlTitle);
		
		jpFrame.add(jpNorth, BorderLayout.NORTH);
		
	}
	
	private void addCopyright(){
		
		JLabel jlCopyright = new JLabel("©2016 Andhika Srimadeva");
		
		JPanel jpSouth = new JPanel();
		
		jlCopyright.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		
		jpSouth.add(jlCopyright);
		
		jpFrame.add(jpSouth, BorderLayout.SOUTH);
	}
	
	private void addQuestions(){
		
		JPanel jpCenter = new JPanel(new BorderLayout());
		JPanel jpCenterCenter = new JPanel(new GridLayout(2, 1));
		JPanel jpCenterNorth = new JPanel();
		JList questions = new JList(me);
		JButton jbAnswer = new JButton("Get Answer!");
		JButton jbFunFact = new JButton("Fun Fact");
		JTextArea jtaAnswers = new JTextArea();
		JCheckBox checkAll = new JCheckBox("All");
		JCheckBox checkEducation = new JCheckBox("Education");
		JCheckBox checkPersonal = new JCheckBox("Personal");
		JScrollPane questionsScroll = new JScrollPane(questions, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane answersScroll = new JScrollPane(jtaAnswers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		questions.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		questions.setSelectedIndex(0);
		
		jtaAnswers.setEditable(false);
		jbAnswer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String question = (String) questions.getSelectedValue();
				
				jtaAnswers.setText(me.getAnswer(question));
				
				jtaAnswers.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
				
			}
		});
		
		checkEducation.setSelected(true);
		jtaAnswers.setLineWrap(true);
		
		jpCenterNorth.add(checkAll);
		jpCenterNorth.add(checkEducation);
		jpCenterNorth.add(checkPersonal);
		jpCenterCenter.add(questionsScroll);
		jpCenterCenter.add(answersScroll);
		jpCenter.add(jpCenterNorth, BorderLayout.NORTH);
		jpCenter.add(jbAnswer, BorderLayout.EAST);
		jpCenter.add(jpCenterCenter, BorderLayout.CENTER);
		
		jpFrame.add(jpCenter, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new Frame().setVisible(true);

	}

}
