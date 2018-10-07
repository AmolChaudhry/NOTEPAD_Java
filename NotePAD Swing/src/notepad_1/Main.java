package notepad_1;
import java.awt.BorderLayout;   
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import java.io.*;
import java.net.URISyntaxException;
public class Main  {
JFrame f1; 
JMenu File, Edit, Format, View , Help;
//For Edit menu 
JMenuItem e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,  undo, cut,copy,paste,selectall,
New,Open,Save, SaveAs, PageSetup,Print,Exit,Font,Redo,redo2, gethelp ;
JTextArea ta;
JPopupMenu pop;
Boolean bbk = true ;
 String ff;
 File ff1;
 JCheckBoxMenuItem cbmi,linewrap;
 JToolBar toolbar ;
 JLabel label2;
 JScrollPane SP;
UndoManager undomanager = new UndoManager();
Main() throws IOException{ 
	f1 = new JFrame("Textor");
	
	BufferedImage himage = ImageIO.read(getClass().getResource("/images/help.gif"));
	BufferedImage hret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	hret.getGraphics().drawImage(himage, 0, 0, 30,30,null);
	ImageIcon hicon  = new ImageIcon(hret);
	
	
	
	
	
	
	gethelp = new JMenuItem("Get Help",hicon);
	gethelp.setBackground(Color.WHITE);
	
	toolbar = new JToolBar();
	File = new JMenu("File");
    pop = new JPopupMenu();
    ta = new JTextArea();
    //cbmi = new JCheckBoxMenuItem("Status Bar");
    
    BufferedImage lwimage = ImageIO.read(getClass().getResource("/images/Line.gif"));
	BufferedImage lwret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	lwret.getGraphics().drawImage(lwimage, 0, 0, 30,30,null);
	ImageIcon lwicon  = new ImageIcon(lwret);

    
    linewrap = new JCheckBoxMenuItem("Line Wrap",lwicon);
    linewrap.setBackground(Color.WHITE);
    
    
    
	Edit = new JMenu("Edit");
	Format = new JMenu("Format");
	View = new JMenu("View");
	Help = new JMenu("Help");
	undo = new JMenuItem("Undo");
	redo2 = new JMenuItem("Redo");
	cut = new JMenuItem("Cut");
	copy = new JMenuItem("Copy");
	paste = new JMenuItem("Paste");
	BufferedImage redoimage = ImageIO.read(getClass().getResource("/images/redo.gif"));
	BufferedImage redoret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	redoret.getGraphics().drawImage(redoimage, 0, 0, 30,30,null);
	ImageIcon redoicon  = new ImageIcon(redoret);
	Redo = new JMenuItem("Redo",redoicon);
	Redo.setBackground(Color.WHITE);
	
	
	
	
	
	
	
	
	
	selectall = new JMenuItem("Select All");
	BufferedImage newimage = ImageIO.read(getClass().getResource("/images/NEW.gif"));
	BufferedImage newret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	newret.getGraphics().drawImage(newimage, 0, 0, 30,30,null);
	ImageIcon newicon  = new ImageIcon(newret);
	New = new JMenuItem("New",newicon);
	New.setBackground(Color.WHITE);
	BufferedImage openimage = ImageIO.read(getClass().getResource("/images/OPEN.gif"));
	BufferedImage openret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	openret.getGraphics().drawImage(openimage, 0, 0, 30,30,null);
	ImageIcon openicon  = new ImageIcon(openret);
	Open = new JMenuItem("Open",openicon);
	Open.setBackground(Color.WHITE);
	BufferedImage saveimage = ImageIO.read(getClass().getResource("/images/Save.gif"));
	BufferedImage saveret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	saveret.getGraphics().drawImage(saveimage, 0, 0, 30,30,null);
	ImageIcon saveicon  = new ImageIcon(saveret);
	Save = new JMenuItem("Save",saveicon);
	Save.setBackground(Color.WHITE);
	BufferedImage saveasimage = ImageIO.read(getClass().getResource("/images/saveas.gif"));
	BufferedImage saveasret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	saveasret.getGraphics().drawImage(saveasimage, 0, 0, 30,30,null);
	ImageIcon saveasicon  = new ImageIcon(saveasret);
	SaveAs = new JMenuItem("Save As...",saveasicon);
	SaveAs.setBackground(Color.WHITE);
	BufferedImage psimage = ImageIO.read(getClass().getResource("/images/PS.gif"));
	BufferedImage psret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	psret.getGraphics().drawImage(psimage, 0, 0, 30,30,null);
	ImageIcon psicon  = new ImageIcon(psret);
	PageSetup = new JMenuItem("Page Setup...",psicon);
	PageSetup.setBackground(Color.WHITE);
	BufferedImage printimage = ImageIO.read(getClass().getResource("/images/PRINTER.gif"));
	BufferedImage printret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	printret.getGraphics().drawImage(printimage, 0, 0, 30,30,null);
	ImageIcon printicon  = new ImageIcon(printret);
	Print = new JMenuItem("Print...",printicon);
	Print.setBackground(Color.WHITE);
	
	
	BufferedImage exitimage = ImageIO.read(getClass().getResource("/images/EXIT.gif"));
	BufferedImage exitret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	exitret.getGraphics().drawImage(exitimage, 0, 0, 30,30,null);
	ImageIcon exiticon  = new ImageIcon(exitret);
	Exit = new JMenuItem("Exit",exiticon);
	Exit.setBackground(Color.WHITE);
	
	
	
	BufferedImage foimage = ImageIO.read(getClass().getResource("/images/font.gif"));
	BufferedImage foret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	foret.getGraphics().drawImage(foimage, 0, 0, 30,30,null);
	ImageIcon foicon  = new ImageIcon(foret);
	Font  =  new JMenuItem("Font",foicon);
	Font.setBackground(Color.WHITE);
	ta.setBounds(0, 0, 500, 500);
	SP = new JScrollPane(ta);
	SP.setBackground(new Color(255,165,0,125));
	f1.add(SP);
	Help.add(gethelp);
	Format.add(Font);
	//View.add(cbmi);
	//
	File.add(New);
	File.addSeparator();
	File.add(Open);
	File.addSeparator();
	File.add(Save);
	File.addSeparator();
	File.add(SaveAs);
	File.addSeparator();
	File.add(PageSetup);
	File.addSeparator();
	File.add(Print);
	File.addSeparator();
	
  	File.add(Exit);
  	gethelp.addActionListener(new ActionListener() {
		
	@Override
		public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new java.net.URI("https://www.slideshare.net/info_zybotech/notepad-tutorial"));
			}catch(IOException e1) {
				e1.getStackTrace();
			}catch(URISyntaxException e2) 
			{
				e2.getStackTrace();
			}
			
		}
	});

  	linewrap.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (linewrap.isSelected()) 
			{
				ta.setLineWrap(true);
			}
			else 
			{
				ta.setLineWrap(false);
			}
			
		}
	});
  	View.add(linewrap);
  	
//	
//	
//	
	//
BufferedImage undoimage = ImageIO.read(getClass().getResource("/images/UNDO.gif"));
	BufferedImage undoret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	undoret.getGraphics().drawImage(undoimage, 0, 0, 30,30,null);
	ImageIcon undoicon  = new ImageIcon(undoret);
	e1 = new JMenuItem("Undo",undoicon);
	e1.setBackground(Color.WHITE);
//	e2 = new JMenuItem("     ");
	BufferedImage cutimage = ImageIO.read(getClass().getResource("/images/CUT.gif"));
	BufferedImage cutret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	cutret.getGraphics().drawImage(cutimage, 0, 0, 30,30,null);
	ImageIcon cuticon  = new ImageIcon(cutret);
	e3 = new JMenuItem("Cut",cuticon);
	e3.setBackground(Color.WHITE);
	BufferedImage copyimage = ImageIO.read(getClass().getResource("/images/COPY.gif"));
	BufferedImage copyret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	copyret.getGraphics().drawImage(copyimage, 0, 0, 30,30,null);
	ImageIcon copyicon  = new ImageIcon(copyret);
	

	e4 = new JMenuItem("Copy",copyicon);
	e4.setBackground(Color.WHITE);
	
	
	
	
	BufferedImage ptimage = ImageIO.read(getClass().getResource("/images/paste.gif"));
	BufferedImage ptret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	ptret.getGraphics().drawImage(ptimage, 0, 0, 30,30,null);
	ImageIcon pticon  = new ImageIcon(ptret);
	e5 = new JMenuItem("Paste",pticon);
	e5.setBackground(Color.WHITE);
	
	
	/*e6 = new JMenuItem("Delete");*/
	//e7 = new JMenuItem("     ");
	BufferedImage fimage = ImageIO.read(getClass().getResource("/images/Find.gif"));
	BufferedImage fret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	fret.getGraphics().drawImage(fimage, 0, 0, 30,30,null);
	ImageIcon ficon  = new ImageIcon(fret);
	e8 = new JMenuItem("Find/Replace",ficon);
	e8.setBackground(Color.WHITE);
	
	
	
	//e9 = new JMenuItem("Goto");
	//e10 =new JMenuItem("     "); 
	BufferedImage saimage = ImageIO.read(getClass().getResource("/images/select.gif"));
	BufferedImage saret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	saret.getGraphics().drawImage(saimage, 0, 0, 30,30,null);
	ImageIcon saicon  = new ImageIcon(saret);
	e11 = new JMenuItem("Select All",saicon);
	e11.setBackground(Color.WHITE);
	
	
	
	BufferedImage tdimage = ImageIO.read(getClass().getResource("/images/time.gif"));
	BufferedImage tdret = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
	tdret.getGraphics().drawImage(tdimage, 0, 0, 30,30,null);
	ImageIcon tdicon  = new ImageIcon(tdret);
	e12 = new JMenuItem("Time/Date",tdicon);
	e12.setBackground(Color.WHITE);
	
	
	
	JMenuBar mbar = new JMenuBar();
	
	mbar.setBackground(new Color(255,165,0,125));
	mbar.add(File);
	mbar.add(Edit);			
	mbar.add(Format);
	mbar.add(View);
	mbar.add(Help);
	pop.add(undo);
	pop.add(redo2);
	pop.addSeparator();
	pop.add(cut);
	pop.add(copy);
	pop.add(paste);
	pop.addSeparator();
	pop.add(selectall);
	//pop.add(test);
	Edit.add(e1);
	Edit.addSeparator();
	Edit.add(Redo);
	Edit.addSeparator();
	//Edit.add(e2);
	Edit.add(e3);
	Edit.addSeparator();
	Edit.add(e4);
	Edit.addSeparator();
	Edit.add(e5);Edit.addSeparator();
	//Edit.add(e6);
	//Edit.add(e7);
	Edit.add(e8);
	Edit.addSeparator();
	//Edit.add(e9);
	
	//Edit.add(e10);
	Edit.add(e11);
	Edit.addSeparator();
	Edit.add(e12);
	//
	//
	//      
	
	
	
	//Edit.add(test);
	//addMouseListener(new PopupTriggerListener());
	  
	
	ta.addMouseListener(new  MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if(SwingUtilities.isRightMouseButton(e))
			{	pop.show(ta, e.getX(), e.getY());
			}
		}
	});
	
	Font.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f4 = new JFrame("Font");
			String[] s2 = {"Regular","Italic","Bold","Bold Italic"};
			String[] s3 = { "8", "9", "10", "11", "12", "14", "16", "18", "20",
			        "22", "24", "26", "28", "36", "48", "72",};
			 String[] s = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			JComboBox cb1 = new JComboBox(s);
			JComboBox cb2 = new JComboBox(s2);
			JComboBox cb3 = new JComboBox(s3);
			JButton b1 = new JButton("Apply to selected Text");
			JButton b2 = new JButton("OK");
			
			
			JButton b3 = new JButton("Cancel");
			JLabel sample = new JLabel("Sample:");
			JTextArea tau = new JTextArea("ABCDEFG abcdefg & @ $ % ");
			 
			    
			     
			    	
			    cb2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = cb1.getSelectedItem().toString(); 
						int size = Integer.parseInt(cb3.getSelectedItem().toString());
						    String style= cb2.getSelectedItem().toString();	
						switch(style) 
						{ 
					    case "Regular" : tau.setFont(new Font(name,java.awt.Font.PLAIN,size));
					                    break;
					    case "Bold" : tau.setFont(new Font(name,java.awt.Font.BOLD,size));
		                break;
					    case "Italic" : tau.setFont(new Font(name,java.awt.Font.ITALIC,size));
		                break;
					    case "Bold Italic" : tau.setFont(new Font(name,java.awt.Font.BOLD+java.awt.Font.ITALIC,size));
		                break;
					    }
					    	
					}
				});
			      	cb1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String name = cb1.getSelectedItem().toString(); 
							int size = Integer.parseInt(cb3.getSelectedItem().toString());
							    String style= cb2.getSelectedItem().toString();	
							switch(style) 
							{ 
						    case "Regular" : tau.setFont(new Font(name,java.awt.Font.PLAIN,size));
						                    break;
						    case "Bold" : tau.setFont(new Font(name,java.awt.Font.BOLD,size));
			                break;
						    case "Italic" : tau.setFont(new Font(name,java.awt.Font.ITALIC,size));
			                break;
						    case "Bold Italic" : tau.setFont(new Font(name,java.awt.Font.BOLD+java.awt.Font.ITALIC,size));
			                break;
						    }
			
							
						}
					});
                  cb3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = cb1.getSelectedItem().toString(); 
						int size = Integer.parseInt(cb3.getSelectedItem().toString());
						    String style= cb2.getSelectedItem().toString();	
						switch(style) 
						{ 
					    case "Regular" : tau.setFont(new Font(name,java.awt.Font.PLAIN,size));
					                    break;
					    case "Bold" : tau.setFont(new Font(name,java.awt.Font.BOLD,size));
		                break;
					    case "Italic" : tau.setFont(new Font(name,java.awt.Font.ITALIC,size));
		                break;
					    case "Bold Italic" : tau.setFont(new Font(name,java.awt.Font.BOLD+java.awt.Font.ITALIC,size));
		                break;
					    }
						
					}
				});			      	
			    b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
						String name = cb1.getSelectedItem().toString(); 
						int size = Integer.parseInt(cb3.getSelectedItem().toString());
						    String style= cb2.getSelectedItem().toString();	
						switch(style) 
						{ 
					    case "Regular" : ta.setFont(new Font(name,java.awt.Font.PLAIN,size));
					                    break;
					    case "Bold" : ta.setFont(new Font(name,java.awt.Font.BOLD,size));
		                break;
					    case "Italic" : ta.setFont(new Font(name,java.awt.Font.ITALIC,size));
		                break;
					    case "Bold Italic" : ta.setFont(new Font(name,java.awt.Font.BOLD+java.awt.Font.ITALIC,size));
		                break;
					    }
					}
				});
			    b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = cb1.getSelectedItem().toString(); 
						int size = Integer.parseInt(cb3.getSelectedItem().toString());
						    String style= cb2.getSelectedItem().toString();	
						switch(style) 
						{ 
					    case "Regular" : ta.setFont(new Font(name,java.awt.Font.PLAIN,size));
					                    break;
					    case "Bold" : ta.setFont(new Font(name,java.awt.Font.BOLD,size));
		                break;
					    case "Italic" : ta.setFont(new Font(name,java.awt.Font.ITALIC,size));
		                break;
					    case "Bold Italic" : ta.setFont(new Font(name,java.awt.Font.BOLD+java.awt.Font.ITALIC,size));
		                break;
					    }						
						f4.setVisible(false);
					}
				});
			    b3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						f4.setVisible(false);						
					}
				});
			    
			    
			tau.setBounds(50, 150, 500, 200);
			sample.setBounds(50, 120, 70, 30);
			b1.setBounds (50, 400 , 200, 30);
			b2.setBounds(360, 400,100, 30);
			b3.setBounds(480,400,100,30);
			b3.setBackground(new Color(250,0,0,125));
			b2.setBackground(Color.gray);
			b1.setBackground(Color.gray);
		

			
			JLabel l1 = new JLabel("Font:");
			JLabel l2 = new JLabel("Style:");
			JLabel l3 = new JLabel("Size:");
			cb3.setBounds(470,50,110,30);
			cb2.setBounds(280,50,170,30);
			cb1.setBounds(10,50,250,30);
			l1.setBounds(10, 20, 40, 30);
			l2.setBounds(280, 20, 40, 30);
			l3.setBounds(470, 20, 40, 30);
			f4.setResizable(false);
			f4.add(b3);
			f4.add(tau);
			f4.add(sample);
	  f4.add(b2);
	   f4.add(b1);
	   f4.add(l1);
	   f4.add(cb1); 
	   f4.add(cb2);
	   f4.add(cb3);
	   f4.add(l2);
	   f4.add(l3);
	   f4.setBounds(520,200,600,500);
	   
	   
	 
//	   Font f1 = new Font("SansSerif", Font.BOLD,20); 
	//   b1.setFont(f1);	   
	   
	   
	   f4.setLayout(null);
	   f4.setVisible(true);
	   
			
		}
	});
	/*undo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		   //
			
		}
	});*/
	cut.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
ta.cut();
			
		}
	});
	copy.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ta.copy();
			
		}
	});
	paste.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		ta.paste();
			
		}
	});
	selectall.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		ta.selectAll();
			
		}
	});
	f1.setJMenuBar(mbar);
	Open.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Open) {
			JFileChooser fc = new JFileChooser();	
				int i  = fc.showOpenDialog(Open);
				if(i== JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
				    String filepath = f.getPath();	
					try {BufferedReader br = new BufferedReader(new FileReader(filepath));
					String a,b = "";
					while((a=br.readLine())!=null)
					{b += a+"\n";
					ff = filepath;
					 bbk = false ;
					}
					ta.setText(b);
					br.close();
					}catch(Exception ex) 
					{ex.printStackTrace();
					}
					}
		}	
		}
	});
	SaveAs.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			bbk = true;
			if(bbk==true) {
			File fd = new File("//home//amol//Desktop");
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(fd);
		fc.setDialogTitle("Save As...");
		int  i = fc.showSaveDialog(SaveAs);
		if(i== JFileChooser.APPROVE_OPTION) 
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fc.getSelectedFile().getPath()) );
	 		pw.print(ta.getText());
		 
			pw.close(); ff = fc.getSelectedFile().getPath();ff1 = fc.getSelectedFile();//System.out.println(ff);
		   bbk = false;
		}catch(Exception ex) 
		{
		   ex.getStackTrace();	
		}
		}}
	});
	Save.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(bbk==true) {
				File fd = new File("//home//amol//Desktop");
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(fd);
			fc.setDialogTitle("Save As...");
			int  i = fc.showSaveDialog(SaveAs);
			if(i== JFileChooser.APPROVE_OPTION) 
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(fc.getSelectedFile().getPath()) );
		 		pw.print(ta.getText());
			 
				pw.close(); ff = fc.getSelectedFile().getPath();ff1 = fc.getSelectedFile();//System.out.println(ff);
			   bbk = false;
			}catch(Exception ex) 
			{
			   ex.getStackTrace();	
			}
			}
			else { 
			try{
				PrintWriter pw = new PrintWriter(ff);
		 		pw.print(ta.getText());
			 
				pw.close(); 
			}catch(Exception ex) 
			{
				   ex.getStackTrace();	
				}
		}}
	});
	PageSetup.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			PrinterJob job = PrinterJob.getPrinterJob();
			PageFormat pf = job.pageDialog(job.defaultPage());
		}
	});
	Print.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		try {
		Boolean complete =	 ta.print();
			if(complete) {
				 JOptionPane.showMessageDialog(null, "Done Printing","Information", JOptionPane.INFORMATION_MESSAGE);
			}else {JOptionPane.showMessageDialog(null, "Printing !", "Printer",JOptionPane.ERROR_MESSAGE );}
		}catch(PrinterException ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
			
		}
		});
	
		New.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Main.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
		Exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f2 = new JFrame("Exit");
				JLabel l = new JLabel("Select one Option");
				JButton b1 = new JButton("Save and Exit");
				JButton b2 = new JButton("Exit Anyways");
				Font fr = new Font("SansSerif Bold", java.awt.Font.BOLD,12);
				Font fr2 = new Font("SansSerif Bold", java.awt.Font.BOLD,20);
				l.setBounds(60, 5 ,200 , 70);
				l.setFont(fr2);
				b1.setBounds(15, 100, 125, 30);
				b2.setBounds(155,100,125,30);
				b1.setFont(fr);
				b2.setFont(fr);
				b1.setBackground(new Color(0,150,0,125));
				b2.setBackground(new Color(150,0,0,100));
				b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(bbk==true) {
							File fd = new File("//home//amol//Desktop");
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(fd);
						fc.setDialogTitle("Save As...");
						int  i = fc.showSaveDialog(SaveAs);
						if(i== JFileChooser.APPROVE_OPTION) 
						try {
							PrintWriter pw = new PrintWriter(new FileWriter(fc.getSelectedFile().getPath()) );
					 		pw.print(ta.getText());
						 
							pw.close(); ff = fc.getSelectedFile().getPath();ff1 = fc.getSelectedFile();//System.out.println(ff);
						   bbk = false;
						}catch(Exception ex) 
						{
						   ex.getStackTrace();	
						}
						}
						else { 
						try{
							PrintWriter pw = new PrintWriter(ff);
					 		pw.print(ta.getText());
						 
							pw.close(); 
						}catch(Exception ex) 
						{
							   ex.getStackTrace();	
							}
						 f2.setVisible(false);
						    f1.setVisible(false);
					}
						
					}
				});
				b2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					    f2.setVisible(false);
					    f1.setVisible(false);
						
					}
				});
				f2.setBounds(500,295,300, 200);
				f2.add(l);
				f2.add(b1);
				f2.add(b2);
				f2.setLayout(null);
				f2.setResizable(false);
				f2.setVisible(true);
				
			}
		});		
	//
	//
		
	/*e9.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame f5 = new JFrame("Go To Line");
			JButton bb1 = new JButton("Go To");
			JButton bb2 = new JButton("Cancel");
			JTextField tf = new JTextField();
			JLabel ll1 = new JLabel("Line number:");
			ll1.setBounds(10,10,100,20);
			tf.setBounds(10,40,300,30);
			bb1.setBounds(120, 125,90,25 );
			bb2.setBounds(220,125,90,25);
			bb1.setBackground(Color.gray);
			bb2.setBackground(new Color(200,0,0,125));
			bb2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					f5.setVisible(false);
					
				}
			});
			
			bb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ta.setHighlighter(null);
					f5.setVisible(false);
				}
			});
			
			
			f5.add(bb1);
			f5.add(bb2);
			f5.add(tf);
			f5.add(ll1);
			f5.setResizable(false);
			f5.setBounds(520,300,320,200);
			f5.setLayout(null);
			f5.setVisible(true);	
		}
	});	*/
		ta.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undomanager.addEdit(e.getEdit());
				updateButtons();
				
			}
		});
	
	
	
	
	
	
	
	
	
	e1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
         try {     
		undomanager.undo();
         }catch(CannotUndoException cue) {
        	 cue.getStackTrace();
         }
		updateButtons();	
		}
	});	
	Redo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				undomanager.redo();
			}catch(CannotRedoException cre)
			{
				cre.getStackTrace();
			}
			updateButtons();
		}
	});
	undo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			  try {     
					undomanager.undo();
			         }catch(CannotUndoException cue) {
			        	 cue.getStackTrace();
			         }
					updateButtons();		
		}
	});
	redo2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				undomanager.redo();
			}catch(CannotRedoException cre)
			{
				cre.getStackTrace();
			}
			updateButtons();
			
		}
	});
	e3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ta.cut();
			
		}
	});
	e4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ta.copy();
			
		}
	});
	e5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ta.paste();
			
		}
	});
	/*e6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		ta.setText(ta.getText().replace(ta.getSelectedText(),""));
		}
	});*/
	e8.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	     JFrame f3  = new JFrame("Find/Replace") ;
	     JTextField l1  = new JTextField();
	     JTextField l2 = new JTextField();
	     JCheckBox b = new JCheckBox("Case Sensitive");
	     b.setSelected(true);
	     JButton find = new JButton("Find 1st");
	     JButton findnext = new JButton("Find All");
	     JButton replace =  new JButton("Replace 1st");
	     JButton replaceall = new JButton("Replace All");
	     l1.setBounds(10, 20, 380,25);
	     l2.setBounds(10, 160, 380, 25);
	     b.setBounds(150,100,150,50);
	     l2.setToolTipText("Enter word you want to Replace with");
         l1.setToolTipText("Enter word you want to Find");
	     find.setBounds(10,55,120,30);
	     find.setBackground(new Color(250,250,0,150));
	     findnext.setBackground(new Color(220,220,0,150));
	     findnext.setBounds(270, 55, 120, 30);
	     replace.setBounds(10,195,120,30);
	     replaceall.setBounds(270,195,120,30);
	     replace.setBackground(new Color(0,250,0,150));
	     replaceall.setBackground(new Color(0,200,0,150));
	
	    //******************************************************************************
	     findnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Highlighter h = ta.getHighlighter();
					h.removeAllHighlights();
					String findtext = l1.getText();
					Document doc = ta.getDocument();
					String text = doc.getText(0, doc.getLength());
					int pos =0;
					while((pos=text.indexOf(findtext,pos))>=0) {
					h.addHighlight(pos, pos+findtext.length(),DefaultHighlighter.DefaultPainter);	
					pos += findtext.length();
					
					f3.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosing(WindowEvent e) {
							h.removeAllHighlights();							
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
						
					}
					
				}catch(Exception e3) {
					
				}				
			}
		});
	     

	     find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Highlighter h = ta.getHighlighter();
			h.removeAllHighlights();
			String from = l1.getText();
			int start = ta.getText().indexOf(from);
			if(start>=0 && from.length()>0)
			{	try {
					h.addHighlight(start, start+from.length(),DefaultHighlighter.DefaultPainter );
				  
				} catch (BadLocationException e1) {
										e1.getStackTrace();
					
		}}else {JOptionPane.showMessageDialog(null,"No Match Found");}
		  f3.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				h.removeAllHighlights();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
			
			
			
			
	    }	
		});
	     replace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String from = l1.getText();	
				int start = ta.getText().indexOf(from);
				if(start>=0 && from.length()>0)
					ta.replaceRange(l2.getText(), start, start
				              + from.length());
				else {JOptionPane.showMessageDialog(null,"No Match Found");}

			}
		});
	     replaceall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			Boolean	x = true ;
				while(x == true)
				{	String from = l1.getText();	
				int start = ta.getText().indexOf(from);
				if(start>=0 && from.length()>0)
					ta.replaceRange(l2.getText(), start, start
				              + from.length());
				else 
				{x = false;}		
			}}
		});
	         
	    //f3.add(b);
		f3.add(find);
		f3.add(findnext);
		f3.add(replace);
		f3.add(replaceall);
		f3.add(l1);
		f3.add(l2);
		f3.setBounds(475,245,400, 300);
		f3.setResizable(false);
		f3.setLayout(null);
		f3.setVisible(true);
	     
		}
	});
	
	
	
	
	
	
	
	e11.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		 ta.selectAll();
			
		}
		
	});
	e12.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("  HH:mm  dd/MM/yyyy");
			ta.setText(ta.getText()+sdf.format(date));
		}
	});//ta.setBounds(0,0,550,550);
	ta.add(pop);
	//f1.add(ta);
	//f1.setLayout(null);
	/*label2 = new JLabel();
	toolbar.add(label2);
	f1.add(toolbar, BorderLayout.SOUTH);
	toolbar.setVisible(false);
	cbmi.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		   if(cbmi.isSelected())   
		   {      ta.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				int s =   ta.getCaretPosition();
		          String   b = Integer.toString(s);
		           label2.setText(b);
                toolbar.setVisible(true);			
		
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				int s =   ta.getCaretPosition();
		          String   b = Integer.toString(s);
		           label2.setText(b);
                toolbar.setVisible(true);			
		
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				int s =   ta.getCaretPosition();
		          String   b = Integer.toString(s);
		           label2.setText(b);
                toolbar.setVisible(true);			
		
			}
		});
			         }
		   else
		   {toolbar.setVisible(false);
		   }
		}
	});*/
	
		
		
		
		
	
	Image icon = Toolkit.getDefaultToolkit().getImage("//home//amol//Downloads//accessories-text-editor-icon.png");
	f1.setIconImage(icon);
	f1.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			JFrame f2 = new JFrame("Exit");
			JLabel l = new JLabel("Select one Option");
			JButton b1 = new JButton("Save and Exit");
			JButton b2 = new JButton("Exit Anyways");
			Font fr = new Font("SansSerif Bold", java.awt.Font.BOLD,12);
			Font fr2 = new Font("SansSerif Bold", java.awt.Font.BOLD,20);
			l.setBounds(60, 5 ,200 , 70);
			l.setFont(fr2);
			b1.setBounds(15, 100, 125, 30);
			b2.setBounds(155,100,125,30);
			b1.setFont(fr);
			b2.setFont(fr);
			b1.setBackground(new Color(0,150,0,125));
			b2.setBackground(new Color(150,0,0,100));
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(bbk==true) {
						File fd = new File("//home//amol//Desktop");
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(fd);
					fc.setDialogTitle("Save As...");
					int  i = fc.showSaveDialog(SaveAs);
					if(i== JFileChooser.APPROVE_OPTION) 
					try {
						PrintWriter pw = new PrintWriter(new FileWriter(fc.getSelectedFile().getPath()) );
				 		pw.print(ta.getText());
					 
						pw.close(); ff = fc.getSelectedFile().getPath();ff1 = fc.getSelectedFile();//System.out.println(ff);
					   bbk = false;
					}catch(Exception ex) 
					{
					   ex.getStackTrace();	
					}
					}
					else { 
					try{
						PrintWriter pw = new PrintWriter(ff);
				 		pw.print(ta.getText());
					 
						pw.close(); 
					}catch(Exception ex) 
					{
						   ex.getStackTrace();	
						}
					 f2.setVisible(false);
					    f1.setVisible(false);
				}
					
				}
			});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				    f2.setVisible(false);
				    f1.setVisible(false);
					
				}
			});
			f2.setBounds(500,295,300, 200);
			f2.add(l);
			f2.add(b1);
			f2.add(b2);
			f2.setLayout(null);
			f2.setResizable(false);
			f2.setVisible(true);
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	//f1.add(toolbar,BorderLayout.SOUTH);
	f1.setJMenuBar(mbar);
	f1.setBounds(380,100,600,600);
	f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	//f1.setLayout(null);
	f1.setVisible(true);			
}


	
protected void updateButtons() {
	e1.setText(undomanager.getUndoPresentationName());
	e1.setEnabled(undomanager.canUndo());
	Redo.setText(undomanager.getRedoPresentationName());
    Redo.setEnabled(undomanager.canRedo());
}



public static void main(String[] args) throws IOException {
new Main();				
}
}
