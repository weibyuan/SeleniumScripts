package com.pimco.stepdefinition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

import com.automation.AutomationLibrary.*;
import com.pimco.runner.BaseRunner;
import com.pimco.util.EmailSource;
import com.pimco.util.EnvironmentConfig;

public class Helper {
	private final static Logger log = Logger.getLogger(Helper.class.getName());
	private static String directory = System.getProperty("user.dir");
	static String finalListOfbadTickers;
	static String badTickers;
	BaseStepDef br = new BaseStepDef();

//	BaseRunner baserunner = new BaseRunner();
	static File tickerDirectory = new File(directory + "\\target\\failedScenarios");

	public synchronized void writeToFile(String ticker, String error) {
		if (!tickerDirectory.exists()) {
			tickerDirectory.mkdir();
		}

		String fileName = tickerDirectory.getPath() + "\\failures.txt";
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(br.scenarioName + "|" + ticker + "\t" + error + "\r\n\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void sendEmail() throws Throwable {

		try {
			String osName = System.getProperty("os.name");
			String strdate = getDate();
			File reportfolder = new File("//VMF001PY/DFSpimco/Share/QualityCenter/CRM_BDD_Reports/" + strdate + "/"
					+ System.getProperty("environment") + "/" + System.getProperty("browser") + "/UI/");

			if (!reportfolder.exists()) {
				reportfolder.mkdirs();
			}
			System.out.println(reportfolder.getPath());
			Runtime rt = Runtime.getRuntime();
			Process pr = null;
			if (osName.contains("Mac") || osName.contains("mac") || osName.contains("linux")
					|| osName.contains("Linux")) {
				pr = rt.exec(
						"allure-2.12.1/bin/allure generate target/allure-results --clean -o " + reportfolder.getPath());
			} else {
				pr = rt.exec("allure-2.12.1\\bin\\allure.bat generate target\\allure-results --clean -o "
						+ reportfolder.getPath());
				// pr = rt.exec("allure-2.12.1\\bin\\allure.bat serve target\\allure-results
				// --clean -o"+ reportfolder.getPath());
			}
			pr.waitFor();
			String reportLocation = reportfolder + "/index.html";

			if (tickerDirectory.exists()) {
				finalListOfbadTickers = directory + "\\target\\badTickers" + strdate + "\\Riojafailurescenarios.txt";
				badTickers = directory + "\\target\\badTickers" + strdate + "\\tickers.txt";

			}

			EmailSource emailSource = EnvironmentConfig.getEmailSource();
			String subject;
			String body;
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", false);
			properties.put("mail.smtp.host", emailSource.getEmailSMTPServerHost());
			properties.put("mail.smtp.port", emailSource.getEmailSMTPServerPort());
			properties.put("mail.transport.protocol", "smtp");
			String text;
			String environment;
			// Authenticator authenticator = new Authenticator() {
			// @Override
			// protected PasswordAuthentication getPasswordAuthentication() {
			// return new PasswordAuthentication(emailSource.getSenderEmail(),
			// emailSource.getSenderEmailPwd());
			// }
			// };
			// Session session = Session.getDefaultInstance(properties, authenticator);
			Session session = Session.getDefaultInstance(properties);
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set Sender Email Address
			message.setFrom(new InternetAddress(emailSource.getSenderEmail()));
			// Set Recipient Email Address

			// message.setRecipients(Message.RecipientType.TO,
			// InternetAddress.parse("Jennifer.Hsu@pimco.com,Veda.Gaddam@pimco.com,Jinwoong.Joung@pimco.com,w8y5h0m4p0z2f9t8@pimco.slack.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailSource.getRecipientEmail()));

			// Set Recipient cc Email Address
			// message.setRecipients(Message.RecipientType.CC,
			// InternetAddress.parse("lakshmi.makireddy@pimco.com,Prakash.Vivekanandan@pimco.com,Taehee.Jung@pimco.com,Vinod.Bhatt@pimco.com,Venugopal.Vanarasi@pimco.com,Michael.Stotler@pimco.com,Sumanth.Gowda@pimco.com,Alison.Congdon@pimco.com,Vijay.Jonnakuti@pimco.com,Prashant.Navale@pimco.com,Ayush.Rastogi@pimco.com,Ashim.Mehta@pimco.com,Paresh.Dabhi@pimco.com,Anil.Medikonda@pimco.com,Anil.Medikonda@pimco.com"));
			// message.setRecipients(Message.RecipientType.CC,
			// InternetAddress.parse("lakshmi.makireddy@pimco.com"));
			// get no of lines in a text

			if (System.getProperty("environment").equalsIgnoreCase("PROD")) {
				environment = "portal.pimco.com UI Summary Testing - " + System.getProperty("browser") + " - ";
			} else {
				environment = System.getProperty("environment") + " UI Summary Testing - "
						+ System.getProperty("browser") + " - ";
			}

			if ((br.bStatus == true) && (br.iScriptCount > 0)) {
				subject = "PASS : CRM " + environment + " " + strdate;
				text = "Hi Team,<br/><a href=" + reportLocation
						+ ">Link to UI report</a><br/><br/>Note: Please open this report in chrome browser or Microsoft edge.<br/><br/>Thanks,<br/>QA Team";
			} else {
				subject = "FAIL : CRM " + environment + " " + strdate;
				text = "Hi Team,<br/><br/><br/><a href=" + reportLocation
						+ ">Link to UI report</a><br/><br/>Note: Please open this report in Microsoft edge.<br/><br/>Thanks,<br/>QA Team";
			}

			//// Set Subject
			message.setSubject(subject);

			// Create the message part and set the value
			BodyPart messageBodyPart = new MimeBodyPart();
			InternetHeaders headers = new InternetHeaders();
			headers.addHeader("Content-type", "text/html; charset=UTF-8");

			messageBodyPart.setContent(text, "text/html");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			if (tickerDirectory.exists()) {
				// create object of Path
				Path path = Paths.get(finalListOfbadTickers);

				// call getFileName() and get FileName path object
				String fileName = path.getFileName().toString();
				/// Set the attachment message body
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(finalListOfbadTickers);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(fileName);

				multipart.addBodyPart(messageBodyPart);
			}

			// Send the complete message parts
			message.setContent(multipart);

			// Send Email
			Transport.send(message);
			log.info("Email sent successfully.");

			// Helper.getInstance().sendEmail("Rioja Ticker", "");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Email not sent due to error message as " + e.getMessage());
			log.debug(e.getMessage());

		}
	}

	public static int getLinesCount(String finalListOfbadTickers, String badTickers) throws Exception

	{

		// PrintWriter object for output.txt
		PrintWriter pw = new PrintWriter(finalListOfbadTickers);

		// BufferedReader object for input.txt
		BufferedReader br = new BufferedReader(new FileReader(badTickers));

		String line = br.readLine();

		// set store unique values
		HashSet<String> hs = new HashSet<String>();

		// loop for each line of input.txt
		while (line != null) {
			// write only if not
			// present in hashset
			if (hs.add(line))
				pw.println(line);

			line = br.readLine();

		}

		pw.flush();

		// closing resources
		br.close();
		pw.close();

		System.out.println("File operation performed successfully");

		List<String> lines = Files.readAllLines(Paths.get(finalListOfbadTickers), Charset.defaultCharset());
		return lines.size();

	}

	public String getDate() {

		LocalDate localDate = LocalDate.now();
		String output = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
//		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		String output = f.format(workingDay);
		System.out.println("current date " + output);
		return output;

	}

}
