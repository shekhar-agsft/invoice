package com.agile.aggrement.invoice.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;


@Component
public class InvoiceUtility {

	public ResponseEntityDTO createResponseEntityDTO(HttpStatusCodes httpStatusCodes, String message, Object body) {
		return ResponseEntityDTO.response().withResponseCode(httpStatusCodes).withResponseMessage(message)
				.withResponseBody(body).build();
	}

	public ResponseEntityDTO createResponseEntityDTO(HttpStatusCodes validationError, List<ObjectError> allErrors,
			Object body) {
		return ResponseEntityDTO.response().withResponseCode(validationError).withResponseBody(allErrors)
				.withResponseBody(body).build();
	}

	public ResponseEntityDTO createResponseEntityDTO(int code, String message, Object body) {
		return ResponseEntityDTO.response().withResponseCode(code).withResponseMessage(message).withResponseBody(body)
				.build();
	}

	public ResponseEntityDTO createResponseEntityDTO(HttpStatusCodes httpStatusCodes, String message, Object body,
			String name) {
		return ResponseEntityDTO.response().withResponseCode(httpStatusCodes).withResponseMessage(message)
				.withResponseBody(body).withResponseBody(name).build();
	}
}
