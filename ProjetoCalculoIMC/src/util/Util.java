/**
 * 
 */
package util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import models.IMC;

/**
 * Programa para calcular o indice de Massa Corporal
 * 
 * @author Rafhael Honda da Silva
 * @author José Roberto Felix da Silva
 *
 */
public class Util {

	public enum genero {
		masculino, feminino
	}	

	public static DocumentFilter somenteNumeros() {
		return new DocumentFilter() {
			Pattern regex = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*");

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				Matcher matcher = regex.matcher(text);
				if (!matcher.matches()) {
					return;
				}
				super.replace(fb, offset, length, text, attrs);
			}
		};
	}

	public static double tryParseDouble(String valor) {
		double resultado;
		try {
			resultado = Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			resultado = 0;
		}
		return resultado;
	}
	
	public static Image obtemImagemRelatorio(String imageName) throws BadElementException, MalformedURLException, IOException  {
		return Image.getInstance(Util.class.getResource("/resources/images/" + imageName).getPath());		
	}

	public static ImageIcon obtemImagemIcon(String imageName) {
		return new ImageIcon(Util.class.getResource("/resources/images/" + imageName));
	}
	
	public static Image relatorioImagem(genero g, double valor) throws BadElementException, MalformedURLException, IOException {
		Image image = null;

		switch (g) {
		case masculino:
			if (valor < 19.99) {
				image = obtemImagemRelatorio("image02.png");

			} else if (valor >= 20 && valor <= 24.99) {
				image = obtemImagemRelatorio("image03.png");

			} else if (valor >= 25 && valor <= 29.99) {
				image = obtemImagemRelatorio("image04.png");

			} else if (valor >= 30 && valor <= 39.99) {
				image = obtemImagemRelatorio("image06.png");

			} else if (valor >= 40) {
				image = obtemImagemRelatorio("image07.png");

			}
			break;
		case feminino:
			if (valor < 19.99) {
				image = obtemImagemRelatorio("image02.png");
			} else if (valor >= 19 && valor <= 23.99) {
				image = obtemImagemRelatorio("image03.png");
			} else if (valor >= 24 && valor <= 28.99) {
				image = obtemImagemRelatorio("image04.png");
			} else if (valor >= 29 && valor <= 38.99) {
				image = obtemImagemRelatorio("image06.png");
			} else if (valor >= 39) {
				image = obtemImagemRelatorio("image07.png");
			}
			break;
		default:
			break;
		}

		return image;
	}

	public static ImageIcon exibeImagemIMC(genero g, double valor) {
		ImageIcon image = new ImageIcon();

		switch (g) {
		case masculino:
			if (valor < 19.99) {
				image = obtemImagemIcon("image02.png");

			} else if (valor >= 20 && valor <= 24.99) {
				image = obtemImagemIcon("image03.png");

			} else if (valor >= 25 && valor <= 29.99) {
				image = obtemImagemIcon("image04.png");

			} else if (valor >= 30 && valor <= 39.99) {
				image = obtemImagemIcon("image06.png");

			} else if (valor >= 40) {
				image = obtemImagemIcon("image07.png");

			}
			break;
		case feminino:
			if (valor < 19.99) {
				image = Util.obtemImagemIcon("image02.png");
			} else if (valor >= 19 && valor <= 23.99) {
				image = Util.obtemImagemIcon("image03.png");
			} else if (valor >= 24 && valor <= 28.99) {
				image = Util.obtemImagemIcon("image04.png");
			} else if (valor >= 29 && valor <= 38.99) {
				image = Util.obtemImagemIcon("image06.png");
			} else if (valor >= 39) {
				image = Util.obtemImagemIcon("image07.png");
			}
			break;
		default:
			break;
		}

		return image;
	}

	public static String obtemArquivoTexto(genero g, double valor) {
		String resultado = "";

		switch (g) {
		case masculino:

			if (valor < 19.99) {
				resultado = "abaixodonormal.txt";
			} else if (valor >= 20 && valor <= 24.99) {

				resultado = "normal.txt";
			} else if (valor >= 25 && valor <= 29.99) {

				resultado = "obesidadeleve.txt";
			} else if (valor >= 30 && valor <= 39.99) {

				resultado = "obesidademoderada.txt";
			} else if (valor >= 40) {

				resultado = "obesidademorbida.txt";
			}

			break;
		case feminino:

			if (valor < 19.99) {
				resultado = "abaixodonormal.txt";
			} else if (valor >= 19 && valor <= 23.99) {
				resultado = "normal.txt";
			} else if (valor >= 24 && valor <= 28.99) {
				resultado = "obesidadeleve.txt";
			} else if (valor >= 29 && valor <= 38.99) {
				resultado = "obesidademoderada.txt";
			} else if (valor >= 39) {
				resultado = "obesidademorbida.txt";
			}

			break;
		default:
			break;
		}

		return resultado;
	}

	public static boolean gerarRelatorio(IMC imc, genero g) {
		Document document = new Document();
		boolean resultado = false;
		double valorIMC;
		String nomeArquivoTxt;
		String generoDesc = "";

		try {

			String userDir = System.getProperty("user.dir");			

			Paths.get(userDir + "\\resultados");

			DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();

			PdfWriter.getInstance(document, new FileOutputStream(
					userDir + "\\resultados\\" + imc.getNome() + dataFormato.format(now) + ".pdf"));
			document.open();

			valorIMC = imc.calcular();

			var titulo = new Paragraph("Relatório - IMC");
			titulo.setAlignment(Element.ALIGN_CENTER);
			document.add(titulo);
			
			if (g == genero.masculino) {
				generoDesc = "Masculino";			
			}else {
				generoDesc = "Feminino";
			}
			
			
			DecimalFormat df = new DecimalFormat("#,###.00");

			document.add(new Paragraph("Nome: " + imc.getNome()));
			document.add(new Paragraph("Genero: " + generoDesc));
			document.add(new Paragraph("Altura: " + imc.getAltura()));
			document.add(new Paragraph("Peso: " + imc.getPeso()));
			document.add(new Paragraph("IMC: " + df.format(valorIMC)));
			document.add(new Paragraph("Data: " + dataFormato.format(now)));

			Image image = relatorioImagem(g, valorIMC);
			image.scaleAbsolute(394, 189);
			document.add(image);

			nomeArquivoTxt = Util.obtemArquivoTexto(g, valorIMC);

			var url = Util.class.getResource("/resources/txts/" + nomeArquivoTxt);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				document.add(new Paragraph(line));
			}

			reader.close();
			resultado = true;
			
			  
			File file = new File(userDir + "\\resultados\\" + imc.getNome() + dataFormato.format(now) + ".pdf");   
			if(Desktop.isDesktopSupported())  
			{	
				Desktop desktop = Desktop.getDesktop();  
				if(file.exists())  
					desktop.open(file);
			}  

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		document.close();

		return resultado;

	}
}
