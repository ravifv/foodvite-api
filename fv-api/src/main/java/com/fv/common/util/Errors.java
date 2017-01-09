package com.fv.common.util;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


public class Errors implements ToString2
{

	protected List<Error> errors;

	public List<Error> getErrors() {
		if (errors == null) {
			errors = new ArrayList<Error>();
		}
		return this.errors;
	}

	public String toString() {
		final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
		final StringBuilder buffer = new StringBuilder();
		append(null, buffer, strategy);
		return buffer.toString();
	}

	public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
		strategy.appendStart(locator, this, buffer);
		appendFields(locator, buffer, strategy);
		strategy.appendEnd(locator, this, buffer);
		return buffer;
	}

	public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
		{
			List<Error> theErrors;
			theErrors = (((this.errors!= null)&&(!this.errors.isEmpty()))?this.getErrors():null);
			strategy.appendField(locator, this, "errors", buffer, theErrors, ((this.errors!= null)&&(!this.errors.isEmpty())));
		}
		return buffer;
	}

}

