package com.Ibm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.Ibm.dto.Products;

public class productsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Products.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Products products = (Products) target;

		if (products.getFile() == null || products.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "please select an image for uploading...!");
			return;

		}
		if (!(products.getFile().getContentType().equals("image/jpeg")
				|| products.getFile().getContentType().equals("image/png")
				|| products.getFile().getContentType().equals("image/jpg"))) {
			errors.rejectValue("file", null, "plase upload images files only");
			return;

		}

	}

}
