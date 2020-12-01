import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame implements ActionListener {
    String userId;
    DBManager dbm;
    private String colName[];
    public DefaultTableModel model;
    private JPanel mainFrame;
    //button
    private JButton reasonInquiryButton;//�궗�쑀議고쉶
    private JButton allSearch; //�쟾泥댁“�쉶
    private JButton inquiryPeriodButton; //湲곌컙議고쉶
    private JButton inquiryFacilityButton; //�떆�꽕議고쉶
    private JButton cancleReservationButton;//痍⑥냼踰꾪듉
    private JButton applyButton;//�떊泥�踰꾪듉

    //InquiryText
    private JTextField startDateInquirytext; //�떆�옉湲곌컙
    private JTextField endDateInquirytext; //醫낅즺湲곌컙
    private JTextField facilityInquirytext;//�떆�꽕紐�
    private JTextField reasonInquirytext;//�궗�쑀

    //applyText
    private JTextField applyFacilityText;       //�떆�꽕
    private JTextField applyRoomText;     //�샇�떎
    private JTextField applyLicenserText;     //�뿀媛��옄
    private JTextField applyStartDate;     //�떆�옉湲곌컙
    private JTextField applyFinishDate;     //醫낅즺湲곌컙
    private JTextField applyPersonnelText;     //�씤�썝
    private JTextArea applyReasonText;     //�궗�쑀
    private JTable table;       //異쒕젰 �뀒�씠釉�


    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_6;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    MainView window = new MainView();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public MainView(DBManager dbm, String userId) {
        // setting
        this.dbm = dbm;
        this.userId = userId;

        setTitle("MainPage");
        setSize(922, 684);
        setResizable(false);
        setLocation(100, 100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //�솕硫댁쨷媛�
        // panel
        JPanel panel = new JPanel();
        initialize(panel);
        add(panel);
        setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(JPanel frame) {
        mainFrame = frame;
        frame.setLayout(null);
        applyFacilityText = new JTextField();
        applyFacilityText.setBounds(747, 64, 147, 33);
        frame.add(applyFacilityText);
        applyFacilityText.setColumns(10);

        applyRoomText = new JTextField();
        applyRoomText.setColumns(10);
        applyRoomText.setBounds(747, 104, 147, 33);
        frame.add(applyRoomText);

        applyLicenserText = new JTextField();
        applyLicenserText.setColumns(10);
        applyLicenserText.setBounds(747, 147, 147, 33);
        frame.add(applyLicenserText);

        applyStartDate = new JTextField();
        applyStartDate.setColumns(10);
        applyStartDate.setBounds(747, 190, 147, 33);
        frame.add(applyStartDate);

        applyFinishDate = new JTextField();
        applyFinishDate.setColumns(10);
        applyFinishDate.setBounds(747, 233, 147, 33);
        frame.add(applyFinishDate);

        applyPersonnelText = new JTextField();
        applyPersonnelText.setColumns(10);
        applyPersonnelText.setBounds(747, 276, 147, 33);
        frame.add(applyPersonnelText);

        applyReasonText = new JTextArea();       //�궗�쑀
        applyReasonText.setBounds(749, 330, 145, 241);
        frame.add(applyReasonText);


        JLabel lblNewLabel = new JLabel("\uC2DC\uC124");
        lblNewLabel.setBounds(680, 73, 57, 15);
        frame.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uD638\uC2E4");
        lblNewLabel_1.setBounds(680, 113, 57, 15);
        frame.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\uD5C8\uAC00\uC790");
        lblNewLabel_1_1.setBounds(678, 156, 57, 15);
        frame.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_1_2.setBounds(678, 199, 57, 15);
        frame.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_1_2_1.setBounds(680, 242, 57, 15);
        frame.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_2 = new JLabel("\uC778\uC6D0");
        lblNewLabel_1_2_2.setBounds(678, 285, 57, 15);
        frame.add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("\uC0AC\uC720");
        lblNewLabel_1_2_3.setBounds(680, 337, 57, 15);
        frame.add(lblNewLabel_1_2_3);

        allSearch = new JButton("\uC804\uCCB4\uC870\uD68C"); //�쟾泥댁“�쉶踰꾪듉
        allSearch.setBounds(29, 20, 639, 67);
        frame.add(allSearch);
        allSearch.addActionListener(this);

        JLabel lblNewLabel_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_2.setBounds(36, 119, 48, 15);
        frame.add(lblNewLabel_2);

        startDateInquirytext = new JTextField();
        startDateInquirytext.setBounds(95, 116, 177, 21);
        frame.add(startDateInquirytext);
        startDateInquirytext.setColumns(10);

        lblNewLabel_3 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_3.setBounds(297, 119, 48, 15);
        frame.add(lblNewLabel_3);

        endDateInquirytext = new JTextField();
        endDateInquirytext.setColumns(10);
        endDateInquirytext.setBounds(357, 119, 177, 21);
        frame.add(endDateInquirytext);

        inquiryPeriodButton = new JButton("\uAE30\uAC04 \uC870\uD68C"); //湲곌컙議고쉶踰꾪듉
        inquiryPeriodButton.setBounds(559, 115, 97, 23);
        frame.add(inquiryPeriodButton);


        inquiryFacilityButton = new JButton("\uC2DC\uC124 \uC870\uD68C");  //�떆�꽕議고쉶踰꾪듉
        inquiryFacilityButton.setBounds(559, 157, 97, 23);
        frame.add(inquiryFacilityButton);
        inquiryFacilityButton.addActionListener(this);

        reasonInquiryButton = new JButton("\uC0AC\uC720 \uC870\uD68C");//�궗�쑀議고쉶踰꾪듉
        reasonInquiryButton.setBounds(559, 200, 97, 23);
        frame.add(reasonInquiryButton);

        lblNewLabel_4 = new JLabel("\uC2DC\uC124\uBA85");
        lblNewLabel_4.setBounds(36, 159, 48, 15);
        frame.add(lblNewLabel_4);

        facilityInquirytext = new JTextField();
        facilityInquirytext.setColumns(10);
        facilityInquirytext.setBounds(95, 153, 439, 21);
        frame.add(facilityInquirytext);

        lblNewLabel_6 = new JLabel("\uC0AC\uC720");
        lblNewLabel_6.setBounds(36, 202, 48, 15);
        frame.add(lblNewLabel_6);

        reasonInquirytext = new JTextField();
        reasonInquirytext.setColumns(10);
        reasonInquirytext.setBounds(95, 185, 439, 43);
        frame.add(reasonInquirytext);

        table = new JTable();
        table.setBounds(51, 255, 615, 261);
        frame.add(table);


        cancleReservationButton = new JButton("\uC608\uC57D \uCDE8\uC18C");//�삁�빟痍⑥냼踰꾪듉
        cancleReservationButton.setBounds(40, 526, 639, 56);
        frame.add(cancleReservationButton);

        JLabel userName = new JLabel(userId);
        userName.setFont(new Font("援대┝", Font.BOLD, 25));
        userName.setBounds(749, 20, 132, 34);
        frame.add(userName);

        applyButton = new JButton("\uC2E0\uCCAD\uD558\uAE30"); //�떊泥��븯湲�
        applyButton.setBounds(747, 592, 147, 33);
        frame.add(applyButton);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allSearch) {

            String colName[] = {"대여번호", "시작기간", "종료기간", "인원", "사유", "동의인", "건물", "호실", "허가자"};
            model = new DefaultTableModel(colName, 0);
            String row[] = new String[9];
            model.addRow(colName);
            ArrayList<Rental> rentals = dbm.selectRental();
            for (Rental rental : rentals) {
                row[0] = String.valueOf(rental.getRentalNumber());
                row[1] = String.valueOf(rental.getStartPeriod());
                row[2] = String.valueOf(rental.getEndPeriod());
                row[3] = String.valueOf(rental.getPersonnel());
                row[4] = String.valueOf(rental.getReason());
                row[5] = String.valueOf(rental.getDEUPerson());
                row[6] = String.valueOf(rental.getFacility());
                row[7] = String.valueOf(rental.getRoom());
                row[8] = String.valueOf(rental.getLicenser());
                model.addRow(row);
            }

            table = new JTable(model);
            table.setBounds(51, 255, 615, 261);
            mainFrame.add(table);
            setVisible(true);
        } else if (e.getSource() == inquiryFacilityButton) {
//            ArrayList<Rental> rentals = dbm.selectRental(facilityInquirytext.getText());
            String colName[] = {"대여번호", "시작기간", "종료기간", "인원", "사유", "동의인", "건물", "호실", "허가자"};
            model = new DefaultTableModel(colName, 0);
            String row[] = new String[9];
            model.addRow(colName);
            ArrayList<Rental> rentals = dbm.selectRental(facilityInquirytext.getText());
            for (Rental rental : rentals) {
                row[0] = String.valueOf(rental.getRentalNumber());
                row[1] = String.valueOf(rental.getStartPeriod());
                row[2] = String.valueOf(rental.getEndPeriod());
                row[3] = String.valueOf(rental.getPersonnel());
                row[4] = String.valueOf(rental.getReason());
                row[5] = String.valueOf(rental.getDEUPerson());
                row[6] = String.valueOf(rental.getFacility());
                row[7] = String.valueOf(rental.getRoom());
                row[8] = String.valueOf(rental.getLicenser());
                model.addRow(row);
            }

            table = new JTable(model);
            table.setBounds(51, 255, 615, 261);
            mainFrame.add(table);
            setVisible(true);
        }
    }
}