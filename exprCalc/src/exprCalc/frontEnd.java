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
	private JTextField input;
	private TreeOps treeOps;
	private ModelDb mydb;

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
		mydb = ModelDb.getInstance();
		treeOps = new TreeOps();
		
		frmExpressionEvaluator = new JFrame();
		frmExpressionEvaluator.setTitle("Expression Evaluator");
		frmExpressionEvaluator.setBounds(100, 100, 250, 453);
		frmExpressionEvaluator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpressionEvaluator.getContentPane().setLayout(null);
		
		input = new JTextField();
		input.setEditable(false);
		input.setBounds(23, 34, 197, 43);
		frmExpressionEvaluator.getContentPane().add(input);
		input.setColumns(10);
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "1";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		one.setBounds(90, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(one);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "0";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		
		zero.setBounds(23, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(zero);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "2";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		two.setBounds(160, 89, 60, 25);
		frmExpressionEvaluator.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "3";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		three.setBounds(23, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(three);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "5";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		five.setBounds(160, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(five);
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "4";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		four.setBounds(90, 126, 60, 25);
		frmExpressionEvaluator.getContentPane().add(four);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "7";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		seven.setBounds(93, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(seven);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "6";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		six.setBounds(23, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(six);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "8";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		eight.setBounds(160, 163, 60, 25);
		frmExpressionEvaluator.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "9";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		nine.setBounds(23, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(nine);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "+";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		plus.setBounds(90, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(plus);
		
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "-";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		minus.setBounds(160, 200, 60, 25);
		frmExpressionEvaluator.getContentPane().add(minus);
		
		JButton mult = new JButton("*");
		mult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "*";
				input.setText(text);
				mydb.setExpr(text);
			}
		});		
		mult.setBounds(23, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(mult);
		
		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "/";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		divide.setBounds(90, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(divide);
		
		JButton open = new JButton("(");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + "(";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		open.setBounds(160, 232, 60, 25);
		frmExpressionEvaluator.getContentPane().add(open);
		
		JButton close = new JButton(")");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = input.getText() + ")";
				input.setText(text);
				mydb.setExpr(text);
			}
		});
		close.setBounds(23, 269, 53, 25);
		frmExpressionEvaluator.getContentPane().add(close);
		
		JButton eval = new JButton("Eval");
		eval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//input.setText(Double.toString(tree.accept()));
				input.setText(Double.toString(treeOps.evaluate()));
			}
		});
		eval.setBounds(158, 269, 62, 25);
		frmExpressionEvaluator.getContentPane().add(eval);
		
		JButton inorder = new JButton("inorder");
		inorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input.setText(treeOps.display("inorder"));
			}
		});
		inorder.setBounds(23, 301, 94, 25);
		frmExpressionEvaluator.getContentPane().add(inorder);
		
		JButton preorder = new JButton("preorder");
		preorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input.setText(treeOps.display("preorder"));
			}
		});

		preorder.setBounds(126, 301, 94, 25);
		frmExpressionEvaluator.getContentPane().add(preorder);
		
		JButton postorder = new JButton("postorder");

		postorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input.setText(treeOps.display("postorder"));
			}
		});

		postorder.setBounds(23, 338, 101, 25);
		frmExpressionEvaluator.getContentPane().add(postorder);
		
		JButton display = new JButton("display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input.setText(treeOps.display("levelorder"));
			}
		});
		display.setBounds(136, 338, 84, 25);
		frmExpressionEvaluator.getContentPane().add(display);
		
		JButton build = new JButton("Build");
		build.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mydb.setExpr(input.getText());
				treeOps.build();
				input.setText("done");
			}
		});
		build.setBounds(79, 269, 71, 25);
		frmExpressionEvaluator.getContentPane().add(build);
		
		JButton clear = new JButton("clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input.setText("");
				mydb.setExpr("");
				treeOps.setState(new UnInitializedState());
			}
		});
		clear.setBounds(23, 373, 84, 25);
		frmExpressionEvaluator.getContentPane().add(clear);
		
		JButton quit = new JButton("quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				treeOps.quit();
			}
		});
		quit.setBounds(124, 373, 94, 25);
		frmExpressionEvaluator.getContentPane().add(quit);
	}
}
