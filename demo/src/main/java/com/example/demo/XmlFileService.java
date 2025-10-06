package com.example.demo;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class XmlFileService {

	/**
	 * Lee un fichero XML y devuelve el texto de todos los elementos con un nombre específico
	 * @param filePath ruta del XML
	 * @param tagName nombre de la etiqueta a leer
	 * @return lista de valores
	 * @throws Exception
	 */
	public List<String> readXml(String filePath, String tagName) throws Exception {
		List<String> result = new ArrayList<>();

		File xmlFile = new File(filePath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			String textContent = node.getTextContent().trim();
			if (!textContent.isEmpty()) { // validación simple
				result.add(textContent);
			}
		}

		return result;
	}
	
    // 👇 Nuevo método que imprime la salida
    public void printXml(String filePath, String tagName) throws Exception {
        List<String> values = readXml(filePath, tagName);

        System.out.println("📂 Leyendo XML: " + filePath);
        System.out.println("✅ Valores encontrados en <" + tagName + ">:");
        values.forEach(System.out::println);
    }
}


