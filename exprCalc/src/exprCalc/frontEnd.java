package exprCalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class frontEnd {

	private JFrame frmExpressionEvaluator;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontEnd window = new frontEnd();
					window.frmExpressionEvaluator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frontEnd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpressionEvaluator = new JFrame();
		frmExpressionEvaluator.setTitle("Expression Evaluator");
		frmExpressionEvaluator.setBounds(100, 100, 250, 417);
		frmExpressionEvaluator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpressionEvaluator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 34, 197, 43);
		frmExpressionEvaluator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("1");
		button.setBounds(90, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button);
		
		JButton button_1 = new JButton("0");
		button_1.setBounds(23, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setBounds(160, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setBounds(23, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(160, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("4");
		button_5.setBounds(90, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(93, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("6");
		button_7.setBounds(23, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setBounds(160, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setBounds(23, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("+");
		button_10.setBounds(90, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("-");
		button_11.setBounds(160, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("*");
		button_12.setBounds(23, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("/");
		button_13.setBounds(93, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_13);
		
		JButton btnEval = new JButton("(");

		btnEval.setBounds(160, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(btnEval);
		
		JButton button_14 = new JButton(")");
		button_14.setBounds(23, 269, 60, 25);
		frmExpressionEvaluator.getContentPane().add(button_14);
		
		JButton btnEval_1 = new JButton("Eval");
		btnEval_1.setBounds(90, 269, 130, 25);
		frmExpressionEvaluator.getContentPane().add(btnEval_1);
		
		JButton btnInorder = new JButton("inorder");
		btnInorder.setBounds(23, 301, 94, 25);
		frmExpressionEvaluator.getContentPane().add(btnInorder);
		
		JButton btnPreorder = new JButton("preorder");
		btnPreorder.setBounds(126, 301, 94, 25);
		frmExpressionEvaluator.getContentPane().add(btnPreorder);
		
		JButton btnPostorder = new JButton("postorder");
		btnPostorder.setBounds(23, 338, 101, 25);
		frmExpressionEvaluator.getContentPane().add(btnPostorder);
		
		JButton btnDisplay = new JButton("display");
		btnDisplay.setBounds(136, 338, 84, 25);
		frmExpressionEvaluator.getContentPane().add(btnDisplay);
	}
}
