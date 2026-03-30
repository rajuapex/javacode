package com.hotel.reservation.service.impl.pdf;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.reservation.model.Reservation;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */
public class PDFProcessor {
	private static final Logger logger = LoggerFactory.getLogger(PDFProcessor.class);
	private static final String RESERVATION_XSL = "/pdf/reservations.xsl";

	public static byte[] createPDF(List<Reservation> reservations) {

		List<JAXBReservation> jabxReservations = reservations.stream().map(JAXBReservation::new)
				.collect(Collectors.toList());

		JAXBResponse response = new JAXBResponse(jabxReservations);
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {

			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, baos);

			TransformerFactory factory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(PDFProcessor.class.getResourceAsStream(RESERVATION_XSL));
			Transformer transformer = factory.newTransformer(xslt);

			JAXBContext context = JAXBContext.newInstance(Reservation.class, JAXBResponse.class);

			JAXBSource source = new JAXBSource(context, response);

			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(source, res);
			byte[] byteArray = baos.toByteArray();

			if (logger.isDebugEnabled()) {
				showXML(context, response);
			}
			return byteArray;
		} catch (JAXBException | IOException | FOPException | TransformerException e) {
			throw new RuntimeException(e);
		}
	}

	private static void showXML(JAXBContext context, JAXBResponse response) {
		try {
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			m.marshal(response, sw);
			String xml = sw.toString();
			logger.debug(xml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@XmlRootElement(name = "hotel")
	@XmlAccessorType(XmlAccessType.FIELD)
	static class JAXBResponse {
		@XmlElementWrapper(name = "reservations")
		@XmlElement(name = "reservation")
		List<JAXBReservation> reservations;

		public JAXBResponse() {
			this.reservations = new ArrayList<>();
		}

		public JAXBResponse(List<JAXBReservation> reservations) {
			super();
			this.reservations = reservations;
		}

	}

}
