package monter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sun.management.OperatingSystemMXBean;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;

public class Moniter {

	private JFrame frmSystemInfo;
	static double kb = 1024.0;
	static double mb = 1024.0 * 1024.0;
	static double gb = 1024.0 * 1024.0 * 1024.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moniter window = new Moniter();
					window.frmSystemInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Moniter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// 시스템 자원 읽어오는 부분
		OperatingSystemMXBean osbean = ( OperatingSystemMXBean ) ManagementFactory.getOperatingSystemMXBean( );
		OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
		
		frmSystemInfo = new JFrame();
		frmSystemInfo.setTitle("SYSTEM INFO");
		frmSystemInfo.setBounds(100, 100, 695, 440);
		frmSystemInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemInfo.getContentPane().setLayout(null);
		
		JPanel M_panel = new JPanel();
		M_panel.setBounds(12, 10, 662, 378);
		frmSystemInfo.getContentPane().add(M_panel);
		M_panel.setLayout(null);
		
		//OS 정보 패널
		JPanel OS_panel = new JPanel();
		OS_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "OS INFO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		OS_panel.setBounds(12, 10, 311, 210);
		M_panel.add(OS_panel);
		OS_panel.setLayout(null);
		
		JLabel lblOSNAME = new JLabel("OS Name");
		lblOSNAME.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSNAME.setBounds(12, 32, 117, 44);
		OS_panel.add(lblOSNAME);
		
		JLabel lblOSArch = new JLabel("OS Arch");
		lblOSArch.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSArch.setBounds(12, 84, 117, 44);
		OS_panel.add(lblOSArch);
		
		JLabel lblOSProcesser = new JLabel("OS Processer");
		lblOSProcesser.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSProcesser.setBounds(12, 138, 117, 44);
		OS_panel.add(lblOSProcesser);
		
		JLabel lblOSNAME_1 = new JLabel("");
		lblOSNAME_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSNAME_1.setBounds(141, 32, 158, 44);
		OS_panel.add(lblOSNAME_1);
		
		lblOSNAME_1.setText(osbean.getName());
		
		JLabel lblOSArch_1 = new JLabel("");
		lblOSArch_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSArch_1.setBounds(141, 84, 158, 44);
		OS_panel.add(lblOSArch_1);
		
		lblOSArch_1.setText(osbean.getArch());
		
		JLabel lblOSProcesser_1 = new JLabel("");
		lblOSProcesser_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblOSProcesser_1.setBounds(141, 138, 158, 44);
		OS_panel.add(lblOSProcesser_1);
		
		lblOSProcesser_1.setText(String.valueOf(osbean.getAvailableProcessors())+" Core");
		
		//CPU 로드 정보 패널
		JPanel CPU_panel = new JPanel();
		CPU_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "CPU INFO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		CPU_panel.setBounds(12, 230, 634, 129);
		M_panel.add(CPU_panel);
		CPU_panel.setLayout(null);

		JLabel lblCPULOAD = new JLabel("CPU Load");
		lblCPULOAD.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblCPULOAD.setBounds(12, 44, 117, 44);
		CPU_panel.add(lblCPULOAD);
		
		JLabel lblCPULOAD_1 = new JLabel("");
		lblCPULOAD_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblCPULOAD_1.setBounds(141, 44, 355, 44);
		CPU_panel.add(lblCPULOAD_1);
		
		//메모리 정보 패널
		JPanel ME_panel = new JPanel();
		ME_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Memory INFO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ME_panel.setBounds(335, 10, 311, 210);
		M_panel.add(ME_panel);
		ME_panel.setLayout(null);
		
		JLabel lblTotMEM_1 = new JLabel("");
		lblTotMEM_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblTotMEM_1.setBounds(141, 53, 158, 44);
		ME_panel.add(lblTotMEM_1);
		
		JLabel lblTotMEM = new JLabel("Total Memory");
		lblTotMEM.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblTotMEM.setBounds(12, 53, 117, 44);
		ME_panel.add(lblTotMEM);
		
		JLabel lblUSEMEM = new JLabel("Free Memoey");
		lblUSEMEM.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblUSEMEM.setBounds(12, 107, 117, 44);
		ME_panel.add(lblUSEMEM);
		
		JLabel lblUSEMEM_1 = new JLabel("");
		lblUSEMEM_1.setFont(new Font("에브리데이고딕 L", Font.PLAIN, 15));
		lblUSEMEM_1.setBounds(141, 107, 158, 44);
		ME_panel.add(lblUSEMEM_1);
		
		// 매 초마다 갱신되어야 할 정보들
		TimerTask task1 = new TimerTask() {
            public void run() {
            	lblCPULOAD_1.setText(String.format("%.2f", osBean.getCpuLoad()*100)+"%");
            	lblTotMEM_1.setText(String.format("%.2f", osBean.getTotalMemorySize()/mb)+" MB");
            	lblUSEMEM_1.setText(String.format("%.2f", osBean.getFreeMemorySize()/mb)+" MB");
            }
        };
        Timer timer1 = new Timer();
        long delay1 = 0;
        long period1 = 1000;
        timer1.scheduleAtFixedRate(task1, delay1, period1);
	}
}
