package org.dhiren.spring.springsecuritydemo.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AuthorRegistrationSource {

	@Output("authorRegistrationChannel")
	MessageChannel authorRegistration();

}