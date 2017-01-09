package com.fv.common.util;

import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

public class Error implements ToString2
{

	protected ErrorSource source;
	protected String code;
	protected String description;
	protected String uri;

	public ErrorSource getSource() {
		return source;
	}

	public void setSource(ErrorSource value) {
		this.source = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String value) {
		this.uri = value;
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
			ErrorSource theSource;
			theSource = this.getSource();
			strategy.appendField(locator, this, "source", buffer, theSource, (this.source!= null));
		}
		{
			String theCode;
			theCode = this.getCode();
			strategy.appendField(locator, this, "code", buffer, theCode, (this.code!= null));
		}
		{
			String theDescription;
			theDescription = this.getDescription();
			strategy.appendField(locator, this, "description", buffer, theDescription, (this.description!= null));
		}
		{
			String theUri;
			theUri = this.getUri();
			strategy.appendField(locator, this, "uri", buffer, theUri, (this.uri!= null));
		}
		return buffer;
	}

}
