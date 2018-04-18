package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	@Autowired
	EventHandler eventHandler;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
	
	private JFrame jFrame;
	private JLabel label1;
	private JTextField vraag;
	private JPanel controlPanel;
    private JButton btnAskQuestion;
    
public UI() {}
    
    public void setupUI() {
	    jFrame = new JFrame("Eightball JFrame");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(2, 2));

		label1 = new JLabel("vraag: ");
		vraag = new JTextField(15);
		
		btnAskQuestion = new JButton();
		btnAskQuestion.setText("Ask!");
		btnAskQuestion.setTransferHandler(new TransferHandler("text"));
		btnAskQuestion.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(label1);
		controlPanel.add(vraag);
		controlPanel.add(btnAskQuestion);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

	public JTextField getQuestion() {
		return vraag;
	}
}
