import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		//Changed background color for text to pink
		textPane.setBackground(Color.pink);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		//Changed title to Top 5 Detox/Wellness Vacations Slideshow
		setTitle("Top 5 Detox/Wellness Vacations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		//Added a pink background color for previous button
		btnPrev.setBackground(Color.pink);
		//Added white font color to previous button
		btnPrev.setForeground(Color.WHITE);
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		//Added a pink background color for next button
		btnNext.setBackground(Color.pink);
		//Added whit font color to next button
		btnNext.setForeground(Color.WHITE);
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){	//Changed testimage to photo of Cala Luna Boutique Hotel
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Cala Luna Boutique Hotel.jpg") + "'</body></html>";
		} else if (i==2){	//Changed testimage to photo of Spa Eastman
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Spa Eastman.jpg") + "'</body></html>";
		} else if (i==3){	//Changed testimage to photo of Isrotel Dead Sea Resort & Spa
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Dead Sea.jpg") + "'</body></html>";
		} else if (i==4){	//Changed testimage to photo of Hilton Sedona Resort At Bell Rock
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Hilton Sedona.jpg") + "'</body></html>";
		} else if (i==5){	//Changed testimage to photo of Nobu Hotel Los Cabos
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Nobu Hotel Los Cabos.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){		//Updated first location to Costa Rica
			text = "<html><body><font size='5'>#1 Cala Luna Boutique Hotel (Tamarindo, Costa Rica)</font> <br>Escape to the tropical paradise of Tamarindo, Costa Rica, for an invigorating wellness retreat amidst lush surroundings. <br><font size='1'>Image provided by Expedia</font></body></html>";
		} else if (i==2){	//Updated below to include 2nd location, added font size for title of location and a newline for the description
			text = "<html><body><font size='5'>#2 Spa Eastman (Quebec, Canada)</font> <br>Nordic Spas are well-known for their ability to alleviate stress, enhance cirulation, and rid the body of toxins. <br><font size='1'>Image provided by Expedia</font></body></html>";
		} else if (i==3){	//Updated below to include 3rd location, added font size for title of location and a newline for the description
			text = "<html><body><font size='5'>#3 Isrotel Dead Sea Resort & Spa (Israel)</font> <br>Experience the benefits of sea mud at the Esprit Sea, where you can experience one-of-a-kind body and beauty therapy treatments. <br><font size='1'>Image provided by Expedia</font></body></html>";
		} else if (i==4){	//Updated below to include 4th location, added font size for title of location and a newline for the description
			text = "<html><body><font size='5'>#4 Hilton Sedona Resort At Bell Rock (Sedona, Arizona)</font> <br>Free your mind in the day-hike capital of America. See the beautiful red rock formations in the Arizona desert.<br><font size='1'>Image provided by Expedia</font></body></html>";
		} else if (i==5){	//Updated below to include 5th location, added font size for title of location and a newline for the description
			text = "<html><body><font size='5'>#5 Nobu Hotel Los Cabos (Cabo San Lucas, Mexico)</font> <br>Discover serenity at the tranquil spa nestled within Nobu Hotel. <br><font size='1'>Image provided by Expedia</font></body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}