package demo;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PackingSettingsPanel extends JPanel {
	private JComboBox<String> algorithmChooser;
	private String[] algorithms = {"First-Fit Decreasing Height"};
	public PackingSettingsPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.algorithmChooser = new JComboBox<>(algorithms);
		JLabel lbl = new JLabel("Packing Algorithm");
		
	}
}
