package posam.sk.accountsweb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@JsonIgnoreProperties(ignoreUnknown = false)
public record Query(String type, Value value) { }
