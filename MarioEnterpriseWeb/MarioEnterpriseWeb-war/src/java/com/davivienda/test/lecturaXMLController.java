/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davivienda.test;

import com.davivienda.entities.cobrosMensualPorCanal;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Esparta_86
 */
@ManagedBean(name = "lecturaxmlcontroller")
@ViewScoped
public class lecturaXMLController {
    
    private String xmlPage;
    private List<cobrosMensualPorCanal> listaPeticionCargoColector;
    
    @PostConstruct
    public void init() {
        xmlPage = "";
        listaPeticionCargoColector = new ArrayList<cobrosMensualPorCanal>();
        
    }
       public void leerTextAreaAccion(){
           readString(xmlPage, "peticionCargoColector");
       }
    
        public void readString(String xml, String nodoPrincipal) {
        try {
            listaPeticionCargoColector = new ArrayList();
            InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8.name()));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(nodoPrincipal);

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    cobrosMensualPorCanal peti = new cobrosMensualPorCanal();
                    peti.setIdColector(new Integer(eElement.getElementsByTagName("idColector").item(0).getTextContent()));
                    peti.setIdCanal(new Integer(eElement.getElementsByTagName("idCanal").item(0).getTextContent()));
                    peti.setCuentaAbono(eElement.getElementsByTagName("cuentaAbono").item(0).getTextContent());
                    peti.setCuentaCargo(eElement.getElementsByTagName("cuentaCargo").item(0).getTextContent());
                    peti.setMontoTotal(new BigDecimal(eElement.getElementsByTagName("montoTotal").item(0).getTextContent()));
                    peti.setEstado(eElement.getElementsByTagName("estado").item(0).getTextContent().charAt(0));
                    listaPeticionCargoColector.add(peti);

                }

            }
            
            if (!this.listaPeticionCargoColector.isEmpty()) {
                //persistir
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new instance of lecturaXMLController
     */
    public lecturaXMLController() {
    }

    /**
     * @return the xmlPage
     */
    public String getXmlPage() {
        return xmlPage;
    }

    /**
     * @param xmlPage the xmlPage to set
     */
    public void setXmlPage(String xmlPage) {
        this.xmlPage = xmlPage;
    }
    
    
    
}
