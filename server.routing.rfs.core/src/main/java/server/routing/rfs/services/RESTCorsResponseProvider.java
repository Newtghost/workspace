package server.routing.rfs.services;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@PreMatching
@Component
public class RESTCorsResponseProvider implements ContainerResponseFilter {

	public static final String HEADER_ORIGIN = "Origin";
	public static final String HEADER_AC_REQUEST_METHOD = "Access-Control-Request-Method";
	public static final String HEADER_AC_REQUEST_HEADERS = "Access-Control-Request-Headers";
	public static final String HEADER_AC_ALLOW_METHODS = "Access-Control-Allow-Methods";
	public static final String HEADER_AC_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	public static final String HEADER_AC_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	public static final String HEADER_AC_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	public static final String HEADER_AC_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	public static final String HEADER_AC_MAX_AGE = "Access-Control-Max-Age";

	public void filter(final ContainerRequestContext requestCtx, final ContainerResponseContext responseCtx)
			throws IOException {

		final MultivaluedMap<String, Object> headers = responseCtx.getHeaders();

		headers.add(HEADER_AC_ALLOW_ORIGIN, "*");
		headers.add(HEADER_AC_ALLOW_CREDENTIALS, "true");
		headers.add(HEADER_AC_ALLOW_HEADERS, "Content-Type, Authorization");
		headers.add(HEADER_AC_EXPOSE_HEADERS, "Item-Count");
		headers.remove(HEADER_AC_ALLOW_METHODS);
		headers.add(HEADER_AC_ALLOW_METHODS, "POST,GET,OPTIONS,HEAD,PUT,DELETE");
	}
}
