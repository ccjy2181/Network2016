/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acidrain;

/**
 *
 * @author Administrator
 */

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

/*
 * 회원가입 화면 NewAccountFrame
 */
public class NewAccountFrame extends JFrame implements ActionListener {
   // 클래스 내에서 사용될 멤버변수들을 선언
   private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
   JFrame frame;
   JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, pt;
   JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l20, JLabel2;
   JTextField tf1, tf2, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11;
   JPasswordField tf3;
   JButton btn1, btn2, btn3;
   Choice list, list2, list3, list4, list5, list6, list7;
   JRadioButton cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
   PreparedStatement ps;
   int select;
   String gender, marry, birth, home;
   //home은 집전화번호
   boolean result;

   // 로그인 정보를 저장하기 위한 변수 
   String name, id, phone, email, sPwd = "";
   public NewAccountFrame() {
      // 회원가입 프레임 생성
      frame = new JFrame("회 원 가 입");
      frame.setSize(900, 800); // 프레임 창 크기
      // setVisible(true);
      frame.setBackground(Color.pink); // 프레임 배경색
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료
      frame.setLocation(500, 250); // 프레임 창 위치
      frame.setVisible(true); // 디스플레이

      // 화면배치를 시작하게 되는 부분
      // p1~ p13까지 객체생성을 하면서 FlowLayout을 사용해서 화면배치
      p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      p9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
      
      // 나머지는 객체 생성
      p15 = new JPanel();
      p16 = new JPanel();
      p17 = new JPanel();
      p18 = new JPanel();
      p19 = new JPanel();
      pt = new JPanel();

      // JLabel들은 각각의 이름을 가진 JLabel객체들이 생성
      l1 = new JLabel("이      름");
      l2 = new JLabel("I    D");
      l3 = new JLabel("비밀번호");
      l4 = new JLabel("성별");
      l5 = new JLabel("생년월일");
      l6 = new JLabel("결혼여부");
      l7 = new JLabel("연락처(Tel)");
      l8 = new JLabel("연락처(H.P)");
      l9 = new JLabel("E-Mail");
      l10 = new JLabel(" -");
      l11 = new JLabel("@");
      l12 = new JLabel(" -");
      JLabel2 = new JLabel("회 원 가 입");

      // 각각 20이라는 길이를 가진채로 TextField 객체가 생성
      tf1 = new JTextField(10); // 이름
      tf2 = new JTextField(20); // 아이디
      tf3 = new JPasswordField(10); // 패스워드
      tf3.setEchoChar('*');
      tf4 = new JTextField(25); // 비밀번호 힌트
      tf5 = new JTextField(5); // 비밀번호 힌트 답
      tf6 = new JTextField(40); // 성별
      tf7 = new JTextField(11);
      tf8 = new JTextField(11);
      tf9 = new JTextField(15);
      tf10 = new JTextField(20);
      tf11 = new JTextField(9);

      // 각각의 이름을 가진 버튼객체가 생성
      btn1 = new JButton("아이디중복체크");
      btn2 = new JButton("가입완료");
      btn3 = new JButton("가입취소");
      
      // 버튼 리스너
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);

      // 생년월일 (년)
      list2 = new Choice();
      for(int i=1910; i<=2015; i++){
         String tmp = String.valueOf(i);
         list2.add(tmp);
      }
      // 생년월일(월)
      list3 = new Choice();
      for(int i=1; i<=12; i++){
         String tmp = String.valueOf(i);
         list3.add(tmp);
      }
      
      // 생년월일(일)
      list4 = new Choice();
      for(int i=1; i<=31; i++){
         String tmp = String.valueOf(i);
         list4.add(tmp);
      }

      // 이메일 주소
      list5 = new Choice();
      list5.add("직접입력");
      list5.add("hanmail.net");
      list5.add("nate.com");
      list5.add("naver.com");
      list5.add("yahoo.com");
      list5.add("hotmail.com"); 
      list5.add("gmail.com"); 
      
      
      // 리스트 리스너
      tf9.setText(list5.getSelectedItem());
      list5.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            tf9.setText(list5.getSelectedItem());
         }
      });

      // 연락처
      list6 = new Choice();
      list6.add("02");
      list6.add("031");
      list6.add("032");
      list6.add("033");
      list6.add("041");
      list6.add("042");
      list6.add("043");
      list6.add("051");
      list6.add("052");
      list6.add("053");

      list7 = new Choice();
      list7.add("010");
      list7.add("011");
      list7.add("017");
      list7.add("019");
      
      list7.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            phone = list6.getSelectedItem();
         }
      });

      // 최초 '남'에 체크되어져 있는 라디오버튼 객체가 생성(성별/결혼여부/이메일 수신여부)
      ButtonGroup rb = new ButtonGroup();
      JRadioButton cb1 = new JRadioButton("남");
      JRadioButton cb2 = new JRadioButton("여");
      rb.add(cb1);
      rb.add(cb2);
      
      ButtonGroup rb1 = new ButtonGroup();
      JRadioButton cb3 = new JRadioButton("기혼");
      JRadioButton cb4 = new JRadioButton("미혼");
      rb1.add(cb3);
      rb1.add(cb4);
            
      cb1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            gender = "남";
            
         }
      });
      cb2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            gender = "여";
            
         }
      });
      cb3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            marry = "기혼";
            
         }
      });
      cb4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            marry = "미혼";
            
         }
      });

      // 중앙에 회 원 가 입 표시 되는 부분
      pt.add(JLabel2);

      // p1에 이름 텍스트 박스
      p1.add(tf1);

      // 마찬가지로 p2에 아이디 와 중복체크 박스
      p2.add(tf2);
      p2.add(btn1);

      // p3에는 비밀번호 텍스트박스
      p3.add(tf3);

      // p4에는 성별 체크박스
      p4.add(cb1);
      p4.add(cb2);

      // p5에는 생년월일 리스트박스
      p5.add(list2);
      p5.add(list3);
      p5.add(list4);
      
      // p6에는 결혼여부 체크박스
      p6.add(cb3);
      p6.add(cb4);
      
      // p7에는 연락처(tel) 텍스트박스
      p7.add(list6);
      p7.add(l7);
      p7.add(tf7);

      // p8에는 연락처(핸드폰) 텍스트
      p8.add(list7); // 선택된 핸드폰 010 ~ 019 중 한 개
      p8.add(l8); // -
      p8.add(tf8); // 핸드폰번호 뒷자리

      // p9에는 이메일 텍스트 박스 + 리스트박스 + 직접입력 텍스트박스
      p9.add(tf11); // 이메일 아이디
      p9.add(l11); // @
      p9.add(tf9); // 이메일 주소 선택시 보여지는 부분
      p9.add(list5); // 이메일 주소 선택
      p9.add(tf10); // 직접입력된 텍스트

      // 전체적인 Layout방식으로는 FlowLayout을 사용
      // p14영역에는 GridLayout을 적용시켜서 화면배치
      // 그리고 l1부터 l5까지를 붙임

      p15.setLayout(new GridLayout(9, 1));
      p15.add(l1);
      p15.add(l2);
      p15.add(l3);
      p15.add(l4);
      p15.add(l5);
      p15.add(l6);
      p15.add(l7);
      p15.add(l8);
      p15.add(l9);

      // p15영역에도 GridLayout을 적용시켜서 화면배치
      // p1부터 p13까지를 추가

      p16.setLayout(new GridLayout(9, 1)); // 15를 16으로

      p16.add(p1);
      p16.add(p2);
      p16.add(p3);
      p16.add(p4);
      p16.add(p5);
      p16.add(p6);
      p16.add(p7);
      p16.add(p8);
      p16.add(p9);
      
      // p16영역에는 BorderLayout을 적용시켜서 화면배치

      p17.setLayout(new BorderLayout()); // 16을 17로

      // p17에 버튼 두개를 붙임 //17을 18로
      p18.add(btn2);
      p18.add(btn3);

      // p18영역에도 역시 BorderLayout을 적용시켜서 화면배치
      // 서쪽에 p14를, 중앙에 p15을, 남쪽부분에 p16

      p19.setLayout(new BorderLayout()); // 18을19로
      p19.add(p15, "West"); // 15
      p19.add(p16, "Center"); // 15 16으로
      p19.add(p17, "South"); // 17

      // 프레임의 북쪽에는 pt를, 중앙에 p10을, 남쪽에 p9를 각각 추가
      frame.add(pt, "North");
      frame.add(p19, "Center"); // 18은 19로
      frame.add(p18, "South"); // 17은 18로
      frame.pack(); // 프레임을 적절한 크기로 만드는 메소드

      // ButtonsListener listener = new ButtonsListener();
      // btn2.addActionListener(listener);

   }
   
   

   public void actionPerformed(ActionEvent event) {
      Object obj = event.getSource();
      String txtID = tf2.getText();
      if (obj == btn2) {
         try {
            addMember();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } else if (obj == btn3) {
         cancleMember();
      } else if(obj == btn1){
         // 아이디 중복 체크 버튼을 눌렀을 때
         if(txtID.equals("")){
            String infoText = "입력된 것이 없습니다.";
            JOptionPane.showMessageDialog(null, infoText, "아이디 중복체크", JOptionPane.INFORMATION_MESSAGE);
         }else{
         
            try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               String url = "jdbc:oracle:thin:@localhost:1521:orcl";
               Connection con = DriverManager.getConnection(url,"scott","root");
               Statement stat = con.createStatement();
               
               
               String query, chkID;
               result = false;
               Statement stmt1 = null;
               ResultSet rs1;      
               
               //실험용
   //            query = "delete from MEMBERLIST where ID='sdfasd'"; 
   //            ps = con.prepareStatement(query);
   //            rs1 = ps.executeQuery();
               
               // 출력 테스트용도
               try {
                  findInfo();
               } catch (SQLException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
               
               
               ps = con.prepareStatement("SELECT*FROM MEMBERLIST WHERE id=?");
               ps.setString(1, txtID.trim());
               rs1 = ps.executeQuery(); // 실행
               if(rs1.next()){
                  result = false;// 중복된 정보가 존재
                  String infoText = "중복된 아이디가 존재합니다.\n다른 아이디를 입력하세요.";
                  JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
               }else{
                  result = true;
                  String infoText = "사용가능한 아이디입니다.";
                  JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
               }
               
               stat.close();
               con.close();
            } catch (SQLException | ClassNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         
      }
   }
   
   protected void addMember() throws SQLException {
      
      String check = "입력하신 정보가 정확하신가요?";
      char[] pwd;
      select = JOptionPane.showConfirmDialog(null, check, "확인 창", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
      if(result == false){
         // 아이디 중복체크를 실행했는지 여부를 체크하기 위한 부분
         check = "아이디 중복체크를 해주세요 ! ";
         select = 1;
         JOptionPane.showMessageDialog(null, check, "알림창", JOptionPane.INFORMATION_MESSAGE);
      }
      if (select == 0) {
         // 입력한 정보가 정확하다.
         name = tf1.getText();
         id = tf2.getText();
         phone = list7.getSelectedItem() + tf8.getText();
         home = list6.getSelectedItem() + tf7.getText();
         birth = list2.getSelectedItem() +" / "+ list3.getSelectedItem() +" / "+ list4.getSelectedItem();
         email = tf11.getText() + l11.getText();
         if (list5.getSelectedItem().equals("직접입력")) {
            email += tf10.getText();
         } else {
            email += list5.getSelectedItem();
         }
         pwd = tf3.getPassword();
         for (int i = 0; i < pwd.length; i++) {
//            System.out.println(pwd[i]);
            sPwd += pwd[i];
         }
         // 변수 저장 완료
         
         inputInfo();         
         findInfo();
         String infoText = "회원가입이 완료되었습니다.";
         JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
         Start loginFrame = new Start();
         Dimension frameSize = loginFrame.getSize();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         loginFrame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
         Container contentPane = loginFrame.getContentPane();
         loginFrame.setVisible(true);
         frame.setVisible(false);
      
      } else {
         // 정확하지 않으니 다시 검토하겠다. 즉 아무 이벤트 필요 없음
         // System.out.println(home);
      }
   }
   
   protected void findInfo() throws SQLException {
      // DB에 저장된 정보를 불러오는 메소드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:orcl";
         Connection con = DriverManager.getConnection(url,"scott","root");
         System.out.println("DB 연결 성공!");
         Statement stat = con.createStatement();         
         
         String query;
         Statement stmt1=null;
         query = "SELECT * FROM MEMBERLIST"; 
         ResultSet rs1 = stat.executeQuery(query); 
         
         // 가져온 정보들을 출력
         while(rs1.next()){ 
             System.out.println("아이디 : " + rs1.getString("id") + "\t패스워드 : "+ rs1.getString("PWD")+"\t이름 : " + rs1.getString("NAME") + "\t핸드폰 : " + 
                      rs1.getString("PHONE")+ "\t성별 "+rs1.getString("gender")+"\t생년월일" + rs1.getString("birth") + "\t결혼 여부 "+rs1.getString("marry"));
         }
         stat.close();
         con.close();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   protected void inputInfo() throws SQLException{
      //입력된 정보를 DB에 저장하는 메소드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:orcl";
         Connection con = DriverManager.getConnection(url,"scott","root");
         System.out.println("DB 연결 성공!");
         Statement stat = con.createStatement();
         String query = "INSERT INTO MEMBERLIST(ID, PWD, NAME, PHONE, EMAIL, GENDER, BIRTH, MARRY, HOME)  "
               + "VALUES('"+id+"','"+sPwd+"','"+name+"','"+phone+"','"+email+"', '"+gender+"', '"+birth+"', '"+marry+"', '"+home+"')";
         stat.executeUpdate(query);
         System.out.println("정보 전송 완료");
         stat.close();
         con.close();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   protected void cancleMember() {

      // System.out.println("가입 취소 버튼 누름");
      String cancle = "회원가입을 취소하시겠습니까?";
      String title = "진행여부 확인";
      String infoText = "회원가입이 취소되었습니다. \n로그인화면으로 이동합니다.";
      select = JOptionPane.showConfirmDialog(null, cancle, title, JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
      if (select == 0) {
         // 가입을 취소하겠다.
         
         JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
         Start loginFrame = new Start();
         Dimension frameSize = loginFrame.getSize();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         loginFrame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
         Container contentPane = loginFrame.getContentPane();
         loginFrame.setVisible(true);
         frame.setVisible(false);
      } else {
         // 정보를 수정하겠다. 즉 아무 이벤트가 없음
      }
   }
}
